package fr.imie.appformusic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.imie.appformusic.configuration.constants.Routes;
import fr.imie.appformusic.configuration.constants.Views;
import fr.imie.appformusic.exceptions.BusinessException;
import fr.imie.appformusic.form.EventForm;

@Controller
public class EventController {
	
	/**
	 * Affiche la vue calendar
	 * @param model
	 * @return
	 */
	@RequestMapping(Routes.CALENDAR)
	public ModelAndView showCalendar(Model model) {
		ModelAndView mav = new ModelAndView(Views.CALENDAR);
		return mav;
	}
	
	@RequestMapping(value=Routes.CALENDAR, method=RequestMethod.POST)
	public ModelAndView submitEventForm(EventForm eventForm, HttpServletRequest request) throws BusinessException {
		return null;
	}
}