/*
 *@filename EventController.java
 *@author Lila
 *@date 7 Septembre 2016
 */

package fr.imie.appformusic.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.imie.appformusic.configuration.constants.Routes;
import fr.imie.appformusic.configuration.constants.Views;
import fr.imie.appformusic.domain.Event;
import fr.imie.appformusic.exceptions.BusinessException;
import fr.imie.appformusic.form.EventForm;
import fr.imie.appformusic.service.IEventService;

@Controller
public class EventController {
	
	@Autowired
	private IEventService eventService;
	
	private static final Logger log = Logger.getLogger(EventController.class);
	
	/**
	 * Affiche la vue calendar
	 * @param model
	 * @return
	 */
	@RequestMapping(Routes.CALENDAR)
	public ModelAndView showCalendar(Model model) throws BusinessException{
		ModelAndView mav = new ModelAndView(Views.CALENDAR);
		model.addAttribute(new EventForm());
		return mav;
	}
	
	/**
	 * Ajout un evenement en bdd
	 * @param eventForm
	 * @return
	 * @throws BusinessException
	 */
	@RequestMapping(value=Routes.CALENDAR, method=RequestMethod.POST)
	public ModelAndView submitEventForm(EventForm eventForm) throws BusinessException {
				
		// create event
		Event event = new Event();
		String dateStart = eventForm.getStartevent();
		String dateEnd = eventForm.getEndevent();
		event.setStartevent(dateStart);
		event.setEndevent(dateEnd);
		event.setTitleevent(eventForm.getTitleevent());
		
		eventService.create(event);
		return new ModelAndView("redirect:" + Routes.CALENDAR);
	}
}