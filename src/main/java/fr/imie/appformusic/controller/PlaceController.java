/*
 *@filename PlaceController.java
 *@author Sakhuraah
 *@date 18 août 2016
*/

package fr.imie.appformusic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
import fr.imie.appformusic.service.IPlaceService;
import fr.imie.appformusic.service.IUserService;

@Controller
public class PlaceController {

	@Autowired
	private IPlaceService placeService;
	
	@Autowired
	private IUserService userService;
	
	
	/**
	 * 
	 * @param model
	 * @return
	 * @throws BusinessException 
	 */
	@RequestMapping(Routes.PLACE)
	public ModelAndView showMyPlaces(Model model) throws BusinessException {
		
		ModelAndView mav = new ModelAndView(Views.PLACE);
		
		// Get the user 
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		AppUser user = new AppUser();
		user = userService.findByUserName(name);
		
		List<Place> places;
		places = placeService.findUserPlaces(user);
		
		mav.addObject("urlPlace", Routes.PLACE);
		//mav.addObject("places", Routes.PLACE);
		model.addAttribute(new PlaceForm());
		model.addAttribute("places", places);
		//System.out.println("print");
		return mav; 
	}
	
	@RequestMapping(value=Routes.PLACE, method=RequestMethod.POST)
	public ModelAndView submitPlaceForm(PlaceForm placeForm) throws BusinessException {
		
		// Get the user 
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		AppUser user = new AppUser();
		user.setUsername(name);
		
		// Create the place
		Place place = new Place();
		if(placeForm.getType().contains("private")){
			place.setPrivateLabel(placeForm.getPublicLabel());
		}else{
			place.setPublicLabel(placeForm.getPublicLabel());
		}
		
		place.setOwner(user);
		place.setCity(placeForm.getCity());
		place.setLatitude(placeForm.getLatitude());
		place.setLongitude(placeForm.getLongitude());
		place.setStreet(placeForm.getStreet());
		place.setZipcode(placeForm.getZipcode());
		
		placeService.create(place);
		return new ModelAndView("redirect:" + Routes.PLACE);
	}
}
