package cn.edu.nbpt.lilingyi.blogmanage.service.impl;

import cn.edu.nbpt.lilingyi.blogmanage.mapper.ArticleMapper;
import cn.edu.nbpt.lilingyi.blogmanage.pojo.bean.PageBean;
import cn.edu.nbpt.lilingyi.blogmanage.pojo.entity.Article;
import cn.edu.nbpt.lilingyi.blogmanage.pojo.vo.ArticleCategoryVo;
import cn.edu.nbpt.lilingyi.blogmanage.service.ArticleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertSelective(Article record) {
        return articleMapper.insertSelective(record);
    }

    @Override
    public Article selectByPrimaryKey(Integer id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Article record) {
        return articleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PageBean<ArticleCategoryVo> pageArticle(Integer pageNum, Integer pageSize, String title, Integer state, String author, Integer categoryId) {
        PageHelper.startPage(pageNum, pageSize);
        PageBean<ArticleCategoryVo> page = PageBean.page(articleMapper.pageArticle(title, state, author, categoryId));
        return page;
    }
}
