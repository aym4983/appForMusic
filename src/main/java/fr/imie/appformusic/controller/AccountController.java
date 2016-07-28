package fr.imie.appformusic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.imie.appformusic.configuration.constants.Routes;
import fr.imie.appformusic.configuration.constants.Views;
import fr.imie.appformusic.domain.AppUser;
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
	public ModelAndView showSignUpForm() {
		return new ModelAndView(Views.SIGNUP);
	}
	
	/**
	 * Affiche le formulaire de connexion.
	 * @return La vue du formulaire de connexion.
	 */
	@RequestMapping(Routes.SIGNIN)
	public ModelAndView showSignInForm() {
		return new ModelAndView(Views.SIGNIN);
	}

	/**
	 * Traite les données soumises du formulaire d'inscription.
	 * @param user 		L'utilisateur à créer.
	 * @param request 	La requête HTTP.
	 * @return 			Une redirection vers la page d'accueil du site en cas de réussite, sinon vers le formulaire.
	 */
	@RequestMapping(value=Routes.SIGNUP, method=RequestMethod.POST)
	public ModelAndView submitSignUpForm(
			AppUser user, 
			@RequestParam(name="password-confirm") String passwordConfirm, 
			HttpServletRequest request) {
		try {
			userService.create(user);
		} catch (BusinessException e) {
			switch (e.getCode()) {
				case USERNAME_EMPTY:
				case EMAIL_EMPTY:
				case PASSWORD_EMPTY:
				case PASSWORD_CONFIRM_EMPTY:
				default:
					break;
			}
			return new ModelAndView("redirect:/" + Routes.SIGNUP);
		}
		return new ModelAndView("redirect:/" + Routes.HOME);
	}

	/**
	 * Traite les données soumises du formulaire de connexion.
	 * @param user 		L'utilisateur à connecter.
	 * @param request 	La requête HTTP.
	 * @return 			Une redirection vers la page d'accueil du site en cas de réussite, sinon vers le formulaire.
	 */
	@RequestMapping(value=Routes.SIGNIN, method=RequestMethod.POST)
	public ModelAndView submitSignInForm(AppUser user, HttpServletRequest request) {
		try {
			userService.create(user);
		} catch (BusinessException e) {
			switch (e.getCode()) {
				case EMAIL_EMPTY:
					
				default:
					break;
			}
			return new ModelAndView("redirect:/" + Routes.SIGNIN);
		}
		return new ModelAndView("redirect:/" + Routes.HOME);
	}
	

}
