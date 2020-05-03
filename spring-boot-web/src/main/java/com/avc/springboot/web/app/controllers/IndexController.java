package com.avc.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.avc.springboot.web.app.models.Usuario;
//import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/app")
public class IndexController {

	@Value("${indexcontroller.index.titulo}")
	private String textoIndex;
	@Value("${indexcontroller.perfil.titulo}")
	private String textoPerfil;
	@Value("${indexcontroller.listar.titulo}")
	private String textoListar;
	/*
	@GetMapping({"/index", "/", "/home"})
	public ModelAndView index(ModelAndView mav) {
		mav.addObject("titulo", "Hola Spring Framework");
		mav.setViewName("index");
		return mav;
	}*/
	
	@GetMapping({"/index", "/", "", "/home"})
	public String index(Model model) {
		model.addAttribute("titulo", textoIndex);
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario("Alex", "Vercher", "test@test.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", textoListar);
		//model.addAttribute("usuarios", usuarios);
		return "listar";
	}

	@ModelAttribute("usuarios")	
	private List<Usuario> rellenarUsuarios() {
		List<Usuario> usuarios = Arrays.asList(new Usuario("Alex", "Vercher", "alex@email.com"),
				new Usuario("Juan", "González", "juan@email.com"),
				new Usuario("Javier", "Menudillo", "javier@email.com"),
				new Usuario("Jose", "Pérez", "jose@email.com"));
		return usuarios;
	}
}
