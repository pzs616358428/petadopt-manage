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

}
