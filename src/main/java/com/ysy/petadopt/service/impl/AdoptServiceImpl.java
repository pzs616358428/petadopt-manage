package com.ysy.petadopt.service.impl;

import com.ysy.petadopt.entity.Adopt;
import com.ysy.petadopt.repository.AdoptRepository;
import com.ysy.petadopt.service.AdoptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdoptServiceImpl implements AdoptService {

    @Autowired
    private AdoptRepository adoptRepository;

    @Override
    public Page<Adopt> findAll(Example<Adopt> example, Pageable pageable) {
        return adoptRepository.findAll(example, pageable);
    }

    @Override
    public Adopt findAdoptById(Integer adoptId) {
        return adoptRepository.findById(adoptId).get();
    }

}
