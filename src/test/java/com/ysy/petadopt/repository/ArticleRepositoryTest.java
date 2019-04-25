package com.ysy.petadopt.repository;

import com.ysy.petadopt.entity.Article;
import com.ysy.petadopt.entity.ArticleCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

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

}