package com.ysy.petadopt.service;

import com.ysy.petadopt.entity.Member;
import org.springframework.data.domain.Example;

public interface MemberService {

    Member findOneByParm(Example<Member> example);

    Member save(Member member);

}
