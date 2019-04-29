package com.ysy.petadopt.service.impl;

import com.ysy.petadopt.entity.Article;
import com.ysy.petadopt.repository.ArticleRepository;
import com.ysy.petadopt.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Page<Article> findAll(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }

}
