package com.ysy.petadopt.repository;

import com.ysy.petadopt.entity.Adopt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdoptRepository extends JpaRepository<Adopt, Integer> {
}
