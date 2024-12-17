package cn.edu.nbpt.lilingyi.blogmanage.mapper;

import cn.edu.nbpt.lilingyi.blogmanage.pojo.entity.Article;
import cn.edu.nbpt.lilingyi.blogmanage.pojo.vo.ArticleCategoryVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 22273
* @description 针对表【article】的数据库操作Mapper
* @createDate 2024-12-16 13:47:28
* @Entity cn.edu.nbpt.lilingyi.blogmanage.pojo.entity.Article
*/
@Mapper
public interface ArticleMapper {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Article record);

    List<ArticleCategoryVo> pageArticle(@Param("title") String title, @Param("state") Integer state, @Param("author") String author, @Param("categoryId") Integer categoryId);
}
