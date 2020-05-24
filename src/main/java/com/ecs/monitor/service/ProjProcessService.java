package com.ecs.monitor.service;

import com.ecs.monitor.bean.Proj1Process;
import com.ecs.monitor.bean.Proj1ProcessExample;
import com.ecs.monitor.dao.Proj1ProcessMapper;
import com.ecs.monitor.service.service_interface.IProjProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProjProcessService implements IProjProcessService {

    @Autowired(required = false)
    Proj1ProcessMapper proj1ProcessMapper;

    private Proj1ProcessExample proj1ProcessExample;

    //查询所有的
    @Override
    public List<Proj1Process> getAllProcess(Integer deleted,Integer daemon){
        proj1ProcessExample = new Proj1ProcessExample();
        Proj1ProcessExample.Criteria criteria = proj1ProcessExample.createCriteria();
        if(deleted != null)
            criteria.andDeletedEqualTo(deleted);
        if(daemon != null)
            criteria.andDaemonEqualTo(daemon);
        if(daemon != null || deleted != null)
            return proj1ProcessMapper.selectByExample(proj1ProcessExample);
        return proj1ProcessMapper.selectByExample(null);
    }
    //查询：指定状态的进程(不处理已删除的对象)
    @Override
    public List<Proj1Process> getByStatus(Integer status){
        proj1ProcessExample = new Proj1ProcessExample();
        Proj1ProcessExample.Criteria criteria = proj1ProcessExample.createCriteria();
        criteria.andStatusEqualTo(status);
        criteria.andDeletedEqualTo(1);
        return proj1ProcessMapper.selectByExample(proj1ProcessExample);
    }
    //查询：根据名称查询
    @Override
    public List<Proj1Process> getByPname(String pname,boolean like){

        proj1ProcessExample = new Proj1ProcessExample();
        Proj1ProcessExample.Criteria criteria = proj1ProcessExample.createCriteria();
        if(like){
            criteria.andPnameLike(pname);
        }else{
            criteria.andPnameEqualTo(pname);
        }
        return proj1ProcessMapper.selectByExample(proj1ProcessExample);
    }
    //根据主键查询
    @Override
    public Proj1Process getByPrimaryKey(Integer id){
        return proj1ProcessMapper.selectByPrimaryKey(id);
    }
    //删除
    @Override
    public void delByPrimaryKey(int id,boolean disableDisplayOnly){
        if(disableDisplayOnly){
            Proj1Process proj1Process = proj1ProcessMapper.selectByPrimaryKey(id);
            proj1Process.setDeleted(1);
            proj1ProcessMapper.updateByPrimaryKey(proj1Process);
        }else{
            proj1ProcessMapper.deleteByPrimaryKey(id);
        }
    }
    //修改
    @Override
    public void modByPrimaryKey(Proj1Process proj1Process){
        proj1ProcessExample = new Proj1ProcessExample();
        Proj1ProcessExample.Criteria criteria = proj1ProcessExample.createCriteria();
        criteria.andIdEqualTo(proj1Process.getId());
        proj1ProcessMapper.updateByExample(proj1Process,proj1ProcessExample);

    }
    //插入
    @Override
    public void insert(Proj1Process proj1Process){
        proj1ProcessMapper.insert(proj1Process);
    }

}
