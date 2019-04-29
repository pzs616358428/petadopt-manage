package com.ysy.petadopt.service.impl;

import com.ysy.petadopt.entity.AnimalCategory;
import com.ysy.petadopt.repository.AnimalCategoryRepository;
import com.ysy.petadopt.repository.ArticleRepository;
import com.ysy.petadopt.service.AnimalCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalCategoryServiceImpl implements AnimalCategoryService {

    @Autowired
    private AnimalCategoryRepository animalCategoryRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<AnimalCategory> findAll() {
        return animalCategoryRepository.findAll();
    }

    @Override
    public Page<AnimalCategory> findAll(Pageable pageable) {
        return animalCategoryRepository.findAll(pageable);
    }

    @Override
    public AnimalCategory findByCategoryName(String categoryName) {
        return animalCategoryRepository.findByCategoryName(categoryName);
    }

    @Transactional
    @Override
    public void deleteById(Integer animalCategoryId) {
        // 先根据宠物类别id删除文章
        articleRepository.deleteByAnimalCategoryId(animalCategoryId);
        // 再删除宠物类别
        animalCategoryRepository.deleteById(animalCategoryId);
    }

    @Override
    public AnimalCategory save(AnimalCategory animalCategory) {
        return animalCategoryRepository.save(animalCategory);
    }

    @Transactional
    @Override
    public void deleteByAnimalCategoryIds(List<Integer> animalCategoryIds) {
        // 先根据宠物类别id列表删除文章
        articleRepository.deleteByAnimalCategoryIds(animalCategoryIds);
        // 再删除宠物类别
        List<AnimalCategory> animalCategoryList = new ArrayList<>();
        for (Integer animalCategoryId : animalCategoryIds) {
            AnimalCategory animalCategory = new AnimalCategory();
            animalCategory.setAnimalCategoryId(animalCategoryId);
            animalCategoryList.add(animalCategory);
        }
        animalCategoryRepository.deleteInBatch(animalCategoryList);
    }

}
