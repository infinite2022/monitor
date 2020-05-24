package com.ecs.monitor.controller;

import com.ecs.monitor.bean.Proj1Log;
import com.ecs.monitor.bean.Proj1Process;
import com.ecs.monitor.common.BashFileName;
import com.ecs.monitor.service.SystemNotify;
import com.ecs.monitor.service.service_interface.IProjLogService;
import com.ecs.monitor.service.service_interface.IProjProcessService;
import com.ecs.monitor.utils.utils_interface.IBashExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("prog")
public class ProgramAndLogsController {

    @Autowired
    private IBashExecutor bashExecutor;

    @Autowired
    private IProjProcessService projProcessService;

    @Autowired
    private IProjLogService projLogService;

    @RequestMapping("/startone")
    public void start(String fileName) throws IOException {
        if(fileName.contains(".jar")){
            bashExecutor.startJar(fileName);
        }else{
            if(fileName.contains("tomcat")){
                bashExecutor.startMysqlOrTomcat(BashFileName.startTomcat);
            }else if(fileName.contains("mysql")){
                bashExecutor.startMysqlOrTomcat(BashFileName.dockerRunMysql);
            }
        }
        SystemNotify.sendInfo("the"+fileName+"process start complete!!" );
    }
    @RequestMapping("/killone")
    public void stop(Integer pid) throws IOException {
        bashExecutor.killProcess(pid);
        SystemNotify.sendInfo("the"+pid+"process is killed!!" );
    }

    @RequestMapping("/restart")
    public void restart(String fileName) throws IOException {

        List<Proj1Process> byPname = projProcessService.getByPname(fileName, false);
        for(int i=0;i<byPname.size();i++){
            if(byPname.get(i).getPid()>0){
                boolean b = bashExecutor.killProcess(byPname.get(i).getPid());
            }
            start(fileName);
            SystemNotify.sendInfo("the"+fileName+"process is killed!!" );
        }
    }

    @RequestMapping("/log")
    public String log(Model model){
        List<Proj1Log> proj1Logs = projLogService.selectByTime(new Date(), null);
        model.addAttribute("logs",proj1Logs);
        return "main";
    }
    @RequestMapping("/history_log")
    public String hostoryLog(){
        projLogService.selectByDays(null,new Date());
        return "logs";
    }


}
