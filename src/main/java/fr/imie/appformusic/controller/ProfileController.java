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
import org.springframework.web.bind.annotation.RequestParam;
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
		ModelAndView mav = new ModelAndView(Views.PROFILE);
		AppUser user = userService.findByUserName(username);
		
		model.addAttribute("fullUserForm", new FullUserForm());
		model.addAttribute("user", user);
		model.addAttribute("isAuthUser", username.equals(auth.getName()));
		
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
			@PathVariable(value = "username") String username,
			@RequestParam(name = "profile-update-infos", required = false) String updateInfos,
			@RequestParam(name = "profile-update-pass", required = false) String updatePass
	) throws BusinessException {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		AppUser user = userService.findByUserName(auth.getName());
		
		// Si l'utilisateur à modifier est l'utilisateur authentifié
		if (username.equals(auth.getName())) {
			if (updateInfos != null)
				userService.updateUserInfos(user, form.getEmail(), form.getFirstName(), form.getLastName());
			if (updatePass != null)
				userService.updateUserPass(user, form.getPassword(), form.getNewPassword(), form.getPasswordConfirm());
		}
		
		return new ModelAndView("redirect:" + Routes.PROFILE + "/@" + username);
	}

}
