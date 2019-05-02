package com.ysy.petadopt.repository;

import com.ysy.petadopt.entity.AnimalCategory;
import com.ysy.petadopt.entity.Article;
import com.ysy.petadopt.entity.ArticleCategory;
import com.ysy.petadopt.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
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
        article.setArticleId(22);
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
        articleCategory.setArticleCategoryId(8);
        article.setArticleCategory(articleCategory);

        articleRepository.save(article);

    }

    @Test
    public void findAllByExampleTest() {
        Article article = new Article();

        /*AnimalCategory animalCategory = new AnimalCategory();
        animalCategory.setAnimalCategoryId(31);

        ArticleCategory articleCategory = new ArticleCategory();
        articleCategory.setArticleCategoryId(8);

        article.setAnimalCategory(animalCategory);
        article.setArticleCategory(articleCategory);*/

        Example example = Example.of(article);
        System.out.println(articleRepository.findAll(example).size());
    }

}