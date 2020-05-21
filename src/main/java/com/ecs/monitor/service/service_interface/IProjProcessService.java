package com.ecs.monitor.service.service_interface;


import com.ecs.monitor.bean.Proj1Process;

import java.util.List;

public interface IProjProcessService {

    //查询所有的
    List<Proj1Process> getAllProcess(Integer deleted, Integer daemon);
    //查询：指定状态的进程(不处理已删除的对象)
    List<Proj1Process> getByStatus(Integer status);
    //查询：根据名称查询
    List<Proj1Process> getByPname(String pname, boolean like);
    //根据主键查询
    Proj1Process getByPrimaryKey(Integer id);
    //删除
    void delByPrimaryKey(int id, boolean disableDisplayOnly);
    //修改
    void modByPrimaryKey(Proj1Process proj1Process);
    //插入
    void insert(Proj1Process proj1Process);

}
