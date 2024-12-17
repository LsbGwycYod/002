package cn.edu.nbpt.lilingyi.blogmanage.service;

import cn.edu.nbpt.lilingyi.blogmanage.pojo.bean.PageBean;
import cn.edu.nbpt.lilingyi.blogmanage.pojo.entity.Article;
import cn.edu.nbpt.lilingyi.blogmanage.pojo.vo.ArticleCategoryVo;

public interface ArticleService {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Article record);
    PageBean<ArticleCategoryVo> pageArticle(Integer pageNum, Integer pageSize, String title, Integer state, String author, Integer categoryId);
}
