package com.ysy.petadopt.service;

import com.ysy.petadopt.entity.MemberInfo;

import java.util.List;

public interface MemberInfoService {

    MemberInfo save(MemberInfo memberInfo);

    MemberInfo findOne(Integer memberId);

    List<MemberInfo> findAll();

}
