package com.nautilus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nautilus.vo.Augments;

@Mapper
public interface AugmentsMapper 
{
	List<Augments> findByKey(String key);
}
