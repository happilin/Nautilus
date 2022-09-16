package com.nautilus.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nautilus.mapper.ChampionMapper;
import com.nautilus.vo.Champion;

@Service
public class ChampionService {

	@Autowired
	private ChampionMapper chamMapper;
	
	public List<Champion> getChamList(){
		return chamMapper.findAll();
	}

	public Champion detailCham(String korname) {
		return chamMapper.detailCham(korname);
	}

	public List<Champion> getSearchCham(Champion champion) {
		return chamMapper.getSearchCham(champion);
	}
	
}
