package com.ecs.monitor.controller;

import com.ecs.monitor.bean.Proj1Params;
import com.ecs.monitor.service.service_interface.IProjParamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/params")
public class ProjParamsController {

    @Autowired
    IProjParamsService projParamsService;



    @RequestMapping("/update")
    @ResponseBody
    public String updateParams(Integer scanDelay,Integer keepLogTime,String contact){

        if(scanDelay == null && keepLogTime == null && contact == null)
            return "输入参数有误";
        Proj1Params pp = new Proj1Params();
        pp.setScanDelay(scanDelay);
        pp.setKeepLogTime(keepLogTime);
        pp.setContact(contact);

        projParamsService.updateParams(pp);
        return "update_success";
    }


    @RequestMapping("/select")
    @ResponseBody
    public Proj1Params selectOne(){
        return projParamsService.selectOne();
    }


}
