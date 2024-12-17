package cn.edu.nbpt.lilingyi.blogmanage.controller;

import cn.edu.nbpt.lilingyi.blogmanage.Result;
import cn.edu.nbpt.lilingyi.blogmanage.pojo.entity.Category;
import cn.edu.nbpt.lilingyi.blogmanage.pojo.vo.CategoryArticleVo;
import cn.edu.nbpt.lilingyi.blogmanage.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Transactional
@RestController
@RequestMapping("/blog/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("{id}")
    public Result<Category> getCategoryById(@PathVariable("id") Integer id) {
        return Result.success(categoryService.selectByPrimaryKey(id));
    }
    @PostMapping
    public Result<Integer> addCategory(@RequestBody Category category) {
        return Result.success(categoryService.insertSelective(category));
    }
    @PutMapping
    public Result<Integer> updateCategory(@RequestBody Category category) {
        return Result.success(categoryService.updateByPrimaryKeySelective(category));
    }
    @DeleteMapping("{id}")
    public Result<Integer> deleteCategory(@PathVariable("id") Integer id) {
        return Result.success(categoryService.deleteByPrimaryKey(id));
    }
    @GetMapping("/list")
    public Result<CategoryArticleVo> pageCategory(@RequestParam(defaultValue = "1") Integer pageNum,
                                                  @RequestParam(defaultValue = "10") Integer pageSize,
                                                  @RequestParam(required = false) Integer id,
                                                  @RequestParam(required = false) String name,
                                                  @RequestParam(required = false) String code) {
        return Result.success(categoryService.pageCategory(pageNum, pageSize, id, name, code));
    }
}