package cn.edu.nbpt.lilingyi.blogmanage.mapper;

import cn.edu.nbpt.lilingyi.blogmanage.pojo.entity.Category;
import cn.edu.nbpt.lilingyi.blogmanage.pojo.vo.CategoryArticleVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 22273
* @description 针对表【category】的数据库操作Mapper
* @createDate 2024-12-11 20:40:52
* @Entity cn.edu.nbpt.lilingyi.blogmanage.pojo.entity.Category
*/
@Mapper
public interface CategoryMapper {

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    List<Category> selectAll();

    List<CategoryArticleVo> pageCategory(@Param("id") Integer id, @Param("name") String name, @Param("code") String code);
}
