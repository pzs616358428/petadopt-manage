package com.ysy.petadopt.repository;

import com.ysy.petadopt.entity.AnimalCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void deleteInBatchTest() {
        List<AnimalCategory> list = new ArrayList<>();
        AnimalCategory a1 = new AnimalCategory();
        a1.setAnimalCategoryId(11);
        a1.setCategoryName("爬行");
        list.add(a1);
        AnimalCategory a2 = new AnimalCategory();
        a2.setAnimalCategoryId(12);
        a2.setCategoryName("鸟");
        list.add(a2);
        animalCategoryRepository.deleteInBatch(list);
    }

}