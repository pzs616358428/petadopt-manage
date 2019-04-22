package com.ysy.petadopt.repository;

import com.ysy.petadopt.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
