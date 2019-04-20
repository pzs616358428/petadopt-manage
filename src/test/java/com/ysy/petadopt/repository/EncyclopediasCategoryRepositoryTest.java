package com.ysy.petadopt.repository;

import com.ysy.petadopt.entity.EncyclopediasCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EncyclopediasCategoryRepositoryTest {

    @Autowired
    private EncyclopediasCategoryRepository encyclopediasCategoryRepository;

    @Test
    public void findAllTest() {
        List<EncyclopediasCategory> encyclopediasCategoryList = encyclopediasCategoryRepository.findAll();
        for (EncyclopediasCategory encyclopediasCategory : encyclopediasCategoryList) {
            System.out.println(encyclopediasCategory);
        }
    }

    @Test
    public void findByCategoryNameTest() {
        System.out.println(encyclopediasCategoryRepository.findByCategoryName("aaa"));
    }

}