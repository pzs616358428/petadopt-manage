package com.ysy.petadopt.controller;

import com.ysy.petadopt.entity.AnimalCategory;
import com.ysy.petadopt.service.AnimalCategoryService;
import com.ysy.petadopt.utils.ResultVOUtils;
import com.ysy.petadopt.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/member/article/")
public class MemberAnimalCategoryController {

    @Autowired
    private AnimalCategoryService animalCategoryService;

    @GetMapping("animalCategoryList")
    public ResultVO animalCategoryList() {
        List<AnimalCategory> animalCategoryList = animalCategoryService.findAll();
        return ResultVOUtils.success(animalCategoryList);
    }

}
