package fr.imie.appformusic.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fr.imie.appformusic.configuration.constants.Routes;
import fr.imie.appformusic.exceptions.BusinessException;
import fr.imie.appformusic.responses.FailureResponse;
import fr.imie.appformusic.responses.GlobalSearchResponse;
import fr.imie.appformusic.responses.Response;
import fr.imie.appformusic.service.IPlaceService;
import fr.imie.appformusic.service.IUserService;

@Controller
@RequestMapping(value = Routes.SEARCH, method = RequestMethod.GET)
public class SearchController {
	
	private Logger logger = Logger.getLogger(SearchController.class);
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IPlaceService placeService;

	@RequestMapping("")
	public ModelAndView init(){
		return new ModelAndView("search");
	}
	
	@RequestMapping("/all")
	public GlobalSearchResponse searchAll(
			@RequestParam(name="search") String search
	) throws BusinessException {
		GlobalSearchResponse response = new GlobalSearchResponse();
		response.setUsers(userService.findUsersLike(search));
		response.setPlaces(placeService.findPlacesLike(search));
		return response;
	}

	@ResponseBody
	@ExceptionHandler(Throwable.class)
	public Response error(Throwable t) {
		logger.error(t.getMessage(), t);
		return new FailureResponse();
	}

}
