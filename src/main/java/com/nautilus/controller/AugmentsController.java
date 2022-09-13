package com.nautilus.controller;

import java.util.List;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nautilus.service.AugmentsService;
import com.nautilus.vo.Augments;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/agm")
public class AugmentsController 
{
	@Autowired
	private AugmentsService svc;
	
//	@GetMapping("")
//	@ResponseBody
//	public String test()
//	{
//		return "Augments Controller";
//	}
	
	@GetMapping("")
	public String listAll(Model model)
	{
		List<Augments> list = svc.getListByAgmLevel(1);
		model.addAttribute("list", list);
		log.debug("list.size():{}", list.size());
		
		return "thymeleaf/augments";
	}
	
	@GetMapping("/{agmLevel}")
	public String listByLevel(@PathVariable("agmLevel")int agmLevel, Model model)
	{
		List<Augments> list = svc.getListByAgmLevel(agmLevel);
		log.debug("listByLevel() > getList.size(): {}", list.size());
		model.addAttribute("list", list);
		
		return "thymeleaf/augments";
	}
	
	@GetMapping("/search/{keyword}")
	public String search(@PathVariable("keyword")String key, Model model) 
	{
		List<Augments> list = svc.getListByKey(key);
		log.debug("serach() > getList.size(): {}", list.size());
		model.addAttribute("list", list);
		
		return "thymeleaf/augments";
	}

}
