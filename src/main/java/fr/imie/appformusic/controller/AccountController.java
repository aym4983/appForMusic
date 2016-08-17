package fr.imie.appformusic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.imie.appformusic.configuration.constants.Routes;
import fr.imie.appformusic.configuration.constants.Session;
import fr.imie.appformusic.configuration.constants.Views;
import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.exceptions.BusinessException;
import fr.imie.appformusic.form.UserForm;
import fr.imie.appformusic.service.IUserService;

@Controller
public class AccountController {
	
	@Autowired
	private IUserService userService;

	/**
	 * Affiche le formulaire d'inscription.
	 * @param model Le modèle utilisé par la page. 
	 * @return La vue du formulaire d'inscription.
	 */
	@RequestMapping(Routes.SIGNUP)
	public ModelAndView showSignUpForm(Model model) {
		ModelAndView mav = new ModelAndView(Views.SIGNUP);
		mav.addObject("urlSignIn", Routes.SIGNIN);
		model.addAttribute(new UserForm());
		return mav; 
	}
	
	/**
	 * Affiche le formulaire de connexion.
	 * @param model Le modèle utilisé par la page. 
	 * @return La vue du formulaire de connexion.
	 */
	@RequestMapping(Routes.SIGNIN)
	public ModelAndView showSignInForm(Model model) {
		ModelAndView mav = new ModelAndView(Views.SIGNIN);
		mav.addObject("urlSignUp", Routes.SIGNUP);
		model.addAttribute(new AppUser());
		return mav; 
	}

	/**
	 * Traite les données soumises du formulaire d'inscription.
	 * @param user 		L'utilisateur à créer.
	 * @param request 	La requête HTTP.
	 * @return 			Une redirection vers la page d'accueil du site en cas de réussite, sinon vers le formulaire.
	 */
	@RequestMapping(value=Routes.SIGNUP, method=RequestMethod.POST)
	public ModelAndView submitSignUpForm(
			UserForm userForm, 
			HttpServletRequest request)
	throws BusinessException {
		// mapping
		AppUser user = new AppUser();
		user.setUsername(userForm.getUsername());
		user.setEmail(userForm.getEmail());
		userService.create(user, userForm.getPassword(), userForm.getPasswordConfirm());
		return new ModelAndView("redirect:/" + Routes.HOME);
	}

//	/**
//	 * Traite les données soumises du formulaire de connexion.
//	 * @param user 		L'utilisateur à connecter.
//	 * @param request 	La requête HTTP.
//	 * @return 			Une redirection vers la page d'accueil du site en cas de réussite, sinon vers le formulaire.
//	 */
//	@RequestMapping(value=Routes.SIGNIN, method=RequestMethod.POST)
//	public ModelAndView submitSignInForm(UserForm userForm, HttpServletRequest request) {
//		//TODO Connexion de l'utilisateur.
//		return new ModelAndView("redirect:/" + Routes.HOME);
//	}


}
