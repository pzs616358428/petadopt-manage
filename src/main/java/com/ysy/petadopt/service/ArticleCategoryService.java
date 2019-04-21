package com.ysy.petadopt.service;

import com.ysy.petadopt.entity.ArticleCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ArticleCategoryService {

    /**
     * 根据分页参数查询所有文章分类
     * @param pageable
     * @return 文章类别数据
     */
    Page<ArticleCategory> findAll(Pageable pageable);

    /**
     * 根据类别名查询类别
     * @param categoryName
     * @return 类别数据
     */
    ArticleCategory findByCategoryName(String categoryName);

    /**
     * 根据id删除文章类别
     * @param articleCategoryId
     */
    void deleteById(Integer articleCategoryId);

    /**
     * 添加文章类别
     * @param articleCategory
     * @return 添加后的类别数据
     */
    ArticleCategory save(ArticleCategory articleCategory);

}
