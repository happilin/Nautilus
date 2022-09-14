package com.nautilus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nautilus.vo.Origins;

@Repository
public interface OriginRepository extends JpaRepository<Origins, Integer>{

}
