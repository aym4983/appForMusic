package fr.imie.appformusic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.imie.appformusic.configuration.constants.Routes;
import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.domain.Place;
import fr.imie.appformusic.domain.ResponseBody;
import fr.imie.appformusic.exceptions.BusinessException;
import fr.imie.appformusic.service.IPlaceService;
import fr.imie.appformusic.service.IUserService;

public class SearchController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IPlaceService placeService;

	@RequestMapping(Routes.SIGNUP)
	public ResponseBody search(
			@RequestParam(name="search") String search
	) throws BusinessException {
		List<AppUser> users = userService.findUsersLike(search);
		List<Place> places = placeService.findPlacesLike(search);
		return new ResponseBody();
	}

}
