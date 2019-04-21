package com.ysy.petadopt.repository;

import com.ysy.petadopt.entity.ArticleCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleCategoryRepository extends JpaRepository<ArticleCategory, Integer> {

    /**
     * 根据类别名查询类别
     * @param categoryName
     * @return 类别数据
     */
    ArticleCategory findByCategoryName(String categoryName);

}
