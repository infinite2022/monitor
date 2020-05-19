package com.ecs.monitor.controller;

import com.ecs.monitor.bean.Proj1Params;
import com.ecs.monitor.service.service_interface.IProjParamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
@RequestMapping("/params")
public class ProjParamsController {

    @Autowired
    IProjParamsService projParamsService;



    @RequestMapping("/update")
    @ResponseBody
    public String updateParams(Integer scanDelay,Integer keepLogTime,String contact,Model model){

        if(scanDelay == null && keepLogTime == null && contact == null)
            return "输入参数有误";
        Proj1Params pp = new Proj1Params();
        pp.setScanDelay(scanDelay);
        pp.setKeepLogTime(keepLogTime);
        pp.setContact(contact);
        projParamsService.updateParams(pp);

        model.addAttribute("result","修改完成，参数已更新");
        return "sys_update";
    }

    @RequestMapping("/select")
    public String selectOne(Model model){
        Proj1Params proj1Params= projParamsService.selectOne();
        if(proj1Params == null){
            proj1Params.setContact("18704592752");
            proj1Params.setKeepLogTime(168);
            proj1Params.setScanDelay(60);//1分钟
            proj1Params.setIps("本机");
            proj1Params.setIsActive(1);
            proj1Params.setPmtUpdate(new Date());
        }
        model.addAttribute("sys_params",proj1Params);
        return "setting";
    }



}
