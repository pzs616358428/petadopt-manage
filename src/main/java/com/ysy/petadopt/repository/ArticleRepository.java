package com.ysy.petadopt.repository;

import com.ysy.petadopt.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    /**
     * 根据宠物类别id删除文章
     * @param animalCategoryId
     */
    @Transactional
    @Modifying
    @Query(value = "delete from p_article where animal_category_id = ?1")
    void deleteByAnimalCategoryId(Integer animalCategoryId);

    /**
     * 根据宠物类别id列表删除文章
     * @param animalCategoryIds
     */
    @Transactional
    @Modifying
    @Query(value = "delete from p_article where animal_category_id in (:animalCategoryIds)")
    void deleteByAnimalCategoryIds(@Param("animalCategoryIds") List<Integer> animalCategoryIds);

    /**
     * 根据文章类别id删除文章
     * @param articleCategoryId
     */
    @Transactional
    @Modifying
    @Query(value = "delete from p_article where article_category_id = ?1")
    void deleteByArticleCategoryId(Integer articleCategoryId);

}
