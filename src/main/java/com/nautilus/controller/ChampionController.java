package com.nautilus.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nautilus.repository.ChampionRepository;
import com.nautilus.service.ChampionService;
import com.nautilus.service.SynergyService;
import com.nautilus.vo.ChampionDetail;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/cham")
public class ChampionController {

	@Autowired
	private ChampionService chamService;
	
	@Autowired
	private ChampionRepository repository;
	
	@Autowired
	private SynergyService synService;
	
	@GetMapping("/chamList")
	public String chamList(Model model, 
						@RequestParam(required = false, defaultValue = "") String searchText)
	{
//		List<Champion> list = chamService.getChamList();
//		List<Champion> list = repository.findByKornameContainingOrClassesContainingOrOriginsContaining(searchText, searchText, searchText);
		List<ChampionDetail> list = repository.findByKornameContaining(searchText);
		model.addAttribute("list",list);
		return "thymeleaf/championPage";
	}
	
	@GetMapping("/detailCham/{name}")
	public String detailCham(@PathVariable("name") String name,
							@RequestParam(required = false, defaultValue = "") String searchText,
							Model model)
	{
//		List<Champion> list = chamService.getChamList();
		List<ChampionDetail> list = repository.findByKornameContaining(searchText);
		ChampionDetail cham = chamService.detailCham(name);
		
		if(cham.getClasses1() != null) {
			Map<String, Object> synergy1 = synService.getSynInfo(cham.getClasses1());
			model.addAttribute("synergy1",synergy1);
			log.info(synergy1.toString());
		}
		if(cham.getClasses2() != null) {
			Map<String, Object> synergy2 = synService.getSynInfo(cham.getClasses2());
			model.addAttribute("synergy2",synergy2);
		}
		if(cham.getOrigins1() != null) {
			Map<String, Object> synergy3 = synService.getSynInfo(cham.getOrigins1());
			model.addAttribute("synergy3",synergy3);
		}
		if(cham.getOrigins2() != null) {
			Map<String, Object> synergy4 = synService.getSynInfo(cham.getOrigins2());
			model.addAttribute("synergy4",synergy4);
		}
		
		model.addAttribute("cham", cham);
		model.addAttribute("list",list);
		return "thymeleaf/detail_cham";
	}
	
	@GetMapping("/searchCham/{name}")
	public String detailCham(@PathVariable("name") String name, Model model)
	{
//		log.info(name);
		ChampionDetail cham = chamService.detailKorCham(name);
		model.addAttribute("cham", cham);
		return "thymeleaf/detail_cham";
	}
}
