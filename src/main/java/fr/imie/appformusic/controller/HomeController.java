package fr.imie.appformusic.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.imie.appformusic.configuration.constants.Routes;
import fr.imie.appformusic.configuration.constants.Views;
import fr.imie.appformusic.domain.Place;
import fr.imie.appformusic.domain.json.PlaceJson;
import fr.imie.appformusic.exceptions.BusinessException;
import fr.imie.appformusic.service.IPlaceService;

@Controller
@RequestMapping(Routes.HOME)
public class HomeController {
	
	@Autowired
	private IPlaceService placeService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView init(Model model) throws BusinessException {
		List<PlaceJson> places = new ArrayList<>();
		for (Place place : placeService.findAllPlaces()) {
			places.add(new PlaceJson(place));
		}
		model.addAttribute("places", places);
		return new ModelAndView(Views.HOME);
	}
	
}
