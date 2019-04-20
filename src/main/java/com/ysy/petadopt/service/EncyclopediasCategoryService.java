package com.ysy.petadopt.service;

import com.ysy.petadopt.entity.EncyclopediasCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EncyclopediasCategoryService {

    /**
     * 分页查询所有百科类别
     * @return
     */
    Page<EncyclopediasCategory> findAll(Pageable pageable);

    /**
     * 根据id删除类别
     * @param categoryId
     */
    void deleteById(Integer categoryId);

    /**
     * 根据类别名查询类别
     * @param categoryName
     * @return
     */
    EncyclopediasCategory findByCategoryName(String categoryName);

    /**
     * 保存和修改类别
     * @param encyclopediasCategory
     * @return 添加后的数据
     */
    EncyclopediasCategory save(EncyclopediasCategory encyclopediasCategory);

}
