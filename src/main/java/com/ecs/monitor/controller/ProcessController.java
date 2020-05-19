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
@RequestMapping("proc")
public class ProcessController {

    @Autowired
    IProjProcessService projProcessService;

    //like=1:模糊
    @RequestMapping("/list_all")
    public String getAllListByDeleted(Integer deleted,Integer daemon, Model model){

        List<Proj1Process> allProcess = projProcessService.getAllProcess(0,daemon);
        model.addAttribute("process",allProcess);
        return "proc";
    }


    @PostMapping("/mod_item")
    public String modifyByPrimaryKey(@RequestParam(name = "id",defaultValue = "",required = true)Integer id,
                                     @RequestParam(name = "pname",defaultValue = "",required = false) String pname,
                                     @RequestParam(name ="fpath",defaultValue = "",required = false) String fpath,
                                     @RequestParam(name ="status",defaultValue = "",required = false) Integer status,
                                     @RequestParam(name = "deleted",defaultValue = "",required = false) Integer deleted,
                                     @RequestParam(name ="daemon",defaultValue = "",required = false)Integer daemon,
                                     @RequestParam("mobile") String mobile,
                                     @RequestParam("password") String password,
                                     Model model){

        if(mobile == null || password == null){
            return "proc";
        }
        if(id == null)
            return "请求参数有误";
        if(pname == null && fpath == null && daemon == null&&daemon == null)
            return "请求参数有误";
        Proj1Process proj1Process = projProcessService.getByPrimaryKey(id);

        proj1Process.setId(id);

        if(pname != null)
            proj1Process.setPname(pname);
        if(fpath != null)
            proj1Process.setFpath(fpath);
        if(status != null)
            proj1Process.setStatus(status);

        projProcessService.modByPrimaryKey(proj1Process.initUpdateDate());

        List<Proj1Process> allProcess = projProcessService.getAllProcess(0,1);
        model.addAttribute("process",allProcess);
        return "proc";
    }

    @PostMapping("/add")
    public String insertObj(@RequestParam(name = "pname",defaultValue = "",required = true) String pname,
                            @RequestParam(name ="fpath",defaultValue = "",required = true) String fpath,
                            @RequestParam(name = "deleted",defaultValue = "",required = false) Integer deleted,
                            @RequestParam(name ="daemon",defaultValue = "",required = false)Integer daemon,
                            @RequestParam("mobile") String mobile,
                            @RequestParam("password") String password,
                            Model model
                            ){

        if(mobile == null || password == null){
            return "proc";
        }

        if(pname.trim() == null || fpath.trim() == null)
            return "请求参数有误";
        Proj1Process proj1Process = new Proj1Process();

        proj1Process.setPid(0);
        proj1Process.setPname(pname);
        proj1Process.setFpath(fpath);
        proj1Process.setStatus(0);
        if(daemon == null)
            daemon = 0;
        proj1Process.setDaemon(daemon);
        if(deleted == null)
            deleted = 0;
        proj1Process.setDeleted(0);

        projProcessService.insert(proj1Process.initDefault());

        List<Proj1Process> allProcess = projProcessService.getAllProcess(0,1);
        model.addAttribute("process",allProcess);
        return "proc";
    }
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
    @RequestMapping("/del_item")
    public String delByPrimaryKey(Integer id){
        if(id == null)
            return "请求参数有误";
        projProcessService.delByPrimaryKey(id,true);
        return "proc";
    }
    @RequestMapping("/item")
    @ResponseBody
    public Proj1Process getByPrimaryKey(Integer id){
        if(id != null)
            return projProcessService.getByPrimaryKey(id);
        return null;
    }

}
