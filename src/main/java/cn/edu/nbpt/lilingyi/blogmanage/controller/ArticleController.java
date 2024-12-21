package cn.edu.nbpt.lilingyi.blogmanage.controller;

import cn.edu.nbpt.lilingyi.blogmanage.Constants;
import cn.edu.nbpt.lilingyi.blogmanage.Result;
import cn.edu.nbpt.lilingyi.blogmanage.pojo.entity.Article;
import cn.edu.nbpt.lilingyi.blogmanage.pojo.vo.ArticleCategoryVo;
import cn.edu.nbpt.lilingyi.blogmanage.service.ArticleService;
import cn.edu.nbpt.lilingyi.blogmanage.utils.excel.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@RestController
@RequestMapping("/blog/article")
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @GetMapping("{id}")
    public Result<Article> getArticleById(@PathVariable("id") Integer id){
        return Result.success(articleService.selectByPrimaryKey(id));
    }
    @PostMapping
    public Result<Article> addArticle(@RequestBody Article article){
        return Result.success(articleService.insertSelective(article));
    }
    @PutMapping
    public Result<Article> updateArticle(@RequestBody Article article){
        return Result.success(articleService.updateByPrimaryKeySelective(article));
    }
    @DeleteMapping("{ids}")
    public Result<Integer> deleteArticle(@PathVariable("ids") String ids) {
        List<Integer> idList = Arrays.stream(ids.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return Result.success(articleService.deleteByPrimaryKey(idList));
    }
    @GetMapping("/list")
    public Result<ArticleCategoryVo> pageArticle(@RequestParam(defaultValue = "1") Integer pageNum,
                                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                                 @RequestParam(required = false) String title,
                                                 @RequestParam(required = false) Integer state,
                                                 @RequestParam(required = false) String author,
                                                 @RequestParam(required = false) Integer categoryId,
                                                 @RequestParam(required = false)@DateTimeFormat(pattern = Constants.YYYY_MM_DD) Date publishTimeBegin,
                                                 @RequestParam(required = false)@DateTimeFormat(pattern = Constants.YYYY_MM_DD) Date publishTimeEnd){
        return Result.success(articleService.pageArticle(pageNum,pageSize,title,state,author,categoryId,publishTimeBegin,publishTimeEnd));
    }
    @GetMapping("/export")
    public void exportExcel(HttpServletResponse response) {
        List<Article> articleList= articleService.selectAll();
        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        ExcelUtils.export(response, "articleExcel", articleList, Article.class);
    }
}
