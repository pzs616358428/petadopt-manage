package com.ysy.petadopt.service;

import com.ysy.petadopt.entity.ReturnVisit;

import java.util.List;

public interface ReturnVisitService {

    ReturnVisit save(ReturnVisit returnVisit);

    List<ReturnVisit> findAll();

}
