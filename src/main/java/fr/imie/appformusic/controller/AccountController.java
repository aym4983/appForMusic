package fr.imie.appformusic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.imie.appformusic.configuration.constants.Routes;
import fr.imie.appformusic.configuration.constants.Views;
import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.exceptions.BusinessException;
import fr.imie.appformusic.form.UserForm;
import fr.imie.appformusic.service.IUserService;

@Controller
public class AccountController {
	
	@Autowired
	private IUserService userService;
	
	private static final Logger log = Logger.getLogger(AccountController.class);
	
	/**
	 * Affiche le formulaire d'inscription.
	 * @param model Le modèle utilisé par la page. 
	 * @return La vue du formulaire d'inscription.
	 */
	@RequestMapping(Routes.SIGNUP)
	public ModelAndView showSignUpForm(Model model) {
		log.info("log info test");
		ModelAndView mav = new ModelAndView(Views.SIGNUP);
		mav.addObject("urlSignIn", Routes.SIGNIN);
		model.addAttribute(new UserForm());
		return mav; 
	}
	
	/**
	 * Affiche le formulaire de connexion.
	 * @param model Le modèle utilisé par la page. 
	 * @return La vue du formulaire de connexion.
	 * @throws BusinessException 
	 */
	@RequestMapping(value=Routes.SIGNIN, method=RequestMethod.GET)
	public ModelAndView showSignInForm(Model model) throws BusinessException {
		ModelAndView mav = new ModelAndView(Views.SIGNIN);
		mav.addObject("urlSignUp", Routes.SIGNUP);
		model.addAttribute(new AppUser());
		return mav; 
	}

	/**
	 * Traite les données soumises du formulaire d'inscription.
	 * @param user 		L'utilisateur à créer.
	 * @return 			Une redirection vers la page d'accueil du site en cas de réussite, sinon vers le formulaire.
	 */
	@RequestMapping(value=Routes.SIGNUP, method=RequestMethod.POST)
	public ModelAndView submitSignUpForm(
			UserForm userForm)
	throws BusinessException {
		// mapping
		AppUser user = new AppUser();
		user.setUsername(userForm.getUsername());
		user.setEmail(userForm.getEmail());
		userService.create(user, userForm.getPassword(), userForm.getPasswordConfirm());
		return new ModelAndView("redirect:/" + Routes.HOME);
	}

	/**
	 * Déconnecte l'utilisateur.
	 * @return Une redirection vers la page d'accueil.
	 */
	@RequestMapping(Routes.SIGNOUT)
	public ModelAndView signOut(HttpServletRequest request, HttpServletResponse response) 
			throws BusinessException {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
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
 
	
	
//	@RequestMapping(Routes.ERROR)
//	public ModelAndView showErrorPage(Model model) {
//		ModelAndView mav = new ModelAndView(Views.ERROR);
//		return mav; 
//	}

}
