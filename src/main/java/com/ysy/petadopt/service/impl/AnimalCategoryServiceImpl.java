package com.ysy.petadopt.service.impl;

import com.ysy.petadopt.entity.AnimalCategory;
import com.ysy.petadopt.repository.AnimalCategoryRepository;
import com.ysy.petadopt.service.AnimalCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AnimalCategoryServiceImpl implements AnimalCategoryService {

    @Autowired
    private AnimalCategoryRepository animalCategoryRepository;

    @Override
    public Page<AnimalCategory> findAll(Pageable pageable) {
        return animalCategoryRepository.findAll(pageable);
    }

    @Override
    public AnimalCategory findByCategoryName(String categoryName) {
        return animalCategoryRepository.findByCategoryName(categoryName);
    }

    @Override
    public void deleteById(Integer animalCategoryId) {
        animalCategoryRepository.deleteById(animalCategoryId);
    }

    @Override
    public AnimalCategory save(AnimalCategory animalCategory) {
        return animalCategoryRepository.save(animalCategory);
    }

}
