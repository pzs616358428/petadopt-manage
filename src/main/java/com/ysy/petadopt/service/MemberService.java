package com.ysy.petadopt.service;

import com.ysy.petadopt.entity.Member;
import org.springframework.data.domain.Example;

import java.util.List;

public interface MemberService {

    Member findOneByParm(Example<Member> example);

    Member save(Member member);

    List<Member> findAll();

}
