package com.ysy.petadopt.service.impl;

import com.ysy.petadopt.entity.ReturnVisit;
import com.ysy.petadopt.repository.ReturnVisitRepository;
import com.ysy.petadopt.service.ReturnVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReturnVisitServiceImpl implements ReturnVisitService {

    @Autowired
    private ReturnVisitRepository returnVisitRepository;

    @Override
    public ReturnVisit save(ReturnVisit returnVisit) {
        return returnVisitRepository.save(returnVisit);
    }

    @Override
    public List<ReturnVisit> findAll() {
        return returnVisitRepository.findAll();
    }
}
