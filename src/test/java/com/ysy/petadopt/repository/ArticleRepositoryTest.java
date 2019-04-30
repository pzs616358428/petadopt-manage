package com.ysy.petadopt.repository;

import com.ysy.petadopt.entity.AnimalCategory;
import com.ysy.petadopt.entity.Article;
import com.ysy.petadopt.entity.ArticleCategory;
import com.ysy.petadopt.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void findAllTest() {
        System.out.println(articleRepository.findAll());
    }

    @Test
    public void deleteByAnimalCategoryIdTest() {
        articleRepository.deleteByAnimalCategoryId(27);
    }

    @Test
    public void deleteByAnimalCategoryIdsTest() {
        articleRepository.deleteByAnimalCategoryIds(Arrays.asList(24, 26));
    }

    @Test
    public void deleteByArticleCategoryIdTest() {
        articleRepository.deleteByArticleCategoryId(7);
    }

    @Test
    public void saveTest() {
        Article article = new Article();
        article.setTitle("巨型淡水虾");
        article.setMainImage("主图地址");
        article.setDescription("这是描述");
        article.setContent("<p>这是文章内容</p>");
        article.setWatchCount(1);
        article.setCommentCount(2);
        article.setCreateTime(new Date());
        article.setUpdateTime(new Date());

        User user = new User();
        user.setUserId(1);

        article.setUser(user);

        AnimalCategory animalCategory = new AnimalCategory();
        animalCategory.setAnimalCategoryId(31);
        article.setAnimalCategory(animalCategory);

        ArticleCategory articleCategory = new ArticleCategory();
        articleCategory.setArticleCategoryId(3);
        article.setArticleCategory(articleCategory);

        articleRepository.save(article);

    }

}