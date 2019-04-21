package com.ysy.petadopt.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleCategoryRepositoryTest {

    @Autowired
    private ArticleCategoryRepository articleCategoryRepository;

    @Test
    public void findAllTest() {
        System.out.println(articleCategoryRepository.findAll());
    }

    @Test
    public void findByCategoryName() {
        System.out.println(articleCategoryRepository.findByCategoryName("a"));
    }

}