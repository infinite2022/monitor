package com.ecs.monitor.service.service_interface;

import com.ecs.monitor.bean.Proj1Log;

import java.util.Date;
import java.util.List;

public interface IProjLogService {

    void insert(Proj1Log proj1Log);
    List<Proj1Log> selectByTime(Date startTime, Date stopTime);
    List<Proj1Log> selectByDays(Date startTime, Date stopTime);
    void deleteByTime(Date time, Integer condition, Boolean dateType);

}
