package com.nautilus.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.nautilus.vo.ClassEffect;
import com.nautilus.vo.Classes;
import com.nautilus.vo.OriginEffect;
import com.nautilus.vo.Origins;

@Mapper
public interface SynergyMapper {

	List<Classes> findClassAll();

	List<ClassEffect> findClassEffect(String className);

	List<String> findClassAllName();

	List<Origins> findOriginAll();

	List<OriginEffect> findOriginEffect(String origin);

	List<String> findOriginAllName();
	
	Map<String,String> getSynergySearch (String name);
	
	Classes findClass(String name);

	Origins findOrigin(String name);
	
}
