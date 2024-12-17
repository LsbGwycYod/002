package cn.edu.nbpt.lilingyi.blogmanage.service.impl;

import cn.edu.nbpt.lilingyi.blogmanage.mapper.CategoryMapper;
import cn.edu.nbpt.lilingyi.blogmanage.pojo.bean.PageBean;
import cn.edu.nbpt.lilingyi.blogmanage.pojo.entity.Category;
import cn.edu.nbpt.lilingyi.blogmanage.pojo.vo.CategoryArticleVo;
import cn.edu.nbpt.lilingyi.blogmanage.service.CategoryService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Category record) {
        return categoryMapper.insertSelective(record);
    }

    @Override
    public Category selectByPrimaryKey(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Category record) {
        return categoryMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageBean<CategoryArticleVo> pageCategory(Integer pageNum, Integer pageSize, Integer id, String name, String code) {
        PageHelper.startPage(pageNum, pageSize);
        PageBean<CategoryArticleVo> page=PageBean.page(categoryMapper.pageCategory(id, name, code));
        return page;
    }
}
