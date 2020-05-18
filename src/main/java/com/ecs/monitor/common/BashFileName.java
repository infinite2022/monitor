package com.ecs.monitor.common;

/*
    fileExistCheck.sh   //文件检查-参数：（绝对路径+文件名=全路径文件名）
    isRunningCheck.sh   //进程序是否运行中-参数:（输入文件名称，可以用mysql,tomcat,jar包的文件名，比如xx.jar）
    startTomcat.sh      //启动tomcat-无参数
    dockerRunMysql.sh   //启动mysql-无参数:
    startJar.sh         //运行jar包文件-参数：
 */

public enum BashFileName {
    fileExistCheck,
    isRunningCheck,
    startTomcat,
    dockerRunMysql,
    killProcess,
    startJar;
}
