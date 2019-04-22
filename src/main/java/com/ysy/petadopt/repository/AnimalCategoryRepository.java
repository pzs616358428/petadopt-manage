package com.ysy.petadopt.repository;

import com.ysy.petadopt.entity.AnimalCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalCategoryRepository extends JpaRepository<AnimalCategory, Integer> {

    /**
     * 根据类别名查询类别
     * @param categoryName
     * @return 类别数据
     */
    AnimalCategory findByCategoryName(String categoryName);

}
