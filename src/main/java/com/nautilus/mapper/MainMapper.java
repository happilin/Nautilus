package com.nautilus.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MainMapper {

	Map<String,String> getSearch(String name);
}
