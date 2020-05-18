package com.ecs.monitor.dao;

import com.ecs.monitor.bean.Proj1Log;
import com.ecs.monitor.bean.Proj1LogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Proj1LogMapper {
    int deleteByExample(Proj1LogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Proj1Log record);

    int insertSelective(Proj1Log record);

    List<Proj1Log> selectByExample(Proj1LogExample example);

    Proj1Log selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Proj1Log record, @Param("example") Proj1LogExample example);

    int updateByExample(@Param("record") Proj1Log record, @Param("example") Proj1LogExample example);

    int updateByPrimaryKeySelective(Proj1Log record);

    int updateByPrimaryKey(Proj1Log record);
}