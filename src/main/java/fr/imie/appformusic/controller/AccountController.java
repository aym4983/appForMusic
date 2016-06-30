package fr.imie.appformusic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.imie.appformusic.configuration.constants.Routes;

@Controller
public class AccountController {
	
	/**
	 * Méthode affichant le formulaire d'inscription.
	 * @return La vue du formulaire d'inscription.
	 */
	@RequestMapping(Routes.SIGNIN)
	public ModelAndView signInForm() {
		return new ModelAndView("sign-in");
	}
	
	/**
	 * Méthode traitant le formulaire d'inscription.
	 * @return Une redirection vers la page d'accueil du site.
	 */
	@RequestMapping(value=Routes.SIGNIN, method=RequestMethod.POST)
	public ModelAndView signInValid() {
		return new ModelAndView("redirect:" + Routes.HOME);
	}

}
