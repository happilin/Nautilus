package com.nautilus.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.nautilus.mapper.MainMapper;

@Service
public class MainService {

	@Autowired
	private MainMapper mainMapper;
	
	public Map<String, String> search(
			@PathVariable("name") String name) {
		
		List<Map<String,String>> check = mainMapper.getSearch(name);
		
		// 만약 가져온 값이 2개 이상 >> 검색한 값이 존재 할때
		// 검색된 값만 추려서 보내기
		if(check.size() >= 2) {
			for(int i=0;i<check.size();i++) {
				if(check.get(i).get("korname").equals("nodata")) {
					check.remove(i);
				}
			}
		}
		// 하지만 가져온 값이 없을 때 >> 검색 자료가 존재하지 않음
		// nodata 반환 >> 검색 자료가 없다

		Map<String,String> data = check.get(0);
		return data;
	}
}
