package com.ysy.petadopt.service.impl;

import com.ysy.petadopt.entity.Article;
import com.ysy.petadopt.repository.ArticleRepository;
import com.ysy.petadopt.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Page<Article> findAll(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    @Override
    public Article findOne(Integer articleId) {
        Optional<Article> optional = articleRepository.findById(articleId);
        return optional.get();
    }

    @Override
    public Page<Article> dynamicFindAll(Example<Article> example, Pageable pageable) {
        return articleRepository.findAll(example, pageable);
    }

    @Override
    public Article save(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public void deleteById(Integer articleId) {
        articleRepository.deleteById(articleId);
    }

}
