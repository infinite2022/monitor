package com.ecs.monitor.controller;

import com.ecs.monitor.bean.Proj1Params;
import com.ecs.monitor.service.service_interface.IProjParamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/params")
public class ProjParamsController {

    @Autowired
    IProjParamsService projParamsService;



    @RequestMapping("/update")
    public String updateParams(@RequestParam(value = "scanDelay",required = false) Integer scanDelay, @RequestParam(value = "keepLogTime",required = false) Integer keepLogTime, @RequestParam(value = "contact",required = false) String contact, Model model){
        Proj1Params pp = new Proj1Params();
//        if(scanDelay == null && keepLogTime == null && contact == null){
//
//            model.addAttribute("sys_params",pp);
//            return "main";
//        }
        if(scanDelay != null)
            pp.setScanDelay(scanDelay);
        if(keepLogTime != null)
            pp.setKeepLogTime(keepLogTime);
        if(contact != null)
            pp.setContact(contact);
        projParamsService.updateParams(pp);

        Proj1Params newOne= projParamsService.selectOne();

        model.addAttribute("sys_params",newOne);
        return "main";
    }

    @RequestMapping("/modify")
    public String modify(Model model){

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

        return "modify_params";
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
        return "params";
    }

    @PostMapping("/update_obj")
    public String updateParams(Proj1Params proj1Params){
        proj1Params.setPmtUpdate(new Date());
        System.out.println("收到请求"+proj1Params.getContact());
        projParamsService.updateParams(proj1Params);

        return "redirect:/params/update";
    }


}
