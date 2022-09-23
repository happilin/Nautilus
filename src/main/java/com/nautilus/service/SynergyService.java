package com.nautilus.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nautilus.mapper.ChampionMapper;
import com.nautilus.mapper.SynergyMapper;
import com.nautilus.vo.Champion;
import com.nautilus.vo.Synergy;
import com.nautilus.vo.SynergyEffect;

@Service
public class SynergyService {
	
	@Autowired
	private ChampionMapper chamMapper;
	
	@Autowired
	private SynergyMapper synergyMapper;
		
	public List<Champion> getChamList(){
		return chamMapper.findAll();
	}
	
	public List<Champion> getChamListBySynergy(String synergy) {
		return chamMapper.getChampionBySynergy(synergy);
	}
	
	public List<String> getClassNameList(){
		return synergyMapper.findClassAllName();
	}
	
	public List<String> getOriginNameList(){
		return synergyMapper.findOriginAllName();
	}
	
	public List<Synergy> getOriginsList() {
		return synergyMapper.findOriginAll();
	}
	
	public List<Synergy> getClassesList(){
		return synergyMapper.findClassAll();
	}

	public List<SynergyEffect> getSynergyEffect(String synergyName) {
		return synergyMapper.findSynergyEffect(synergyName);
	}

	public List<Champion> getChampionAll(String synergy){
		return chamMapper.getChampionAll(synergy);
	}

	public Synergy getClass(String name) {
		return synergyMapper.findClass(name);
	}

	public Synergy getOrigin(String name) {
		return synergyMapper.findOrigin(name);
	}

	public Synergy search(String synname) {
		return synergyMapper.getSynergySearch(synname);
	}

	public Map<String, Object> getSynInfo(String synname) {
		
		Map<String, Object> getSynInfo = new HashMap<String, Object>();
		
		Synergy synergy = search(synname);
		List<Champion> chamList = getChamListBySynergy(synname);
		List<SynergyEffect> effectList = getSynergyEffect(synname);
		
		getSynInfo.put("synergy", synergy);
		getSynInfo.put("chamList", chamList);
		getSynInfo.put("effectList", effectList);
		
		return getSynInfo;
	}
}
