package com.ecs.monitor.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class MvcPlusConfig implements WebMvcConfigurer {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");

    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
//    }



}
