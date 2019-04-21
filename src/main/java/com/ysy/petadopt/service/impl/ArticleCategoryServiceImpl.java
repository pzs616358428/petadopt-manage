package com.ysy.petadopt.service.impl;

import com.ysy.petadopt.entity.ArticleCategory;
import com.ysy.petadopt.repository.ArticleCategoryRepository;
import com.ysy.petadopt.service.ArticleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ArticleCategoryServiceImpl implements ArticleCategoryService {

    @Autowired
    private ArticleCategoryRepository articleCategoryRepository;

    @Override
    public Page<ArticleCategory> findAll(Pageable pageable) {
        return articleCategoryRepository.findAll(pageable);
    }

    @Override
    public ArticleCategory findByCategoryName(String categoryName) {
        return articleCategoryRepository.findByCategoryName(categoryName);
    }

    @Override
    public void deleteById(Integer articleCategoryId) {
        articleCategoryRepository.deleteById(articleCategoryId);
    }

    @Override
    public ArticleCategory save(ArticleCategory articleCategory) {
        return articleCategoryRepository.save(articleCategory);
    }

}
