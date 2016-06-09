package fr.imie.appformusic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping("/main")
	public ModelAndView init(){
		return new ModelAndView("main");
	}
	
}
