package fr.imie.appformusic.controller;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fr.imie.appformusic.configuration.constants.Routes;
import fr.imie.appformusic.configuration.constants.Views;
import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.domain.Place;
import fr.imie.appformusic.exceptions.BusinessException;
import fr.imie.appformusic.form.ModifyPlaceForm;
import fr.imie.appformusic.form.PlaceForm;
import fr.imie.appformusic.service.IPlaceService;
import fr.imie.appformusic.service.IUserService;
import fr.imie.appformusic.utils.ImageUtils;

@Controller
public class PlaceController {

	@Autowired
	private IPlaceService placeService;
	
	@Autowired
	private IUserService userService;
	
	
	private static final Logger log = Logger.getLogger(PlaceController.class);
	/**
	 * 
	 * @param model
	 * @return
	 * @throws BusinessException 
	 */
	@RequestMapping(Routes.PLACE)
	public ModelAndView showMyPlaces(Model model) throws BusinessException {
		System.out.println("print");
		log.debug("log");
		ModelAndView mav = new ModelAndView(Views.PLACE);
		
		// Get the user 
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		AppUser user = new AppUser();
		user = userService.findByUserName(name);
		
		List<Place> places;
		places = placeService.findUserPlaces(user);
		
		mav.addObject("urlPlace", Routes.PLACE);

		model.addAttribute(new PlaceForm());
		model.addAttribute("places", places);
		boolean ImageExists = ImageUtils.ImageExists(1);
		if(ImageExists){
			mav.addObject("image_path","/img/image");
		}else{
			mav.addObject("image_path","/img/image_default.jpg");
		}
		return mav; 
	}
	

	@RequestMapping(value=Routes.PLACE, method=RequestMethod.POST)
	public ModelAndView submitPlaceForm(PlaceForm placeForm) throws BusinessException, IOException {
		
		// Get the user 
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		AppUser user = new AppUser();
		user.setUsername(name);
		
		// Create the place
		Place place = new Place();
		place.setPrivateLabel(placeForm.getPublicLabel());
		place.setPublicLabel(placeForm.getPublicLabel());
		place.setOwner(user);
		place.setCity(placeForm.getCity());
		place.setLatitude(placeForm.getLatitude());
		place.setLongitude(placeForm.getLongitude());
		place.setStreet(placeForm.getStreet());
		place.setZipcode(placeForm.getZipcode());
		place.setDescription(placeForm.getDescription());
		
		placeService.create(place);
    
		return new ModelAndView("redirect:" + Routes.PLACE);
	}

	
	@RequestMapping(value="/places/{placeId}")
	@ResponseBody
	public ModelAndView showPlace(Model model,@PathVariable("placeId") int placeId, HttpServletResponse response) throws BusinessException {
		ModelAndView mav = new ModelAndView(Views.PLACEINFO);
		
		Place place = new Place();
		if(placeService.findById(placeId)==null){
			try {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// Get the user 
		String name = SecurityContextHolder.getContext().getAuthentication().getName();

	
		place = placeService.findById(placeId);
		model.addAttribute(new ModifyPlaceForm());
		model.addAttribute("place",place);
		model.addAttribute("urlCalendar", "/"+ Views.CALENDAR);
		model.addAttribute("utilCo", name);
		return mav;
		 
	}
	
	@RequestMapping(value="/modifyplace", method=RequestMethod.POST)
	@ResponseBody
	public ModelAndView modifyPlace(ModifyPlaceForm placeForm) throws BusinessException {

		log.debug("modifyplace");
		// Get the user 
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		AppUser user = new AppUser();
		user = userService.findByUserName(name);
		
		// Create the place
		log.debug(placeForm.getPlaceId());
		Place place = new Place();
		place.setPlaceId(placeForm.getPlaceId());
		place.setPrivateLabel(placeForm.getPrivateLabel());
		place.setPublicLabel(placeForm.getPublicLabel());
		place.setOwner(user);
		place.setCity(placeForm.getCity());
		place.setLatitude(placeForm.getLatitude());
		place.setLongitude(placeForm.getLongitude());
		place.setStreet(placeForm.getStreet());
		place.setZipcode(placeForm.getZipcode());
		place.setDescription(placeForm.getDescription());
		
		log.debug(place.getPlaceId());
		placeService.updatePlace(place);
		
		return new ModelAndView("redirect:/places/"+place.getPlaceId());
		 
	}

}
