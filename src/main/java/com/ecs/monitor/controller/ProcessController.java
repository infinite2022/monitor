package com.ecs.monitor.controller;

import com.ecs.monitor.bean.Proj1Process;
import com.ecs.monitor.service.ProjProcessService;
import com.ecs.monitor.service.service_interface.IProjProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/params")
public class ProcessController {

    @Autowired
    IProjProcessService projProcessService;

    //like=1:模糊
    @RequestMapping("/select_all")
    public String getAllListByDeleted(Integer daemon, Model model){

        List<Proj1Process> allProcess = projProcessService.getAllProcess(0,daemon);
        model.addAttribute("process",allProcess);
        return "select";
    }


    @PostMapping("/mod_one")
    public String modifyByPrimaryKey(Proj1Process proj1Process){

        projProcessService.modByPrimaryKey(proj1Process.initUpdateDate());

        return "redirect:/proc/select";
    }

    @PostMapping("/add_one")
    public String insertObj(Proj1Process proj1Process){

        projProcessService.insert(proj1Process.initDefault());

        return "redirect:/proc/select";
    }
    @RequestMapping("/del_one")
    public String delByPrimaryKey(Integer id){
        if(id == null)
            return "请求参数有误";
        projProcessService.delByPrimaryKey(id,true);
        return "redirect:/proc/select";
    }
    @RequestMapping("/init_one")
    public String getByPrimaryKey(Integer id,Model model){
        if(id != null) {
            Proj1Process byPrimaryKey = projProcessService.getByPrimaryKey(id);
            model.addAttribute("process",byPrimaryKey);
        }

        return "procmodify";
    }


    //=====================================================================================================
    //like=1:模糊
    @RequestMapping("/list_status")
    @ResponseBody
    public List<Proj1Process> getListByCondition(Integer status){
        if(status != null)
            return projProcessService.getByStatus(status);
        return null;
    }
    //like != null:模糊
    @RequestMapping("/list_like")
    @ResponseBody
    public List<Proj1Process> getListByCondition(String pname,Integer like){
        boolean condition = false;
        if(pname.trim() == null)
            return null;
        if(like != null){
            condition = true;
        }
        return projProcessService.getByPname(pname.trim(),condition);
    }

}
