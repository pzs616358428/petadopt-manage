package com.ysy.petadopt.controller;

import com.ysy.petadopt.entity.Adopt;
import com.ysy.petadopt.entity.Article;
import com.ysy.petadopt.entity.ArticleCategory;
import com.ysy.petadopt.service.AdoptService;
import com.ysy.petadopt.service.ArticleCategoryService;
import com.ysy.petadopt.service.ArticleService;
import com.ysy.petadopt.utils.ResultVOUtils;
import com.ysy.petadopt.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/member/advert/")
public class MemberAdvertController {

    @Autowired
    private AdoptService adoptService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleCategoryService articleCategoryService;

    @GetMapping("adoptAdvert")
    public ResultVO adoptAdvert() {

        Adopt adopt = new Adopt();
        adopt.setIsExamine(1);
        Pageable pageable = PageRequest.of(0, 999);
        List<Adopt> adoptList = adoptService.findAll(Example.of(adopt), pageable).getContent();
        List<Adopt> result = new ArrayList<>();

        if (adoptList.size() > 10) {
            for (int i = adoptList.size() - 1; i >= adoptList.size() - 10; i--) {
                result.add(adoptList.get(i));
            }
        } else {
            for (int i = adoptList.size() - 1; i >= 0; i--) {
                result.add(adoptList.get(i));
            }
        }


        return ResultVOUtils.success(result);
    }

    @GetMapping("assistAdvert")
    public ResultVO assistAdvert() {
        // 构建查询参数
        Article article = new Article();

        // 构建文章类别参数
        ArticleCategory articleCategory = articleCategoryService.findByCategoryName("救助");
        if (articleCategory != null) {
            article.setArticleCategory(articleCategory);
        }

        Example<Article> example = Example.of(article);

        Pageable pageable = PageRequest.of(0, 999);
        Page<Article> page = articleService.dynamicFindAll(example, pageable);
        List<Article> articleList = page.getContent();

        List<Article> result = new ArrayList<>();

        if (articleList.size() > 10) {
            for (int i = articleList.size() - 1; i >= articleList.size() - 10; i--) {
                result.add(articleList.get(i));
            }
        } else {
            for (int i = articleList.size() - 1; i >= 0; i--) {
                result.add(articleList.get(i));
            }
        }


        return ResultVOUtils.success(result);
    }

    @GetMapping("knowledgeAdvert")
    public ResultVO knowledgeAdvert() {
        // 构建查询参数
        Article article = new Article();

        // 构建文章类别参数
        ArticleCategory articleCategory = articleCategoryService.findByCategoryName("知识");
        if (articleCategory != null) {
            article.setArticleCategory(articleCategory);
        }

        Example<Article> example = Example.of(article);

        Pageable pageable = PageRequest.of(0, 999);
        Page<Article> page = articleService.dynamicFindAll(example, pageable);
        List<Article> articleList = page.getContent();

        List<Article> result = new ArrayList<>();

        if (articleList.size() > 10) {
            for (int i = articleList.size() - 1; i >= articleList.size() - 10; i--) {
                result.add(articleList.get(i));
            }
        } else {
            for (int i = articleList.size() - 1; i >= 0; i--) {
                result.add(articleList.get(i));
            }
        }

        return ResultVOUtils.success(result);
    }

    @GetMapping("encyclopediasAdvert")
    public ResultVO encyclopediasAdvert() {
        // 构建查询参数
        Article article = new Article();

        // 构建文章类别参数
        ArticleCategory articleCategory = articleCategoryService.findByCategoryName("百科");
        if (articleCategory != null) {
            article.setArticleCategory(articleCategory);
        }

        Example<Article> example = Example.of(article);

        Pageable pageable = PageRequest.of(0, 999);
        Page<Article> page = articleService.dynamicFindAll(example, pageable);

        List<Article> articleList = page.getContent();

        List<Article> result = new ArrayList<>();

        if (articleList.size() > 10) {
            for (int i = articleList.size() - 1; i >= articleList.size() - 10; i--) {
                result.add(articleList.get(i));
            }
        } else {
            for (int i = articleList.size() - 1; i >= 0; i--) {
                result.add(articleList.get(i));
            }
        }


        return ResultVOUtils.success(result);
    }

}
