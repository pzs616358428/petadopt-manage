package com.ysy.petadopt.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnimalCategoryRepositoryTest {

    @Autowired
    private AnimalCategoryRepository animalCategoryRepository;

    @Test
    public void findAllTest() {
        System.out.println(animalCategoryRepository.findAll());
    }

    @Test
    public void findByCategoryName() {
        System.out.println(animalCategoryRepository.findByCategoryName("狗"));
    }

}