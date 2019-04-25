package com.ysy.petadopt.controller;

import com.ysy.petadopt.entity.AnimalCategory;
import com.ysy.petadopt.service.AnimalCategoryService;
import com.ysy.petadopt.utils.PageUtils;
import com.ysy.petadopt.utils.ResultVOUtils;
import com.ysy.petadopt.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/admin/article/")
public class AdminAnimalCategoryController {

    @Autowired
    private AnimalCategoryService animalCategoryService;

    @GetMapping("animalCategoryList")
    public String animalCategoryList(ModelMap modelMap, @RequestParam(defaultValue = "1") Integer pageNum) {
        // Pageable中计数从0开始所以-1
        Pageable pageable = PageRequest.of(--pageNum, 10);
        Page<AnimalCategory> page = animalCategoryService.findAll(pageable);
        modelMap.put("page", page);
        modelMap.put("navigationNums", PageUtils.getNavigationNums(page));
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

    @GetMapping("deleteAnimalCategorys")
    public String deleteAnimalCategorys(Integer[] animalCategoryIds) {
        List<Integer> list = Arrays.asList(animalCategoryIds);
        animalCategoryService.deleteByAnimalCategoryIds(list);
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

    @PostMapping("updateAnimalCategory")
    @ResponseBody
    public ResultVO updateAnimalCategory(Integer animalCategoryId, String categoryName) {
        AnimalCategory animalCategory = animalCategoryService.findByCategoryName(categoryName);
        if (animalCategory == null) {
            animalCategory = new AnimalCategory();
            animalCategory.setAnimalCategoryId(animalCategoryId);
            animalCategory.setCategoryName(categoryName);
            animalCategory = animalCategoryService.save(animalCategory);
            return ResultVOUtils.success(animalCategory);
        } else {
            return ResultVOUtils.error(1, "类别已存在");
        }
    }

}
