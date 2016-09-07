package fr.imie.appformusic.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.imie.appformusic.configuration.constants.Routes;
import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.domain.Place;
import fr.imie.appformusic.domain.json.PlaceJson;
import fr.imie.appformusic.domain.json.UserJson;
import fr.imie.appformusic.exceptions.BusinessException;
import fr.imie.appformusic.responses.GlobalSearchResponse;
import fr.imie.appformusic.responses.Response;
import fr.imie.appformusic.service.IPlaceService;
import fr.imie.appformusic.service.IUserService;

@Controller
@RequestMapping(value = Routes.API + Routes.SEARCH, method = RequestMethod.GET)
public class SearchController {
	
	private Logger logger = Logger.getLogger(SearchController.class);
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IPlaceService placeService;

	@ResponseBody
	@RequestMapping("/all")
	public Response<GlobalSearchResponse> searchAll(
			@RequestParam(name="search") String search
	) throws BusinessException {
		GlobalSearchResponse response = new GlobalSearchResponse();
		
		List<UserJson> users = new ArrayList<UserJson>();
		for (AppUser user : userService.findUsersLike(search)) {
			users.add(new UserJson(user));
		}
		
		List<PlaceJson> places = new ArrayList<PlaceJson>();
		for (Place place : placeService.findPlacesLike(search)) {
			places.add(new PlaceJson(place));
		}
		
		response.setUsers(users);
		response.setPlaces(places);
		
		return new Response<>(response);
	}

	@ResponseBody
	@ExceptionHandler(Throwable.class)
	public Response<Boolean> error(Throwable t) {
		logger.error(t.getMessage(), t);
		return new Response<>(false);
	}

}
