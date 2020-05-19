package com.ecs.monitor.service.service_interface;

import com.ecs.monitor.bean.Proj1Role;

import java.util.List;

public interface IProjRoleService {
    //添加用户
    void addRole(Proj1Role proj1Role);
    //删除用户
    void delByMobile(String mobile,boolean disableDisplayOnly);
    //通过手机号修改用户
    void modByMobile(Proj1Role proj1Role);
    //查询
    Proj1Role getByMobile(String mobile);

    //查询(deleted：null=all,1=normal,0=deleted)
    List<Proj1Role> getAllByDeleted(Integer deleted);
    Proj1Role getByObject(Proj1Role proj1Role);
}
