package com.nautilus.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.nautilus.vo.Synergy;
import com.nautilus.vo.SynergyEffect;

@Mapper
public interface SynergyMapper {

	List<Synergy> findClassAll();

	List<SynergyEffect> findSynergyEffect(String synergy);

	List<String> findClassAllName();

	List<Synergy> findOriginAll();

	List<String> findOriginAllName();
	
	Synergy getSynergySearch (String name);
	
	Synergy findClass(String name);

	Synergy findOrigin(String name);
	
}
