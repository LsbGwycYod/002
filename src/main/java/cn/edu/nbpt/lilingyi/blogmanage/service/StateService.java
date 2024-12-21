package cn.edu.nbpt.lilingyi.blogmanage.service;

import cn.edu.nbpt.lilingyi.blogmanage.pojo.entity.State;

import java.util.List;

public interface StateService {
    State selectByPrimaryKey(Integer id);
    List<State> selectAll();
}
