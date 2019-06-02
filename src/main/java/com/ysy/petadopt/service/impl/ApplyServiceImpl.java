package com.ysy.petadopt.service.impl;

import com.ysy.petadopt.entity.Apply;
import com.ysy.petadopt.repository.ApplyRepository;
import com.ysy.petadopt.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyServiceImpl implements ApplyService {

    @Autowired
    private ApplyRepository applyRepository;

    @Override
    public Apply save(Apply apply) {
        return applyRepository.save(apply);
    }

    @Override
    public List<Apply> findAll() {
        return applyRepository.findAll();
    }

    @Override
    public Apply findById(Integer applyId) {
        return applyRepository.findById(applyId).get();
    }
}
