package com.nautilus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nautilus.vo.Augments;

public interface AgmRepository extends JpaRepository<Augments, String>
{
	List<Augments> findByAgmLevel(Integer agmLevel);
	
	List<Augments> findByName(String name);
}
