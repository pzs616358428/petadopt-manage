package com.ysy.petadopt.controller;

import com.ysy.petadopt.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/article/")
public class AdminArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("articleList")
    public String articleList(ModelMap modelMap, @RequestParam(defaultValue = "1") Integer pageNum) {
        Pageable pageable = PageRequest.of(--pageNum, 8);
        modelMap.put("page", articleService.findAll(pageable));
        return "article/article_list";
    }

}
