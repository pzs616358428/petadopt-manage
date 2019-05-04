package com.ysy.petadopt.controller;

import com.ysy.petadopt.entity.AnimalCategory;
import com.ysy.petadopt.entity.Article;
import com.ysy.petadopt.entity.ArticleCategory;
import com.ysy.petadopt.service.AnimalCategoryService;
import com.ysy.petadopt.service.ArticleCategoryService;
import com.ysy.petadopt.service.ArticleService;
import com.ysy.petadopt.utils.ResultVOUtils;
import com.ysy.petadopt.vo.MemberArticleVO;
import com.ysy.petadopt.vo.PageVO;
import com.ysy.petadopt.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member/article/")
public class MemberArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleCategoryService articleCategoryService;

    @Autowired
    private AnimalCategoryService animalCategoryService;

    @GetMapping("articleList")
    public ResultVO articleList(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize,
                                String articleCategoryName, String animalCategoryName) {
        // 构建查询参数
        Article article = new Article();

        // 构建文章类别参数
        if (articleCategoryName != null) {
            ArticleCategory articleCategory = articleCategoryService.findByCategoryName(articleCategoryName);
            if (articleCategory != null) {
                article.setArticleCategory(articleCategory);
            }
        }

        // 构建宠物类别参数
        if (animalCategoryName != null) {
            AnimalCategory animalCategory = animalCategoryService.findByCategoryName(animalCategoryName);
            if (animalCategory != null) {
                article.setAnimalCategory(animalCategory);
            }
        }

        Example<Article> example = Example.of(article);

        Pageable pageable = PageRequest.of(--pageNum, pageSize);
        Page<Article> page = articleService.dynamicFindAll(example, pageable);

        MemberArticleVO memberArticleVO = new MemberArticleVO();
        memberArticleVO.setList(page.getContent());

        memberArticleVO.setPage(PageVO.of(page.getNumber() + 1, page.getTotalPages(),page.getTotalElements(), page.isFirst(), page.isLast(), page.hasNext(), page.hasPrevious()));

        return ResultVOUtils.success(memberArticleVO);
    }

    @GetMapping("articleDetail")
    public ResultVO articleDetail(Integer articleId) {
        Article article = articleService.findOne(articleId);
        return ResultVOUtils.success(article);
    }

}
