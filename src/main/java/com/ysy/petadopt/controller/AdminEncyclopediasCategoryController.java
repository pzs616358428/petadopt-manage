package com.ysy.petadopt.controller;

import com.ysy.petadopt.entity.EncyclopediasCategory;
import com.ysy.petadopt.service.EncyclopediasCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin/encyclopedias/")
public class AdminEncyclopediasCategoryController {

    @Autowired
    private EncyclopediasCategoryService encyclopediasCategoryService;

    @GetMapping("categoryList")
    public String categoryList(ModelMap modelMap,@RequestParam(defaultValue = "0") Integer pageNum) {
        Pageable pageable = PageRequest.of(pageNum,10);
        modelMap.put("page", encyclopediasCategoryService.findAll(pageable));
        return "encyclopedias/category_list";
    }

    @GetMapping("deleteCategory")
    public String deleteCategory(Integer categoryId) {
        encyclopediasCategoryService.deleteById(categoryId);
        return "redirect:categoryList";
    }

    @GetMapping("test")
    @ResponseBody
    public Page<EncyclopediasCategory> test() {
        Pageable pageable = PageRequest.of(0,10);
        return encyclopediasCategoryService.findAll(pageable);
    }

}
