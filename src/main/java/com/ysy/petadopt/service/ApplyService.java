package com.ysy.petadopt.service;

import com.ysy.petadopt.entity.Apply;

import java.util.List;

public interface ApplyService {

    Apply save(Apply apply);

    List<Apply> findAll();

    Apply findById(Integer applyId);

}
