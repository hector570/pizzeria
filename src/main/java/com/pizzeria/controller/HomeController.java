package com.pizzeria.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pizzeria.utils.Utils;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@RequestMapping
	public String index(Authentication authentication) {
		
		//si esta logueado
		if (Utils.isLogged(authentication)) {
			return "redirect:/home";
		} else {
			return "index";
		}
	}
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/403")
	public String accesoDenegado(Model model) {

		model.addAttribute("message", "No tienes permiso de acceso a esta página");

		return "403page";
	}
}
