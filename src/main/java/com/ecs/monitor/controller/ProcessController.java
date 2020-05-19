package com.ecs.monitor.controller;

import com.ecs.monitor.bean.Proj1Process;
import com.ecs.monitor.service.ProjProcessService;
import com.ecs.monitor.service.service_interface.IProjProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping("/item")
    @ResponseBody
    public Proj1Process getByPrimaryKey(Integer id){
        if(id != null)
            return projProcessService.getByPrimaryKey(id);
        return null;
    }

    //like=1:模糊
    @RequestMapping("/list_all")
    public String getAllListByDeleted(Integer deleted, Model model){

        List<Proj1Process> allProcess = projProcessService.getAllProcess(0);
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
    @ResponseBody
    public String delByPrimaryKey(Integer id,Integer disably_only){
        if(id == null)
            return "请求参数有误";
        boolean condition = false;
        if(disably_only !=null)
            condition = true;
        projProcessService.delByPrimaryKey(id,condition);
        return "delete_success";
    }

    @RequestMapping("/mod_item")
    @ResponseBody
    public String modifyByPrimaryKey(@RequestParam(name ="id",defaultValue = "",required = true) Integer id,
                                     @RequestParam(name="pid",defaultValue = "",required = false) Integer pid,
                                     @RequestParam(name = "pname",defaultValue = "",required = false) String pname,
                                     @RequestParam(name ="fpath",defaultValue = "",required = false) String fpath,
                                     @RequestParam(name = "status",defaultValue = "",required = false) Integer status,
                                     @RequestParam(name ="daemon",defaultValue = "",required = false)Integer daemon){

        if(id == null)
            return "请求参数有误";
        if(pid == null && pname == null && fpath == null && status == null&&daemon == null)
            return "请求参数有误";
        Proj1Process proj1Process = projProcessService.getByPrimaryKey(id);

        proj1Process.setId(id);
        if(pid != null)
            proj1Process.setPid(pid);
        if(pname != null)
            proj1Process.setPname(pname);
        if(fpath != null)
            proj1Process.setFpath(fpath);
        if(status != null)
            proj1Process.setStatus(status);

        projProcessService.modByPrimaryKey(proj1Process.initUpdateDate());
        return "modify_success";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String insertObj(@RequestParam(name="pid",defaultValue = "",required = false) Integer pid,
                            @RequestParam(name = "pname",defaultValue = "",required = true) String pname,
                            @RequestParam(name ="fpath",defaultValue = "",required = true) String fpath,
                            @RequestParam(name = "status",defaultValue = "",required = false) Integer status,
                            @RequestParam(name ="daemon",defaultValue = "",required = false)Integer daemon
                            ){
        if(pname.trim() == null || fpath.trim() == null)
            return "请求参数有误";
        Proj1Process proj1Process = new Proj1Process();
        if(pid == null)
            pid = 0;
            proj1Process.setPid(pid);
            proj1Process.setPname(pname);
            proj1Process.setFpath(fpath);
            proj1Process.setStatus(status);
            if(daemon == null)
                daemon = 0;
            proj1Process.setDaemon(daemon);

        projProcessService.insert(proj1Process.initDefault());
        return "insert_success";
    }
}
