package com.nautilus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/main")
public class MainController {

	@GetMapping("/index")
	public String MainPage() {
		//asd
		return "thymeleaf/mainpage";
	}
}
