package com.nautilus.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nautilus.mapper.ChampionMapper;
import com.nautilus.mapper.SynergyMapper;
import com.nautilus.vo.Champion;
import com.nautilus.vo.ClassEffect;
import com.nautilus.vo.Classes;
import com.nautilus.vo.OriginEffect;
import com.nautilus.vo.Origins;

@Service
public class SynergyService {
	
	@Autowired
	private ChampionMapper chamMapper;
	
	@Autowired
	private SynergyMapper synergyMapper;
		
	public List<Champion> getChamList(){
		return chamMapper.findAll();
	}
	
	public List<Champion> getChamListBySynergy(String originName) {
		return chamMapper.getChampionBySynergy(originName);
	}
	
	public List<String> getClassNameList(){
		return synergyMapper.findClassAllName();
	}
	
	public List<String> getOriginNameList(){
		return synergyMapper.findOriginAllName();
	}
	
	public List<Origins> getOriginsList() {
		return synergyMapper.findOriginAll();
	}
	
	public List<Classes> getClassesList(){
		return synergyMapper.findClassAll();
	}

	public List<ClassEffect> getClassEffect(String className) {
		return synergyMapper.findClassEffect(className);
	}
	
	public List<OriginEffect> getOriginEffect(String originName) {
		return synergyMapper.findOriginEffect(originName);
	}

	public List<Champion> getChampionAll(String synergy){
		return chamMapper.getChampionAll(synergy);
	}

	public Classes getClass(String name) {
		return synergyMapper.findClass(name);
	}

	public Origins getOrigin(String name) {
		return synergyMapper.findOrigin(name);
	}

	public Map<String, String> search(String synname) {
		return synergyMapper.getSynergySearch(synname);
	}
}
