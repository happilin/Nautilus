package com.nautilus.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nautilus.mapper.MainMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/main")
public class MainController {

	@Autowired
	private MainMapper mainMapper;
	
	@GetMapping("/index")
	public String MainPage() {
		return "thymeleaf/mainpage";
	}
	
	@PostMapping("/search")
	//@ResponseBody
	public String search(
			@RequestParam(value="name") String name) {
		Map<String,String> check = mainMapper.getSearch(name);
		String type = check.get("type");
		
		return "redirect:/syn/"+type;
		//return type;
		//return check;
	}
	
	@GetMapping("/test")
	public String test() {
		
		return "redirect:/syn/detail/origin";
	}
}
