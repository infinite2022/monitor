package com.ecs.monitor.service;

import com.ecs.monitor.bean.Proj1Params;
import com.ecs.monitor.bean.Proj1ParamsExample;
import com.ecs.monitor.dao.Proj1ParamsMapper;
import com.ecs.monitor.service.service_interface.IProjParamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("/projParamsService")
public class ProjParamsService implements IProjParamsService {

    @Autowired(required = false)
    Proj1ParamsMapper proj1ParamsMapper;

    @Override
    public List<String> parseList(String s){
        ArrayList<String> arrayList = new ArrayList<>();
        if(s.contains(",")) {
            String tmp[] = s.split(",");
            for(int i=0;i<tmp.length;i++){
                String tmpItem = tmp[i].trim();
                if(tmpItem != null){
                    if(!arrayList.contains(tmpItem))
                        arrayList.add(tmpItem);
                }
            }
        }else{
            arrayList.add(s);
        }
        return arrayList;
    }

    @Override
    public Proj1Params paramsPatch(Proj1Params source,Proj1Params target){
        if(target.getScanDelay() != null)
            source.setScanDelay(target.getScanDelay());
        if(target.getKeepLogTime() != null)
            source.setKeepLogTime(target.getKeepLogTime());
        if(target.getContact() != null){
            source.setContact(target.getContact());
        }
        return source;
    }

    @Override
    public void updateParams(Proj1Params proj1Params) {
        List<Proj1Params> pps = proj1ParamsMapper.selectByExample(null);
        Proj1Params pp = null;
        if(pps != null){
            pp = paramsPatch(pps.get(0),proj1Params);
            proj1ParamsMapper.updateByPrimaryKey(pp);
        }else{
            proj1ParamsMapper.insert(proj1Params);
        }

    }

    @Override
    public Proj1Params selectOne() {
        List<Proj1Params> pps = proj1ParamsMapper.selectByExample(null);
        if(pps != null)
            return pps.get(0);
        return null;
    }
}
