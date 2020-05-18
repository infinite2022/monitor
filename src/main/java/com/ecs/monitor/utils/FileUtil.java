package com.ecs.monitor.utils;

import com.ecs.monitor.utils.utils_interface.IFileUtil;
import org.springframework.stereotype.Component;

@Component
public class FileUtil implements IFileUtil {
    public String generalFileInfo(String absoluteFilePath,String fileName){
        return absoluteFilePath+fileName;
    }
}
