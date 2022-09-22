package com.nautilus.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nautilus.mapper.MainMapper;
import com.nautilus.service.MainService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/main")
public class MainController {

	@Autowired
	private MainService mainService;
	
	@GetMapping("/main")
	public String MainPage() {
		return "thymeleaf/mainpage";
	}
		
	@GetMapping("/search/{name}")
	@ResponseBody
	public Map<String, Object> search(
			@PathVariable("name") String name) {
		
		Map<String,String> check = mainService.search(name);

		Map<String, Object> returnMap = new HashMap<String,Object>();
		
		if(check.get("korname").equals("nodata")) {
			returnMap.put("data", false);
		}
		else if(check.get("type").equals("champion")) {
			String engName = check.get("korname");
			String url = "/cham/searchCham/"+engName;
			
			returnMap.put("data", true);
			returnMap.put("url", url);
			
		}
		else {
			String url = "/syn/detail/"+check.get("korname");
			returnMap.put("data", true);
			returnMap.put("url", url);
		}

		return returnMap;
	}
	
}
