package com.ysy.petadopt.repository;

import com.ysy.petadopt.entity.AdoptComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdoptCommentRepository extends JpaRepository<AdoptComment, Integer> {


    List<AdoptComment> findByAdoptId(Integer adoptId);

}
