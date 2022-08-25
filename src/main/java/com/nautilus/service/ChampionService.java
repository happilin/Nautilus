package com.nautilus.service;

import java.util.List;

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

	public Champion detailCham(String name) {
		return chamMapper.detailCham(name);
	}
	
}
