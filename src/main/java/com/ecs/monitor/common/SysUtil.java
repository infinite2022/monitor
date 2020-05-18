package com.ecs.monitor.common;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

@Component("sysUtil")
public class SysUtil {

    private static String language = "en";
    private int delay = 1000;

    public static void setLanguage(String language) {
        SysUtil.language = language;
    }
    public static String getLanguage() {
        return language;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        if(delay<(2*1000) ||delay >30*1000*60)
            return;
        this.delay = delay;
    }
}
