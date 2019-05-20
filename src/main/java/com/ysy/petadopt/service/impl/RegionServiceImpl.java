package com.ysy.petadopt.service.impl;

import com.ysy.petadopt.entity.Region;
import com.ysy.petadopt.repository.RegionRepository;
import com.ysy.petadopt.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionRepository regionRepository;

    @Override
    public List<Region> findAll() {
        return regionRepository.findAll();
    }

    @Override
    public Region save(Region region) {
        return regionRepository.save(region);
    }

    @Override
    public void deleteById(Integer id) {
        // TODO 删除地区之前先删除地区下所有领养
        regionRepository.deleteById(id);
    }
}
