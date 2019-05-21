package com.ysy.petadopt.service.impl;

import com.ysy.petadopt.entity.Member;
import com.ysy.petadopt.repository.MemberRepository;
import com.ysy.petadopt.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Member findOneByParm(Example<Member> example) {
        Optional<Member> optional = memberRepository.findOne(example);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            return null;
        }
    }

    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }
}
