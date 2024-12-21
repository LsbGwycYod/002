package cn.edu.nbpt.lilingyi.blogmanage.service;

import cn.edu.nbpt.lilingyi.blogmanage.pojo.bean.PageBean;
import cn.edu.nbpt.lilingyi.blogmanage.pojo.entity.Article;
import cn.edu.nbpt.lilingyi.blogmanage.pojo.vo.ArticleCategoryVo;
import lombok.Data;


import java.util.Date;
import java.util.List;

public interface ArticleService {
    int deleteByPrimaryKey(List<Integer> ids);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Article record);
    List<Article> selectAll();
    PageBean<ArticleCategoryVo> pageArticle(Integer pageNum, Integer pageSize, String title, Integer state, String author, Integer categoryId, Date publishTimeBegin, Date publishTimeEnd);
}
