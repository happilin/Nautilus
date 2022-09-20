package com.nautilus.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nautilus.mapper.ChampionMapper;
import com.nautilus.vo.ChampionDetail;

@Service
public class ChampionService {

	@Autowired
	private ChampionMapper chamMapper;
	
	public ChampionDetail detailCham(String name) {
		return chamMapper.detailCham(name);
	}

	public ChampionDetail detailKorCham(String name) {
		return chamMapper.detailCham(name);
	}
	
}
