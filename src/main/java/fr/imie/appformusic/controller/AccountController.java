package fr.imie.appformusic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.imie.appformusic.configuration.constants.Routes;
import fr.imie.appformusic.domain.User;
import fr.imie.appformusic.service.IUserService;

@Controller
public class AccountController {
	
	@Autowired
	private IUserService userService;
	
	/**
	 * Méthode affichant le formulaire d'inscription.
	 * @return La vue du formulaire d'inscription.
	 */
	@RequestMapping(Routes.SIGNUP)
	public ModelAndView signUpForm() {
		return new ModelAndView("sign-in");
	}
	
	/**
	 * Méthode traitant les données du formulaire d'inscription.
	 * @return Une redirection vers la page d'accueil du site.
	 */
	@RequestMapping(value=Routes.SIGNUP, method=RequestMethod.POST)
	public ModelAndView signUpValid(User user) {
		userService.add(user);
		return new ModelAndView("redirect:" + Routes.HOME);
	}

}
