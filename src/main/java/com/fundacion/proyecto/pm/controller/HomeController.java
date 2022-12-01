package com.fundacion.proyecto.pm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping({"/","/index","/home","/inicio"})
	public String inicio() {
		return "home";
	}
}
