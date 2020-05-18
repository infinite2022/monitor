package com.ecs.monitor.service;

import com.ecs.monitor.bean.Proj1Log;
import com.ecs.monitor.bean.Proj1LogExample;
import com.ecs.monitor.dao.Proj1LogMapper;
import com.ecs.monitor.service.service_interface.IProjLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("projLogService")
public class ProjLogService implements IProjLogService {

    @Autowired(required = false)
    Proj1LogMapper proj1LogMapper;
    private Proj1LogExample proj1LogExample;

    private static SimpleDateFormat ymdhms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
    private static String hmsString =" 00:00:00";

    @Override
    public void insert(Proj1Log proj1Log) {
        proj1LogMapper.insert(proj1Log);
    }

    @Override
    public List<Proj1Log> selectByTime(Date startTime, Date stopTime) {
        proj1LogExample = new Proj1LogExample();
        Proj1LogExample.Criteria criteria = proj1LogExample.createCriteria();
        criteria.andPmtUpdateBetween(startTime,stopTime);

        return proj1LogMapper.selectByExample(proj1LogExample);
    }
    public Date toDayValue(Date target){
        Date result = null;
        try {
            result = ymdhms.parse(ymd.format(target)+hmsString);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("输入时间格式有误");
        }
        return result;
    }

    @Override
    public List<Proj1Log> selectByDays(Date startTime, Date stopTime) {
        proj1LogExample = new Proj1LogExample();
        Proj1LogExample.Criteria criteria = proj1LogExample.createCriteria();

        criteria.andPmtUpdateBetween(toDayValue(startTime),toDayValue(stopTime));
        return proj1LogMapper.selectByExample(proj1LogExample);
    }

    //condition 1:在于等于,0 等于:-1：小于
    @Override
    public void deleteByTime(Date time, Integer condition,Boolean dateType) {
        proj1LogExample = new Proj1LogExample();
        Proj1LogExample.Criteria criteria = proj1LogExample.createCriteria();

        if(dateType = true)
            time = toDayValue(time);

        if(condition >0){
            criteria.andPmtUpdateGreaterThan(time);
        }else if(condition <0){
            criteria.andPmtUpdateLessThan(time);
        }else{
            criteria.andPmtUpdateEqualTo(time);
        }

        proj1LogMapper.deleteByExample(proj1LogExample);
    }

}
