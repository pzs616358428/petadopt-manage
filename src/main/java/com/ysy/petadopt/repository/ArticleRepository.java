package com.ysy.petadopt.repository;

import com.ysy.petadopt.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    @Transactional
    @Modifying
    @Query(value = "delete from p_article where animal_category_id = ?1")
    void deleteByAnimalCategoryId(Integer animalCategoryId);

    @Transactional
    @Modifying
    @Query(value = "delete from p_article where animal_category_id in (:animalCategoryIds)")
    void deleteByAnimalCategoryIds(@Param("animalCategoryIds") List<Integer> animalCategoryIds);

}
