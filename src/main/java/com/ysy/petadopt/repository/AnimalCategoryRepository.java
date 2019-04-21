package com.ysy.petadopt.repository;

import com.ysy.petadopt.entity.AnimalCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalCategoryRepository extends JpaRepository<AnimalCategory, Integer> {

    AnimalCategory findByCategoryName(String categoryName);

}
