package com.ysy.petadopt.service;

import com.ysy.petadopt.entity.Adopt;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdoptService {

    Page<Adopt> findAll(Example<Adopt> example, Pageable pageable);

    Adopt findAdoptById(Integer adoptId);

}
