package fr.imie.appformusic.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.imie.appformusic.configuration.constants.Routes;

import fr.imie.appformusic.domain.AppUser;

import fr.imie.appformusic.domain.Place;
import fr.imie.appformusic.domain.json.PlaceJson;
import fr.imie.appformusic.exceptions.BusinessException;
import fr.imie.appformusic.responses.Response;
import fr.imie.appformusic.service.IPlaceService;
import fr.imie.appformusic.service.IUserService;

@RestController
@RequestMapping(value = Routes.API + Routes.PLACE, method = RequestMethod.GET)
public class PlacesController {
	
	private Logger logger = Logger.getLogger(SearchController.class);
	
	@Autowired
	private IPlaceService placeService;
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/near")
	public Response<List<PlaceJson>> getPlacesNear(
			@RequestParam(name = "lat") double lat,
			@RequestParam(name = "lng") double lng
	) throws BusinessException {
		List<PlaceJson> places = new ArrayList<PlaceJson>();
		for (Place place : placeService.findAllPlaces()) {
			places.add(new PlaceJson(place));
		}
		return new Response<>(places);
	}
	
	@RequestMapping(value="/placedelete", method=RequestMethod.POST)
	@ResponseBody
	public Response<Boolean> deletePlace(@RequestParam("id") int placeId) throws BusinessException {
		
		logger.debug("placeId");
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		AppUser user = new AppUser();
		user = userService.findByUserName(name);
		
		Place place = placeService.findById(placeId);
		placeService.deletePlace(place);
		
		return new Response<>(true);
	}

	@ResponseBody
	@ExceptionHandler(Throwable.class)
	public Response<Boolean> error(Throwable t) {
		logger.error(t.getMessage(), t);
		return new Response<>(false);
	}

}
