package cn.edu.nbpt.lilingyi.blogmanage.service.impl;

import cn.edu.nbpt.lilingyi.blogmanage.mapper.StateMapper;
import cn.edu.nbpt.lilingyi.blogmanage.pojo.entity.State;
import cn.edu.nbpt.lilingyi.blogmanage.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateServiceImpl implements StateService {
    @Autowired
    StateMapper stateMapper;

    @Override
    public State selectByPrimaryKey(Integer id) {
        return stateMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<State> selectAll() {
        return stateMapper.selectAll();
    }
}
