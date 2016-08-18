package fr.imie.appformusic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
/**
 * Controleur permettant de tester l'affichage des vues.
 * @author Dorian
 *
 */
public class TestController {
	
	@RequestMapping("/main")
	public ModelAndView testView() {
		return new ModelAndView();
	}

}
