package com.ecs.monitor.dao;

import com.ecs.monitor.bean.Proj1Params;
import com.ecs.monitor.bean.Proj1ParamsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Proj1ParamsMapper {
    int deleteByExample(Proj1ParamsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Proj1Params record);

    int insertSelective(Proj1Params record);

    List<Proj1Params> selectByExample(Proj1ParamsExample example);

    Proj1Params selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Proj1Params record, @Param("example") Proj1ParamsExample example);

    int updateByExample(@Param("record") Proj1Params record, @Param("example") Proj1ParamsExample example);

    int updateByPrimaryKeySelective(Proj1Params record);

    int updateByPrimaryKey(Proj1Params record);
}