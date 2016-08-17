package fr.imie.appformusic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.imie.appformusic.configuration.constants.Routes;
import fr.imie.appformusic.configuration.constants.Views;

@Controller
@RequestMapping(Routes.HOME)
public class HomeController {

	public ModelAndView init(){
		return new ModelAndView(Views.HOME);
	}
	
}
