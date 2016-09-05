package fr.imie.appformusic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.imie.appformusic.configuration.constants.Routes;
import fr.imie.appformusic.configuration.constants.Views;
import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.exceptions.BusinessException;
import fr.imie.appformusic.form.FullUserForm;
import fr.imie.appformusic.service.IUserService;

@Controller
public class ProfileController {
	
	@Autowired
	private IUserService userService;

	/**
	 * Affiche le profile de l'utilisateur spécifié.
	 * @param username L'identifiant de l'utilisateur.
	 * @return La vue du profil.
	 * @throws BusinessException
	 */
	@RequestMapping(Routes.PROFILE + "/@{username}")
	public ModelAndView showUserProfile(
			HttpServletRequest request,
			Model model,
			@PathVariable(value = "username") String username
	) throws BusinessException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		// Si l'utilisateur affiché est l'utilisateur authentifié
		if (username == auth.getName()) {
			
		}
		ModelAndView mav = new ModelAndView(Views.PROFILE);
		AppUser user = userService.findByUserName(username);
		model.addAttribute("fullUserForm", new FullUserForm());
		model.addAttribute("user", user);
		return mav;
	}

	/**
	 * Affiche le profile de l'utilisateur authentifié.
	 * @param model
	 * @return
	 * @throws BusinessException 
	 */
	@RequestMapping(value = Routes.PROFILE + "/@{username}", method = RequestMethod.POST)
	public ModelAndView updateMyProfile(
			FullUserForm form,
			@PathVariable(value = "username") String username
	) throws BusinessException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		AppUser user = userService.findByUserName(auth.getName());
		
		// Si l'utilisateur à modifier est l'utilisateur authentifié
		if (username.equals(auth.getName())) {
			userService.updateUser(user, form.getEmail(), form.getPassword(), form.getNewPassword(), form.getPasswordConfirm(), form.getFirstName(), form.getLastName());
		}
		
		return new ModelAndView("redirect:" + Routes.PROFILE + "/@" + username);
	}

}
