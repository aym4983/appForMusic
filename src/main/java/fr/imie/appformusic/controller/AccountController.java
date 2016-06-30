package fr.imie.appformusic.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.imie.appformusic.configuration.constants.Routes;
import fr.imie.appformusic.domain.User;
import fr.imie.appformusic.exceptions.BusinessException;
import fr.imie.appformusic.service.IUserService;

@Controller
public class AccountController {
	
	@Autowired
	private IUserService userService;
	
	/**
	 * Affiche le formulaire d'inscription.
	 * @return La vue du formulaire d'inscription.
	 */
	@RequestMapping(Routes.SIGNUP)
	public ModelAndView signUpForm() {
		return new ModelAndView("sign-in");
	}

	/**
	 * Traite les données soumises du formulaire d'inscription.
	 * @param user 		L'utilisateur à créer.
	 * @param request 	La requête HTTP.
	 * @return 			Une redirection vers la page d'accueil du site.
	 */
	@RequestMapping(value=Routes.SIGNUP, method=RequestMethod.POST)
	public ModelAndView signUpSubmit(User user, HttpServletRequest request) {
		Locale local = request.getLocale();
		try {
			userService.create(user);
		} catch (BusinessException e) {
			switch (e.getCode()) {
				case "":
					
				default:
					break;
			}
			return new ModelAndView("redirect:" + Routes.SIGNUP);
		}
		return new ModelAndView("redirect:" + Routes.HOME);
	}

}
