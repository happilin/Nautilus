package com.nautilus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nautilus.mapper.AugmentsMapper;
import com.nautilus.repository.AgmRepository;
import com.nautilus.vo.Augments;

@Service
public class AugmentsService
{
	@Autowired
	private AugmentsMapper mapper;
	
	public List<Augments> getListByKey(String key)
	{
		return mapper.findByKey(key);
	}
	
	@Autowired
	private AgmRepository agmRepository;
	
	public List<Augments> getList() 
	{
		return agmRepository.findAll();
	}
	
	public List<Augments> getListByAgmLevel(int i) 
	{
		return agmRepository.findByAgmLevel(i);
	}
	
//	public List<Augments> getListByName(String key)
//	{
//		return agmRepository.findByName(key);
//	}
	
}
