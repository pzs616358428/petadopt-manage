package com.ysy.petadopt.service;

import com.ysy.petadopt.entity.Region;

import java.util.List;

public interface RegionService {

    /**
     * 查询所有地区
     * @return
     */
    List<Region> findAll();

    /**
     * 添加修改地区
     * @param region
     * @return
     */
    Region save(Region region);

    /**
     * 根据id删除地区
     * @param id
     */
    void deleteById(Integer id);

}
