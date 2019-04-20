package com.ysy.petadopt.service.impl;

import com.ysy.petadopt.entity.EncyclopediasCategory;
import com.ysy.petadopt.repository.EncyclopediasCategoryRepository;
import com.ysy.petadopt.service.EncyclopediasCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EncyclopediasCategoryServiceImpl implements EncyclopediasCategoryService {

    @Autowired
    private EncyclopediasCategoryRepository encyclopediasCategoryRepository;

    @Override
    public Page<EncyclopediasCategory> findAll(Pageable pageable) {
        return encyclopediasCategoryRepository.findAll(pageable);
    }

    @Override
    public void deleteById(Integer categoryId) {
        encyclopediasCategoryRepository.deleteById(categoryId);
    }

    @Override
    public EncyclopediasCategory findByCategoryName(String categoryName) {
        return encyclopediasCategoryRepository.findByCategoryName(categoryName);
    }

    @Override
    public EncyclopediasCategory save(EncyclopediasCategory encyclopediasCategory) {
        return encyclopediasCategoryRepository.save(encyclopediasCategory);
    }

}
