package com.nautilus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nautilus.vo.ChampionDetail;
import com.nautilus.vo.Champion;

@Mapper
public interface ChampionMapper {

	List<Champion> findAll();
	
	List<String> getChampionByOrigin(String synergy);

	List<String> getChampionByClass(String synergy);
	
	List<Champion> getChampionAll(String synergy);

	List<Champion> getChampionCrossList(String classname, String originname);

	ChampionDetail detailCham(String name);
}
