package com.nautilus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nautilus.mapper.ChampionMapper;
import com.nautilus.mapper.ClassMapper;
import com.nautilus.mapper.OriginMapper;
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
	private ClassMapper classMapper;
	
	@Autowired
	private OriginMapper originMapper;
	
	public List<Champion> getChamList(){
		return chamMapper.findAll();
	}
	
	public List<String> getChamListByOrigin(String originName) {
		return chamMapper.getChampionByOrigin(originName);
	}
	
	public List<String> getChamListByClass(String className) {
		return chamMapper.getChampionByClass(className);
	}
	
	public List<String> getClassNameList(){
		return classMapper.findAllName();
	}
	
	public List<String> getOriginNameList(){
		return originMapper.findAllName();
	}
	
	public List<Origins> getOriginsList() {
		return originMapper.findAll();
	}
	
	public List<Classes> getClassesList(){
		return classMapper.findAll();
	}

	public List<OriginEffect> getOriginEffect(String originName) {
		return originMapper.findEffect(originName);
	}

	public List<ClassEffect> getClassEffect(String className) {
		return classMapper.findEffect(className);
	}

	public List<Champion> getChampionAll(String synergy){
		return chamMapper.getChampionAll(synergy);
	}

	public Classes getClass(String name) {
		return classMapper.findClass(name);
	}

	public Origins getOrigin(String name) {
		return originMapper.findOrigin(name);
	}
}
