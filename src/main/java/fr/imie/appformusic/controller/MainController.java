package fr.imie.appformusic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.exceptions.BusinessException;
import fr.imie.appformusic.service.IUserService;
import fr.imie.appformusic.service.UserService;

@Controller
public class MainController {

	@Autowired
	private IUserService service;
	
	@RequestMapping("/main")
	public ModelAndView init(){
		return new ModelAndView("main");
	}
	
	/*
	 * Méthode d'exemple pour tests unitaire
	 */
	@RequestMapping("/main/all")
	public List<AppUser> getAllUsers() throws BusinessException{
		return service.findAllUsers();
 	}
}
