package com.ysy.petadopt.controller;

import com.ysy.petadopt.entity.AnimalCategory;
import com.ysy.petadopt.service.AnimalCategoryService;
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
public class AdminAnimalCategoryController {

    @Autowired
    private AnimalCategoryService animalCategoryService;

    @GetMapping("animalCategoryList")
    public String animalCategoryList(ModelMap modelMap, @RequestParam(defaultValue = "1") Integer pageNum) {
        Pageable pageable = PageRequest.of(--pageNum, 10);
        modelMap.put("page", animalCategoryService.findAll(pageable));
        return "article/animal_category_list";
    }

    @GetMapping("deleteAnimalCategory")
    public String deleteAnimalCategory(Integer animalCategoryId) {
        if (animalCategoryId != null) {
            // 删除
            animalCategoryService.deleteById(animalCategoryId);
        }
        return "redirect:animalCategoryList";
    }

    @PostMapping("addAnimalCategory")
    @ResponseBody
    public ResultVO addAnimalCategory(String categoryName) {
        AnimalCategory animalCategory = animalCategoryService.findByCategoryName(categoryName);
        if (animalCategory == null) {
            animalCategory = new AnimalCategory();
            animalCategory.setCategoryName(categoryName);
            animalCategory = animalCategoryService.save(animalCategory);
            return ResultVOUtils.success(animalCategory);
        } else {
            return ResultVOUtils.error(1, "类别已存在");
        }
    }

}
