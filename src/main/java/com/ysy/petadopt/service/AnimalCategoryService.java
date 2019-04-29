package com.ysy.petadopt.service;

import com.ysy.petadopt.entity.AnimalCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AnimalCategoryService {

    /**
     * 查询所有动物分类
     * @return
     */
    List<AnimalCategory> findAll();

    /**
     * 根据分页参数查询动物类别
     * @param pageable
     * @return 类别数据
     */
    Page<AnimalCategory> findAll(Pageable pageable);

    /**
     * 根据类别名查询类别
     * @param categoryName
     * @return 类别数据
     */
    AnimalCategory findByCategoryName(String categoryName);

    /**
     * 根据id删除动物类别
     * @param animalCategoryId
     */
    void deleteById(Integer animalCategoryId);

    /**
     * 添加或者修改动物类别
     * @param animalCategory
     * @return 修改后的数据
     */
    AnimalCategory save(AnimalCategory animalCategory);

    /**
     * 根据animalCategoryIds集合删除动物类别
     * @param animalCategoryIds
     */
    void deleteByAnimalCategoryIds(List<Integer> animalCategoryIds);

}
