package com.ecs.monitor.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {

    static final int delay = 1000;
    @Scheduled(fixedDelay = delay)
    public void loopService(){
        System.out.println("execute:"+delay);
    }


}
