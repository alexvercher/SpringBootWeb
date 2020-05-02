package com.avc.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.avc.springboot.web.app.models.Usuario;
//import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/app")
public class IndexController {

	/*
	@GetMapping({"/index", "/", "/home"})
	public ModelAndView index(ModelAndView mav) {
		mav.addObject("titulo", "Hola Spring Framework");
		mav.setViewName("index");
		return mav;
	}*/
	
	@GetMapping({"/index", "/", "", "/home"})
	public String index(Model model) {
		model.addAttribute("titulo", "Hola Spring Framework");
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario("Alex", "Vercher", "test@test.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfil usuario ".concat(usuario.getNombre()));
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		List<Usuario> usuarios = Arrays.asList(new Usuario("Alex", "Vercher", "alex@email.com"),
				new Usuario("Juan", "González", "juan@email.com"),
				new Usuario("Javier", "Menudillo", "javier@email.com"),
				new Usuario("Jose", "Pérez", "jose@email.com"));
		
		model.addAttribute("titulo", "Listado de usuarios");
		model.addAttribute("usuarios", usuarios);
		return "listar";
	}
}
