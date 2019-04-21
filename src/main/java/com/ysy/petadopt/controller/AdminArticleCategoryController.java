package com.ysy.petadopt.controller;

import com.ysy.petadopt.entity.ArticleCategory;
import com.ysy.petadopt.service.ArticleCategoryService;
import com.ysy.petadopt.utils.ResultVOUtils;
import com.ysy.petadopt.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/article/")
public class AdminArticleCategoryController {

    @Autowired
    private ArticleCategoryService articleCategoryService;

    @GetMapping("articleCategoryList")
    public String articleCategoryList(ModelMap modelMap,@RequestParam(defaultValue = "1") Integer pageNum) {
        Pageable pageable = PageRequest.of(--pageNum, 10);
        modelMap.put("page", articleCategoryService.findAll(pageable));
        return "article/article_category_list";
    }

    @GetMapping("deleteArticleCategory")
    public String deleteAnimalCategory(Integer articleCategoryId) {
        if (articleCategoryId != null) {
            articleCategoryService.deleteById(articleCategoryId);
        }
        return "redirect:articleCategoryList";
    }

    @PostMapping("addArticleCategory")
    @ResponseBody
    public ResultVO addArticleCategory(String categoryName) {
        ArticleCategory articleCategory = articleCategoryService.findByCategoryName(categoryName);
        if (articleCategory == null) {
            articleCategory = new ArticleCategory();
            articleCategory.setCategoryName(categoryName);
            articleCategory = articleCategoryService.save(articleCategory);
            return ResultVOUtils.success(articleCategory);
        } else {
            return ResultVOUtils.error(1, "类别已存在");
        }
    }

}
