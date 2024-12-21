package cn.edu.nbpt.lilingyi.blogmanage.controller;

import cn.edu.nbpt.lilingyi.blogmanage.Result;
import cn.edu.nbpt.lilingyi.blogmanage.pojo.entity.State;
import cn.edu.nbpt.lilingyi.blogmanage.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Transactional
@RestController
@RequestMapping("/dict/stateType")
public class StateController {
    @Autowired
    StateService stateService;

    @GetMapping("{id}")
    public Result<State> getStateById(Integer id){
        return Result.success(stateService.selectByPrimaryKey(id));
    }
    @GetMapping
    public Result<List<State>> getStateByState(){
        return Result.success(stateService.selectAll());
    }
}
