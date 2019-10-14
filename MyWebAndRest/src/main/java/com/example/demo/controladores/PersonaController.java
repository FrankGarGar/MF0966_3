package com.example.demo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repositorios.IPersonaRepo;

@Controller
public class PersonaController {
	@Autowired
	private IPersonaRepo repo;
	
	@GetMapping("/personas")
	public String personas(Model model) {
		model.addAttribute("personas",repo.findAll());
		return "hola";
	}
}
