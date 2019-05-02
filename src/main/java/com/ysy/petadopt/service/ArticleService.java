package com.ysy.petadopt.service;

import com.ysy.petadopt.entity.Article;
import org.springframework.data.domain.Example;
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
     * 根据id查询文章
     * @param articleId
     * @return 查询出的数据
     */
    Article findOne(Integer articleId);

    Page<Article> dynamicFindAll(Example<Article> example, Pageable pageable);

    /**
     * 添加文章
     * @param article
     * @return 添加后的数据
     */
    Article save(Article article);

    void deleteById(Integer articleId);

}
