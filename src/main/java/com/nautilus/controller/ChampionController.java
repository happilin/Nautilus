package com.nautilus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nautilus.repository.ChampionRepository;
import com.nautilus.service.ChampionService;
import com.nautilus.vo.Champion;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/cham")
public class ChampionController {

	@Autowired
	private ChampionService chamService;
	
	@Autowired
	private ChampionRepository repository;
	
	@GetMapping("/chamList")
	public String chamList(Model model, 
						@RequestParam(required = false, defaultValue = "") String searchText)
	{
//		List<Champion> list = chamService.getChamList();
//		List<Champion> list = repository.findByKornameContainingOrClassesContainingOrOriginsContaining(searchText, searchText, searchText);
		List<Champion> list = repository.findByKornameContaining(searchText);
		model.addAttribute("list",list);
		return "thymeleaf/championPage";
	}
	
	@GetMapping("/detailCham/{korname}")
	public String detailCham(@PathVariable("korname") String korname,
							@RequestParam(required = false, defaultValue = "") String searchText,
							Model model)
	{
//		List<Champion> list = chamService.getChamList();
		List<Champion> list = repository.findByKornameContaining(searchText);
		Champion cham = chamService.detailCham(korname);
		model.addAttribute("cham", cham);
		model.addAttribute("list",list);
		return "thymeleaf/detail_cham";
	}

}
