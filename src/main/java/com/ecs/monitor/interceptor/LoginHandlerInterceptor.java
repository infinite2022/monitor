package com.ecs.monitor.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object obj = request.getSession().getAttribute("loginUser");
        if(obj == null){
            //没有登录，设置错误信息并转发到登录页面
            request.setAttribute("msg","请先登陆，获取权限！！");
            request.getRequestDispatcher("/index.html").forward(request,response);
            return false;
        }else{

            return true; //已登录，放行
        }
    }
}