package com.ecs.monitor.utils.utils_interface;

import com.ecs.monitor.common.BashFileName;
import com.ecs.monitor.common.EnumMsg;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface IBashExecutor {

    /**
     * 检查bash文件或jar文件是否存在
     */
    EnumMsg fileExistCheck(@NotNull BashFileName bashFileName, @NotNull String fileName);
    /**
     * 检查指定名称的进程序是否存在
     */
    int isRunningCheck(@NotNull String fileName);

    /**
     * 运行指定的jar包文件，并生成同名的.log日志文件
     */
    boolean startJar(@NotNull String fileName);

    /**
     * 终止指定端口号的进程
     */
    boolean killProcess(@NotNull int processId);
    /**
     * 运行mysql或tomcat文件
     */
    boolean startMysqlOrTomcat(@NotNull BashFileName bashFileName);

    /**
     * 执行指定的bash文件，执行完成返回true，否则返回false
     */
    boolean baseBashExecutorOnly(@NotNull ProcessBuilder processBuilder);

    /**
     * 执行并返回输出内容
     */
    List<String> baseBashExecutor(@NotNull ProcessBuilder processBuilder);

    /**
     * @return  取出查询信息中的进程号
     */
    int extractThreadNumViaList(List<String> target, String keyWord);

    int extractThreadNumViaString(@NotNull String target,String keyWord);


}
