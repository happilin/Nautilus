package com.nautilus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nautilus.vo.ChampionDetail;
import com.nautilus.vo.Champion;

@Mapper
public interface ChampionMapper {

	List<Champion> findAll();
	
	List<Champion> getChampionBySynergy(String synergy);
	
	List<Champion> getChampionAll(String synergy);

	ChampionDetail detailCham(String name);
}
