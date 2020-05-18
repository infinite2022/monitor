package com.ecs.monitor.utils;

import ch.qos.logback.core.util.FileUtil;
import com.ecs.monitor.common.BashFileName;
import com.ecs.monitor.common.EnumMsg;
import com.ecs.monitor.utils.utils_interface.IBashExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.validation.constraints.NotNull;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

    /*
    fileExistCheck.sh   //文件检查-参数：（绝对路径+文件名=全路径文件名）
    isRunningCheck.sh   //进程序是否运行中-参数:（输入文件名称，可以用mysql,tomcat,jar包的文件名，比如xx.jar）
    startJar.sh         //运行jar包文件-参数：（绝对路径+文件名=全路径文件名）
    startTomcat.sh      //启动tomcat-无参数
    dockerRunMysql.sh   //启动mysql-无参数:
    dockerPsCheck.sh    //dock ps 命令（绝对路径+文件名=全路径文件名）

     */

@Component("bashExecutor")
public class BashExecutor implements IBashExecutor {

    private static String bashCommand = "/bin/bash";
    private static String bashParams = "-c";

    /**
     * 检查bash文件或jar文件是否存在
     * @param bashFileName
     * @param fileName
     * @return
     */
    @Override
    public EnumMsg fileExistCheck(@NotNull BashFileName bashFileName,@NotNull String fileName) {

        String fileInfo = BashFileName.fileExistCheck.name()+".sh "+fileName;

        ProcessBuilder processBuilder = new ProcessBuilder(bashCommand,bashParams,fileInfo);
        processBuilder.redirectErrorStream(true);

        List<String> tmp = baseBashExecutor(processBuilder);
        for(int i=0;i<tmp.size();i++){
            if(tmp.get(i).contains("exist"))
                return EnumMsg.FILE_IS_EXISTS;//文件已存在
            return EnumMsg.FILE_IS_NOT_EXISTS;//文件不存在
        }
        return EnumMsg.BASH_OPERATION_FAILURE;//脚本执行失败
    }

    /**
     * 检查指定名称的进程序是否存在
     * @param fileName
     * @return
     */
    @Override
    public int isRunningCheck(@NotNull String fileName) {

        String fileInfo = BashFileName.isRunningCheck.name()+".sh "+fileName;
        ProcessBuilder processBuilder = new ProcessBuilder(bashCommand,bashParams,fileInfo);
        processBuilder.redirectErrorStream(true);

        List<String> tmp = baseBashExecutor(processBuilder);
        int i = extractThreadNumViaList(tmp,fileName);
        return i;
    }

    /**
     * 运行指定的jar包文件，并生成同名的.log日志文件
     * @param fileName
     * @return
     */
    @Override
    public boolean startJar(@NotNull String fileName) {

        String fileInfo = BashFileName.startJar.name()+".sh "+fileName;
        ProcessBuilder processBuilder = new ProcessBuilder(bashCommand,bashParams,fileInfo);
        processBuilder.redirectErrorStream(true);

        return baseBashExecutorOnly(processBuilder);
    }

    /**
     * 终止指定端口号的进程
     * @param processId
     * @return
     */
    @Override
    public boolean killProcess(@NotNull int processId){
        String fileInfo = BashFileName.killProcess+".sh "+processId;
        ProcessBuilder processBuilder = new ProcessBuilder(bashCommand,bashParams,fileInfo);
        processBuilder.redirectErrorStream(true);
        return baseBashExecutorOnly(processBuilder);
    }
    /**
     * 运行mysql或tomcat文件
     * @param bashFileName
     * @return
     */
    @Override
    public boolean startMysqlOrTomcat(@NotNull BashFileName bashFileName){
        String fileInfo = bashFileName.name()+".sh";
        ProcessBuilder processBuilder = new ProcessBuilder(bashCommand,bashParams,fileInfo);
        processBuilder.redirectErrorStream(true);

        if(bashFileName.name().equals(BashFileName.startTomcat.name())){
            return baseBashExecutorOnly(processBuilder);
        }else if(bashFileName.name().equals(BashFileName.dockerRunMysql.name())){
            return baseBashExecutorOnly(processBuilder);
        }
        return false;
    }

    /**
     * 执行指定的bash文件，执行完成返回true，否则返回false
     * @param processBuilder
     * @return 执行结果
     */
    @Override
    public boolean baseBashExecutorOnly(@NotNull ProcessBuilder processBuilder){
        Process process = null;
        try{
            process = processBuilder.start();
        }catch(IOException e){
            e.printStackTrace();
            return false;
        }
        try{
            int res = process.waitFor();
            if(res==0) return true;
            return false;

        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 执行并返回输出内容
     * @param processBuilder
     * @return
     */
    @Override
    public List<String> baseBashExecutor(@NotNull ProcessBuilder processBuilder){
        ArrayList<String> resultList = new ArrayList<>();
        Process process = null;
        try{
            process = processBuilder.start();
        }catch(IOException e){
            e.printStackTrace();
            resultList.add(e.getMessage());
            return resultList;
        }
        try{
            if(process != null){
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                   resultList.add(line);
                }
            }
            int result = process.waitFor();
            if(result==0) resultList.add(EnumMsg.OPERATION_COMPLETE.getMsg());
            return resultList;

        }catch (IOException e){

            e.printStackTrace();
            resultList.add(e.getMessage());
            return resultList;
        } catch (InterruptedException e) {

            e.printStackTrace();
            resultList.add(e.getMessage());
            return resultList;
        }
    }

    /**
     * 取出查询信息中的进程号
     * @param target
     * @param keyWord
     * @return  大于100为进程号
     */
    @Override
    public int extractThreadNumViaList(List<String> target,String keyWord){
        int result = -1;
        if(target == null | keyWord == null)
            return result;

        for(int i=0;i<target.size();i++){
            String item = target.get(i).trim();
            if(item.contains(keyWord)){
                String[] tmp = item.replaceAll("\\s{1,}"," ").split(" ");
                if(RegularUtil.checkNumber(tmp[1]))
                    return Integer.parseInt(tmp[1]);
            }
        }
        return result;
    }

    /**
     * @param target
     * @param keyWord
     * @return  取出查询信息中的进程号
     */
    @Override
    public int extractThreadNumViaString(@NotNull String target,String keyWord){
        int result = -1;
        if(target == null | keyWord == null)
            return result;

        if(target.contains("\n")){
            String[] items = target.split("\n");
            for(int i=0;i<items.length;i++){
                if(items[i].contains(keyWord)){
                    String[] tmp = items[i].replaceAll("\\s{1,}"," ").split(" ");
                    if(RegularUtil.checkNumber(tmp[1]))
                        return Integer.parseInt(tmp[1]);
                }
            }
        }else{
            if(target.contains(keyWord)){
                String[] tmp = target.replaceAll("\\s{1,}"," ").split(" ");
                if(RegularUtil.checkNumber(tmp[1]))
                    return Integer.parseInt(tmp[1]);
            }
        }
        return result;
    }
}
