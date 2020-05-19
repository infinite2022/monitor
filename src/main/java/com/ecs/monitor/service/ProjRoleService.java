package com.ecs.monitor.service;

import com.ecs.monitor.bean.Proj1Role;
import com.ecs.monitor.bean.Proj1RoleExample;
import com.ecs.monitor.dao.Proj1RoleMapper;
import com.ecs.monitor.service.service_interface.IProjRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("projRoleService")
public class ProjRoleService implements IProjRoleService {

    @Autowired(required = false)
    Proj1RoleMapper proj1RoleMapper;

    private Proj1RoleExample proj1RoleExample;

    //添加用户
    @Override
    public void addRole(Proj1Role proj1Role){
        proj1RoleMapper.insert(proj1Role);
    }
    //删除用户
    @Override
    public void delByMobile(String mobile,boolean disableDisplayOnly){
        proj1RoleExample = new Proj1RoleExample();
        Proj1RoleExample.Criteria criteria = proj1RoleExample.createCriteria();
        criteria.andMobileEqualTo(mobile);

        if(disableDisplayOnly){
            Proj1Role proj1Role = getByMobile(mobile);
            proj1Role.setDeleted(1);
            proj1RoleMapper.updateByExample(proj1Role,proj1RoleExample);
        }else{
            proj1RoleMapper.deleteByExample(proj1RoleExample);
        }
    }
    //通过手机号修改用户
    @Override
    public void modByMobile(Proj1Role proj1Role){
        proj1RoleExample = new Proj1RoleExample();
        Proj1RoleExample.Criteria criteria = proj1RoleExample.createCriteria();
        criteria.andMobileEqualTo(proj1Role.getMobile());

        proj1RoleMapper.updateByExample(proj1Role,proj1RoleExample);
    }
    //查询
    @Override
    public Proj1Role getByMobile(String mobile){
        proj1RoleExample = new Proj1RoleExample();
        Proj1RoleExample.Criteria criteria = proj1RoleExample.createCriteria();
        criteria.andMobileEqualTo(mobile);
        if(proj1RoleMapper.selectByExample(proj1RoleExample)!=null)
            return proj1RoleMapper.selectByExample(proj1RoleExample).get(0);
        return null;
    }

    //查询(deleted：null=all,1=normal,0=deleted)
    @Override
    public List<Proj1Role> getAllByDeleted(Integer deleted){
        proj1RoleExample = new Proj1RoleExample();
        Proj1RoleExample.Criteria criteria = proj1RoleExample.createCriteria();
        if(deleted != null){
            criteria.andDeletedEqualTo(deleted);
            return proj1RoleMapper.selectByExample(proj1RoleExample);
        }else{
            return proj1RoleMapper.selectByExample(null);
        }
    }
    @Override
    public Proj1Role getByObject(Proj1Role proj1Role){
        proj1RoleExample = new Proj1RoleExample();
        Proj1RoleExample.Criteria criteria = proj1RoleExample.createCriteria();
        criteria.andMobileEqualTo(proj1Role.getMobile());
        criteria.andPasswordEqualTo(proj1Role.getPassword());

        if(proj1RoleMapper.selectByExample(proj1RoleExample)!=null)
            return proj1RoleMapper.selectByExample(proj1RoleExample).get(0);
        return null;
    }

}
