package com.example.demo.controladores;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.modelos.Persona;
import com.example.demo.repositorios.IPersonaRepo;

@Controller
public class PersonaController {
	@Autowired
	private IPersonaRepo repo;
	
	@GetMapping("/personas")
	public String GetAll(Model model) {
		model.addAttribute("personas",repo.findAll());
		return "personas";
	}
	@GetMapping("/persona/{id}")
	public String GetOne(@PathVariable("id") Integer id,Model model) {
		Persona persona = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	     
		model.addAttribute("persona",persona);
		return "persona";
	}
	@GetMapping("/persona")
	public String FormAdd() {
		
		return "FormAddPersona";
	}
	@PostMapping("persona")
	public String SavePersona(@RequestParam(name="nombre") String nombre,@RequestParam(name="apellidos") String apellidos,@RequestParam(name="edad") Integer edad) {
		Persona persona = new Persona();
		persona.setNombre(nombre);
		persona.setApellidos(apellidos);
		persona.setEdad(edad);
		repo.save(persona);
		return "redirect:/personas";
	}
}
