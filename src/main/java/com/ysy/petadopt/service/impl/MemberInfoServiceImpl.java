package com.ysy.petadopt.service.impl;

import com.ysy.petadopt.entity.MemberInfo;
import com.ysy.petadopt.repository.MemberInfoRepository;
import com.ysy.petadopt.service.MemberInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberInfoServiceImpl implements MemberInfoService {

    @Autowired
    private MemberInfoRepository memberInfoRepository;

    @Override
    public MemberInfo save(MemberInfo memberInfo) {
        return memberInfoRepository.save(memberInfo);
    }

    @Override
    public MemberInfo findOne(Integer memberId) {
        MemberInfo memberInfo = new MemberInfo();
        memberInfo.setMemberId(memberId);
        return memberInfoRepository.findOne(Example.of(memberInfo)).get();
    }

    @Override
    public List<MemberInfo> findAll() {
        return memberInfoRepository.findAll();
    }
}
