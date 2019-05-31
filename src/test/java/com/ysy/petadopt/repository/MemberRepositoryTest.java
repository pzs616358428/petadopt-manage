package com.ysy.petadopt.repository;

import com.ysy.petadopt.entity.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void findByIdTest() {
        Member member = new Member();
        member.setMemberName("member");
        member.setPassword("234234");
        Example<Member> example = Example.of(member);
        System.out.println(memberRepository.findOne(example).isPresent());
        /*Member member1 = memberRepository.findOne(example).get();
        System.out.println(member1);*/
    }

    @Test
    public void findOneTest() {
//        System.out.println(memberRepository.findById(8).get().getMemberInfo());
    }

}