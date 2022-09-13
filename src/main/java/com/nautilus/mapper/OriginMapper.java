package com.nautilus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nautilus.vo.OriginEffect;
import com.nautilus.vo.Origins;

@Mapper
public interface OriginMapper {

	List<Origins> findAll();

	List<OriginEffect> findEffect(String origin);

	List<String> findAllName();
}
