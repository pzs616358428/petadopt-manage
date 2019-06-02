package com.ysy.petadopt.service;

import com.ysy.petadopt.entity.AdoptComment;

import java.util.List;

public interface AdoptCommentService {

    AdoptComment save(AdoptComment adoptComment);

    List<AdoptComment> findByAdoptId(Integer adoptId);

}
