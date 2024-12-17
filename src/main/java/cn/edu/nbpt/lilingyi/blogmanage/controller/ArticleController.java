package cn.edu.nbpt.lilingyi.blogmanage.controller;

import cn.edu.nbpt.lilingyi.blogmanage.Result;
import cn.edu.nbpt.lilingyi.blogmanage.pojo.entity.Article;
import cn.edu.nbpt.lilingyi.blogmanage.pojo.vo.ArticleCategoryVo;
import cn.edu.nbpt.lilingyi.blogmanage.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    @DeleteMapping("{id}")
    public Result<Article> deleteArticle(@PathVariable("id") Integer id){
        return Result.success(articleService.deleteByPrimaryKey(id));
    }
    @GetMapping("/list")
    public Result<ArticleCategoryVo> pageArticle(@RequestParam(defaultValue = "1") Integer pageNum,
                                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                                 @RequestParam(required = false) String title,
                                                 @RequestParam(required = false) Integer state,
                                                 @RequestParam(required = false) String author,
                                                 @RequestParam(required = false) Integer categoryId){
        return Result.success(articleService.pageArticle(pageNum,pageSize,title,state,author,categoryId));
    }
}
