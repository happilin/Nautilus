package com.nautilus.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nautilus.service.SynergyService;
import com.nautilus.vo.Champion;
import com.nautilus.vo.ClassEffect;
import com.nautilus.vo.Classes;
import com.nautilus.vo.OriginEffect;
import com.nautilus.vo.Origins;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/syn")
public class SynergyController {

	@Autowired
	private SynergyService synService;
	
	@GetMapping("/champions")
	public String champions(Model model) {
		List<Champion> list = synService.getChamList();
		model.addAttribute("list",list);
		return "thymeleaf/championPage";
	}
	
	//origin = 계열
	@GetMapping("/origins")
	public String origins(Model model) {
	
		// 서비스를 통해 origin의 name과 explan을 리스트로 가져온다
		List<Origins> oriList = synService.getOriginsList();
		
		// LinkedHashMap > Map을 순서대로 저장
		// 해당 origin 속성을 가진 챔피언들의 리스트를 저장
		// 해당 origin 의 효과를 저장
		Map<Origins,List<Champion>> originChamp = new LinkedHashMap<>();
		Map<String,List<OriginEffect>> originEff = new LinkedHashMap<>();
		
		for(int i=0;i<oriList.size();i++) {
			String originName = oriList.get(i).getKorname();
			List<Champion> chamList = synService.getChampionAll(originName);
			List<OriginEffect> effectList = synService.getOriginEffect(originName);
			
			originChamp.put(oriList.get(i), chamList);
			originEff.put(originName, effectList);
		}
		
		model.addAttribute("originChamp",originChamp);
		model.addAttribute("originEff",originEff);
		return "thymeleaf/origins";
	}
	
	//class = 직업
	@GetMapping("/classes")
	public String classes(Model model) {
		
		List<Classes> classList = synService.getClassesList();
		Map<Classes,List<Champion>> classChamp = new LinkedHashMap<>();
		Map<String,List<ClassEffect>> classEff = new LinkedHashMap<>();
		
		for(int i=0;i<classList.size();i++) {
			String className = classList.get(i).getKorname();
			List<Champion> chamList = synService.getChampionAll(className);
			List<ClassEffect> effectList = synService.getClassEffect(className);
			
			classChamp.put(classList.get(i), chamList);
			classEff.put(className, effectList);
		}
		
		model.addAttribute("classChamp",classChamp);
		model.addAttribute("classEff",classEff);
		return "thymeleaf/classes";
	}
	
	//족보
	@GetMapping("/cheat")
	public String cheetSheet(Model model){
		List<String> classList = synService.getClassNameList();
		List<String> originList = synService.getOriginNameList();
		List<Champion> chamList = synService.getChamList();

		model.addAttribute("classList",classList);
		model.addAttribute("originList",originList);
		model.addAttribute("chamList",chamList);
		
		return "thymeleaf/cheatsheet";
	}
	
	@GetMapping("/detail/{synname}")
	public String detail(Model model,
			@PathVariable("synname") String synname) {
		
		Map<String,String> check = synService.search(synname);
		List<Champion> chamList = synService.getChamListBySynergy(synname);
		
		if(check.get("type").equals("classes")) {
			Classes fClass = synService.getClass(synname);
			List<ClassEffect> effectList = synService.getClassEffect(synname);
			model.addAttribute("synergy",fClass);
			model.addAttribute("effectList",effectList);
		}
		else if(check.get("type").equals("origins")) {
			Origins fOrigin = synService.getOrigin(synname);
			List<OriginEffect> effectList = synService.getOriginEffect(synname);
			model.addAttribute("synergy",fOrigin);
			model.addAttribute("effectList",effectList);
		}
		model.addAttribute("chamList",chamList);
		return "thymeleaf/synergy_detail";
	}
}
