package com.ecs.monitor.service.service_interface;

import com.ecs.monitor.bean.Proj1Params;

import java.util.List;

public interface IProjParamsService {

    void updateParams(Proj1Params proj1Params);

    Proj1Params selectOne();

    List<String> parseList(String s);
    Proj1Params paramsPatch(Proj1Params source,Proj1Params target);
}
