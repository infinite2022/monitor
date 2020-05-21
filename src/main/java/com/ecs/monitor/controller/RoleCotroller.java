package com.ecs.monitor.controller;

import com.ecs.monitor.bean.Proj1Role;
import com.ecs.monitor.bean.Proj1RoleExample;
import com.ecs.monitor.service.service_interface.IProjRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class RoleCotroller {

    @Autowired
    IProjRoleService projRoleService;

    private Proj1RoleExample proj1RoleExample;

    @RequestMapping("/add")
    @ResponseBody
    public String addUser(@RequestParam(name ="mobile",defaultValue = "",required = true) String mobile,
                          @RequestParam(name ="password",defaultValue = "",required = true)String password,
                          @RequestParam(name ="level",defaultValue = "",required = false)Integer level){
        Proj1Role proj1Role = new Proj1Role();
        if(mobile.trim()== null||password.trim() == null)
            return "请求参数有误";

        proj1Role.setMobile(mobile);
        proj1Role.setPassword(password);
        int tmpLevel = 0;
        if(level != null)
            tmpLevel = level;
            proj1Role.setLevel(tmpLevel);

        projRoleService.addRole(proj1Role.initDefault());
        return "add_success";
    }

    @PostMapping("/login")
    public String login(@RequestParam("mobile") String mobile, @RequestParam("password") String password, Map<String,Object> map, HttpSession session){

            if(mobile == null || password == null){
                map.put("msg","用户名或密码错误");
                return "login";
            }
        System.out.println(mobile+"password"+password);
            Proj1Role proj1Role = new Proj1Role();
            proj1Role.setMobile(mobile);
            proj1Role.setPassword(password);
            if(projRoleService.getByObject(proj1Role) != null){
                session.setAttribute("loginUser",mobile);//加入session
                return "main";  //"redirect:/main";
            }
        return "login";
    }

    @RequestMapping("/del_by_mobile")
    @ResponseBody
    public String deleteByMobile(@RequestParam(name ="mobile",defaultValue = "",required = true) String mobile,
                                 @RequestParam(name = "disable_only",defaultValue = "true",required = false) String displayOnly){
        if(mobile.trim() == null)
            return "请求参数有误";
        Boolean condition = false;
        if(displayOnly.trim() != "false")
            condition = true;
        projRoleService.delByMobile(mobile.trim(),condition);
        return "delete_success";
    }
    @RequestMapping("/mod_by_mobile")
    @ResponseBody
    public String modifyByMobile(String mobile,String password,Integer level,Integer version,Integer deleted){
        if(mobile.trim()== null)
            return "请求参数有误";
        Proj1Role byMobile = projRoleService.getByMobile(mobile);
        if(password != null)
            byMobile.setPassword(password);
        if(level != null)
            byMobile.setLevel(level);
        if(version != null)
            byMobile.setVersion(version);
        if(deleted != null)
            byMobile.setDeleted(deleted);

        projRoleService.modByMobile(byMobile.initUpdateDate());

        return "delete_success";
    }
    @RequestMapping("/item_by_mobile")
    @ResponseBody
    public Proj1Role getByMobile(String mobile){
        if(mobile != null)
            return projRoleService.getByMobile(mobile);
        return null;
    }
    @RequestMapping("/list_by_deleted")
    @ResponseBody
    //查询(deleted：null=all,1=normal,0=deleted)
    public String getAllByDeleted(Integer deleted){
        System.out.println(deleted);
       //projRoleService.getAllByDeleted(deleted);
       return "proc";
    }
    @RequestMapping("/test0")
    public String test0(Map<String,Object> map){
        List<Proj1Role> allByDeleted = projRoleService.getAllByDeleted(null);

        map.put("hello","<h1>登录成功</h1>");
        map.put("role",allByDeleted);
        return "proc";
    }
    @RequestMapping("/test1")
    public String test1(Model model){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("sina");
        strings.add("123");
        model.addAttribute("items",strings);

        return "test1";
    }
}
