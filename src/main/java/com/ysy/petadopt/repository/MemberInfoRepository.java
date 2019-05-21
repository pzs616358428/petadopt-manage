package com.ysy.petadopt.repository;

import com.ysy.petadopt.entity.MemberInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberInfoRepository extends JpaRepository<MemberInfo, Integer> {
}
