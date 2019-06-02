package com.ysy.petadopt.service.impl;

import com.ysy.petadopt.entity.AdoptComment;
import com.ysy.petadopt.repository.AdoptCommentRepository;
import com.ysy.petadopt.service.AdoptCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdoptCommentServiceImpl implements AdoptCommentService {

    @Autowired
    private AdoptCommentRepository adoptCommentRepository;

    @Override
    public AdoptComment save(AdoptComment adoptComment) {
        return adoptCommentRepository.save(adoptComment);
    }

    @Override
    public List<AdoptComment> findByAdoptId(Integer adoptId) {
        return adoptCommentRepository.findByAdoptId(adoptId);
    }
}
