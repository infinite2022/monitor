package com.ecs.monitor.dao;

import com.ecs.monitor.bean.Proj1Role;
import com.ecs.monitor.bean.Proj1RoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Proj1RoleMapper {
    int deleteByExample(Proj1RoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Proj1Role record);

    int insertSelective(Proj1Role record);

    List<Proj1Role> selectByExample(Proj1RoleExample example);

    Proj1Role selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Proj1Role record, @Param("example") Proj1RoleExample example);

    int updateByExample(@Param("record") Proj1Role record, @Param("example") Proj1RoleExample example);

    int updateByPrimaryKeySelective(Proj1Role record);

    int updateByPrimaryKey(Proj1Role record);
}