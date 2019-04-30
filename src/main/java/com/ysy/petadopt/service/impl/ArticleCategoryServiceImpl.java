package com.ysy.petadopt.service.impl;

import com.ysy.petadopt.entity.ArticleCategory;
import com.ysy.petadopt.repository.ArticleCategoryRepository;
import com.ysy.petadopt.repository.ArticleRepository;
import com.ysy.petadopt.service.ArticleCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleCategoryServiceImpl implements ArticleCategoryService {

    @Autowired
    private ArticleCategoryRepository articleCategoryRepository;

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<ArticleCategory> findAll() {
        return articleCategoryRepository.findAll();
    }

    @Override
    public Page<ArticleCategory> findAll(Pageable pageable) {
        return articleCategoryRepository.findAll(pageable);
    }

    @Override
    public ArticleCategory findByCategoryName(String categoryName) {
        return articleCategoryRepository.findByCategoryName(categoryName);
    }

    @Transactional
    @Override
    public void deleteById(Integer articleCategoryId) {
        // 先根据文章类别id删除文章
        articleRepository.deleteByArticleCategoryId(articleCategoryId);
        // 再删除类别
        articleCategoryRepository.deleteById(articleCategoryId);
    }

    @Override
    public ArticleCategory save(ArticleCategory articleCategory) {
        return articleCategoryRepository.save(articleCategory);
    }

}
