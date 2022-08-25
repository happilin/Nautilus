package com.nautilus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nautilus.service.ChampionService;
import com.nautilus.vo.Champion;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/cham")
public class ChampionController {

	@Autowired
	private ChampionService chamService;
	
	@GetMapping("/chamList")
	public String chamList(Model model) {
		List<Champion> list = chamService.getChamList();
		model.addAttribute("list",list);
		return "thymeleaf/championPage";
	}
	
	@GetMapping("/detailCham/{name}")
	public String detailCham(@PathVariable("name") String name, Model model)
	{
		List<Champion> list = chamService.getChamList();
		Champion cham = chamService.detailCham(name);
		model.addAttribute("cham", cham);
		model.addAttribute("list",list);
		return "thymeleaf/detail_cham";
	}
}
