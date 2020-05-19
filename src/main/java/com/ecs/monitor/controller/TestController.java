package com.ecs.monitor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tt")
public class TestController {

    @RequestMapping("/login")
    public String loging(){
        return "login";
    }
    @RequestMapping("/main")
    public String test(){
        return "main";
    }
}
