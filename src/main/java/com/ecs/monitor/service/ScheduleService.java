package com.ecs.monitor.service;

import com.ecs.monitor.bean.Proj1Log;
import com.ecs.monitor.bean.Proj1Process;
import com.ecs.monitor.common.BashFileName;
import com.ecs.monitor.service.service_interface.IProjLogService;
import com.ecs.monitor.service.service_interface.IProjParamsService;
import com.ecs.monitor.service.service_interface.IProjProcessService;
import com.ecs.monitor.utils.utils_interface.IBashExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    IBashExecutor bashExecutor;

    @Autowired
    IProjParamsService projParamsService;

    @Autowired
    IProjProcessService projProcessService;

    @Autowired
    IProjLogService projLogService;

    private List<Proj1Process> enableAndDaemonList = null;
    private int tryStartTimes = 3;//连续尝试启动次数
    private static final int delay = 5000;
    private String fileName = null;
    private Proj1Log proj1Log = null;
    private boolean processLocked = false;

    @Scheduled(fixedDelay = delay)
    public void loopService() throws IOException {
        System.out.println("the ecs monitor sys run(delay):"+delay);
        if(processLocked = false);
            scanAndResume();
    }

    /*
    查找所有的守护进程，并对未运行的进程进行处理（输出到日志并提醒重启）
     */
    public void scanAndResume() throws IOException {
        processLocked = true;
        if(enableAndDaemonList == null)
            enableAndDaemonList = projProcessService.getAllProcess(0, 1);//未删除的守护进程列表

        for(int i=0;i<enableAndDaemonList.size();i++){
            fileName = enableAndDaemonList.get(i).getPname();

            //存在进程号
            if(bashExecutor.isRunningCheck(fileName)>0){
                //检查最后一次进程记录是否为停止，若为停止，则不进行更新

                proj1Log = new Proj1Log();
                proj1Log.setPid(0);
                proj1Log.setLog("未检测到进程");
                proj1Log.setPname(fileName);
                proj1Log.setPmtUpdate(new Date());

                projLogService.insert(proj1Log);
                ProductWebSocket.sendInfo("系统消息："+fileName+"__未检测到进程！！！");
            }else{
                //进程号不存在
                for(int j=0;j<tryStartTimes;i++){
                    if(resumeProcess(fileName)){

                        proj1Log = new Proj1Log();
                        proj1Log.setPid(0);
                        proj1Log.setLog("重启成功");
                        proj1Log.setPname(fileName);
                        proj1Log.setPmtUpdate(new Date());

                        projLogService.insert(proj1Log);
                        j = tryStartTimes;  //终止循环条件
                        ProductWebSocket.sendInfo("系统消息："+fileName+"__重启成功("+j+"/"+tryStartTimes+")！！！");
                    }else{
                        proj1Log = new Proj1Log();
                        proj1Log.setPid(0);
                        proj1Log.setLog("重启失败");
                        proj1Log.setPname(fileName);

                        proj1Log.setPmtUpdate(new Date());
                        ProductWebSocket.sendInfo("系统消息："+fileName+"__启启失败("+j+"/"+tryStartTimes+")！！！");
                    }
                }
            }
        }
        processLocked = false;
    }

    public boolean resumeProcess(String fileName){
        boolean res = false;
        //if(!bashExecutor.fileExistCheck(bashFileName,fileName))
        if(fileName.contains(".jar")){
            res = bashExecutor.startJar(fileName);
        }else{

            if(fileName.contains("tomcat")){
                res = bashExecutor.startMysqlOrTomcat(BashFileName.startTomcat);
            }else if(fileName.contains("mysql")){
                res = bashExecutor.startMysqlOrTomcat(BashFileName.dockerRunMysql);
            }
        }
        return res;
    }

}
