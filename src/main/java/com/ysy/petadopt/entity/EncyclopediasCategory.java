package com.ysy.petadopt.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "p_encyclopedias_category")
public class EncyclopediasCategory {

    @Id
    private Integer categoryId;
    private String categoryName;

}
