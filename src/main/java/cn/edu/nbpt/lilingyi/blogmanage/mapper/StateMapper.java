package cn.edu.nbpt.lilingyi.blogmanage.mapper;

import cn.edu.nbpt.lilingyi.blogmanage.pojo.entity.State;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 22273
* @description 针对表【state】的数据库操作Mapper
* @createDate 2024-12-18 14:29:40
* @Entity cn.edu.nbpt.lilingyi.blogmanage.pojo.entity.State
*/
@Mapper
public interface StateMapper {
    State selectByPrimaryKey(Integer id);
    List<State> selectAll();
}
