package com.ysy.petadopt.service;

import com.ysy.petadopt.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticleService {

    /**
     * 根据分页参数查询所有文章
     * @param pageable
     * @return
     */
    Page<Article> findAll(Pageable pageable);

    /**
     * 添加文章
     * @param article
     * @return 添加后的数据
     */
    Article save(Article article);

}