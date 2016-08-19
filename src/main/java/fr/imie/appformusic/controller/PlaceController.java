/*
 *@filename PlaceController.java
 *@author Sakhuraah
 *@date 18 août 2016
*/

package fr.imie.appformusic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import fr.imie.appformusic.configuration.constants.Routes;
import fr.imie.appformusic.configuration.constants.Views;
import fr.imie.appformusic.form.PlaceForm;
import fr.imie.appformusic.form.UserForm;
import fr.imie.appformusic.service.IUserService;

@Controller
public class PlaceController {

	@Autowired
	private IUserService userService;
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(Routes.PLACE)
	public ModelAndView showSignUpForm(Model model) {
		ModelAndView mav = new ModelAndView(Views.PLACE);
		mav.addObject("urlPlace", Routes.PLACE);
		model.addAttribute(new PlaceForm());
		return mav; 
	}
}
