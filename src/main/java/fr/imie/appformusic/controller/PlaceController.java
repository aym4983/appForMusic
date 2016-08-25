/*
 *@filename PlaceController.java
 *@author Sakhuraah
 *@date 18 août 2016
*/

package fr.imie.appformusic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.imie.appformusic.configuration.constants.Routes;
import fr.imie.appformusic.configuration.constants.Views;
import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.domain.Place;
import fr.imie.appformusic.exceptions.BusinessException;
import fr.imie.appformusic.form.PlaceForm;
import fr.imie.appformusic.form.UserForm;
import fr.imie.appformusic.service.IPlaceService;
import fr.imie.appformusic.service.IUserService;

@Controller
public class PlaceController {

	@Autowired
	private IPlaceService placeService;
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(Routes.PLACE)
	public ModelAndView showMyPlaces(Model model) {
		ModelAndView mav = new ModelAndView(Views.PLACE);
		mav.addObject("urlPlace", Routes.PLACE);
		model.addAttribute(new PlaceForm());
		return mav; 
	}
	
	@RequestMapping(value=Routes.PLACE, method=RequestMethod.POST)
	public ModelAndView submitPlaceForm(PlaceForm placeForm, HttpServletRequest request) throws BusinessException {
		
		// Get the user 
		//Integer id = (Integer)request.getSession().getAttribute(Constant.CURRENT_USER);
		
		// Create the place
		Place place = new Place();
		place.setCity(placeForm.getCity());
		//place.setLatitude(placeForm.getLatitude());
		//place.setLongitude(placeForm.getLongitude());
		//place.setOwner(user);
		//place.setPrivateLabel(placeForm.getPrivateLabel());
		place.setPublicLabel(placeForm.getPublicLabel());
		place.setStreet(placeForm.getStreet());
		place.setZipcode(placeForm.getZipcode());
		
		placeService.create(place);
		return new ModelAndView("redirect:/" + Routes.PLACE);
	}
}
