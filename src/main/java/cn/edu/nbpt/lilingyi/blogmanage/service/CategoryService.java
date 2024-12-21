package cn.edu.nbpt.lilingyi.blogmanage.service;

import cn.edu.nbpt.lilingyi.blogmanage.pojo.bean.PageBean;
import cn.edu.nbpt.lilingyi.blogmanage.pojo.entity.Category;
import cn.edu.nbpt.lilingyi.blogmanage.pojo.vo.CategoryArticleVo;

import java.util.List;

public interface CategoryService {
    int deleteByPrimaryKey(List<Integer> ids);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);
    List<Category> selectAll();

    PageBean<CategoryArticleVo> pageCategory(Integer pageNum, Integer pageSize, Integer id, String name, String code);
}
