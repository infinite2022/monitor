package com.ecs.monitor.dao;

import com.ecs.monitor.bean.Proj1Process;
import com.ecs.monitor.bean.Proj1ProcessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Proj1ProcessMapper {
    int deleteByExample(Proj1ProcessExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Proj1Process record);

    int insertSelective(Proj1Process record);

    List<Proj1Process> selectByExample(Proj1ProcessExample example);

    Proj1Process selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Proj1Process record, @Param("example") Proj1ProcessExample example);

    int updateByExample(@Param("record") Proj1Process record, @Param("example") Proj1ProcessExample example);

    int updateByPrimaryKeySelective(Proj1Process record);

    int updateByPrimaryKey(Proj1Process record);
}