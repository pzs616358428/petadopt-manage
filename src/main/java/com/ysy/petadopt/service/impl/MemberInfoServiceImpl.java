package com.ysy.petadopt.service.impl;

import com.ysy.petadopt.entity.MemberInfo;
import com.ysy.petadopt.repository.MemberInfoRepository;
import com.ysy.petadopt.service.MemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberInfoServiceImpl implements MemberInfoService {

    @Autowired
    private MemberInfoRepository memberInfoRepository;

    @Override
    public MemberInfo save(MemberInfo memberInfo) {
        return memberInfoRepository.save(memberInfo);
    }
}
