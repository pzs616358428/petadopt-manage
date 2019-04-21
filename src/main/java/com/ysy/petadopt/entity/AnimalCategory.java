package com.ysy.petadopt.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "p_animal_category")
public class AnimalCategory {

    /* 类别id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer animalCategoryId;

    /* 类别名 */
    private String categoryName;

}
