package fr.imie.appformusic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.imie.appformusic.domain.User;
import fr.imie.appformusic.service.UserMetier;

@Controller
public class MainController {

	@Autowired
	private UserMetier service;
	
	@RequestMapping("/main")
	public ModelAndView init(){
		return new ModelAndView("main");
	}
	
	/*
	 * Méthode d'exemple pour tests unitaire
	 */
	@RequestMapping("/main/all")
	public List<User> getAllUsers(){
		return service.findAllUsers();
 	}
}
