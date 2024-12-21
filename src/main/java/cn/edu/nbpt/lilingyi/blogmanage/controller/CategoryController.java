package cn.edu.nbpt.lilingyi.blogmanage.controller;

import cn.edu.nbpt.lilingyi.blogmanage.Result;
import cn.edu.nbpt.lilingyi.blogmanage.exception.BizException;
import cn.edu.nbpt.lilingyi.blogmanage.pojo.entity.Category;
import cn.edu.nbpt.lilingyi.blogmanage.pojo.enums.ErrorCode;
import cn.edu.nbpt.lilingyi.blogmanage.pojo.vo.CategoryArticleVo;
import cn.edu.nbpt.lilingyi.blogmanage.service.CategoryService;
import cn.edu.nbpt.lilingyi.blogmanage.utils.excel.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    @DeleteMapping("{ids}") // 接收多个 ID，通过路径
    public Result<Integer> deleteCategory(@PathVariable("ids") String ids) {
        // 分割逗号并将字符串转换为列表
        List<Integer> idList = Arrays.stream(ids.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return Result.success(categoryService.deleteByPrimaryKey(idList));
    }
    @GetMapping("/categoryType")
    public Result<List<Category>> getAllCategory() {
        return Result.success(categoryService.selectAll());
    }
    @GetMapping("/list")
    public Result<CategoryArticleVo> pageCategory(@RequestParam(defaultValue = "1") Integer pageNum,
                                                  @RequestParam(defaultValue = "10") Integer pageSize,
                                                  @RequestParam(required = false) Integer id,
                                                  @RequestParam(required = false) String name,
                                                  @RequestParam(required = false) String code) {
        return Result.success(categoryService.pageCategory(pageNum, pageSize, id, name, code));
    }
    @GetMapping("/export")
    public void exportExcel(HttpServletResponse response) {
        List<Category> categoryList= categoryService.selectAll();
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        ExcelUtils.export(response, "categoryExcel", categoryList, Category.class);
    }
}