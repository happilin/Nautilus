package com.nautilus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nautilus.vo.ClassEffect;
import com.nautilus.vo.Classes;
import com.nautilus.vo.OriginEffect;

@Mapper
public interface ClassMapper {

	List<Classes> findAll();

	List<ClassEffect> findEffect(String className);

	List<String> findAllName();

}
