package com.ysy.petadopt.repository;

import com.ysy.petadopt.entity.Apply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ApplyRepository extends JpaRepository<Apply, Integer> {

    @Transactional
    @Modifying
    @Query(value = "delete from p_apply_adopt where adopt_id = ?1")
    void deleteByAdoptId(Integer adoptId);

}
