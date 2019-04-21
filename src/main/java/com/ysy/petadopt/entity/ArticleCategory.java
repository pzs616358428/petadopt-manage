package com.ysy.petadopt.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "p_article_category")
public class ArticleCategory {

    /* 文章类别id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer articleCategoryId;

    /* 文章类别名称 */
    private String categoryName;

}
