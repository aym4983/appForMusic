/*
 *@filename EventController.java
 *@author Lila
 *@date 7 Septembre 2016
 */

package fr.imie.appformusic.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fr.imie.appformusic.configuration.constants.Routes;
import fr.imie.appformusic.configuration.constants.Views;
import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.domain.Event;
import fr.imie.appformusic.domain.Place;
import fr.imie.appformusic.domain.json.EventJson;
import fr.imie.appformusic.exceptions.BusinessException;
import fr.imie.appformusic.form.EventForm;
import fr.imie.appformusic.responses.Response;
import fr.imie.appformusic.service.IEventService;
import fr.imie.appformusic.service.IPlaceService;
import fr.imie.appformusic.service.impl.EventService;


@Controller
public class EventController {
	
	@Autowired
	private IEventService eventService;
	
	@Autowired
	private IPlaceService placeService;
	
	private static final Logger log = Logger.getLogger(EventController.class);
	
	/**
	 * Affiche la vue calendar
	 * @param model
	 * @return
	 */
	@RequestMapping(Routes.CALENDAR)
	public ModelAndView showCalendar(Model model) throws BusinessException{
	ModelAndView mav = new ModelAndView(Views.CALENDAR);

	/** récupère la list de tous les events en bdd */
	List<Event> events;
	events = eventService.findAllEvents();

	model.addAttribute(new EventForm());
	model.addAttribute("events", events);
	return mav;
	}
	
	@RequestMapping(value="/calendar/{placeId}")
	public ModelAndView showCalendarplace(Model model,@PathVariable("placeId") int placeId) throws BusinessException{
	ModelAndView mav = new ModelAndView(Views.CALENDAR);

	Place place = new Place();
	place = placeService.findById(placeId);
	
	// Get the user 
	String name = SecurityContextHolder.getContext().getAuthentication().getName();
			
	/** récupère la list de tous les events en bdd */
	List<Event> events;
	events = eventService.FindPlaceEvent(place);
	model.addAttribute("utilCo", name);
	model.addAttribute(new EventForm());
	model.addAttribute("events", events);
	model.addAttribute("place", place);
	
	return mav;
	}
	
	/**
	 * Ajout un evenement en bdd
	 * @param eventForm
	 * @return
	 * @throws BusinessException
	 */
	@RequestMapping(value=Routes.CALENDAR, method=RequestMethod.POST)
	@ResponseBody
	public Response<List<EventJson>> submitEventForm(EventForm eventForm) throws BusinessException {
				
		// create event
		Event event = new Event();
		String dateStart = eventForm.getStartevent();
		String dateEnd = eventForm.getEndevent();
		
		Place place = new Place();
		int placeid = eventForm.getPlaceId();
		place = placeService.findById(placeid);
		
		log.debug(placeid);
		event.setStartevent(dateStart);
		event.setEndevent(dateEnd);
		event.setTitleevent(eventForm.getTitleevent());
		event.setPlace(placeService.findById(eventForm.getPlaceId()));

		
		eventService.create(event);
		List<EventJson> events =new ArrayList<>();

		for(Event ev : eventService.findAllEvents()){
			events.add(new EventJson(ev));
		}
		return new Response<>(events);
	}
	
	@ResponseBody
	@ExceptionHandler(Throwable.class)
	public Response<Boolean> error(Throwable t) {
		log.error(t.getMessage(), t);
		return new Response<>(false);
	}
	
	@RequestMapping(value=Routes.CALENDAR +"/get")
	public @ResponseBody List<Event> getEvent() throws BusinessException {
		return eventService.findAllEvents();
	}
	
		
	@RequestMapping(value="/eventdelete", method=RequestMethod.POST)
	@ResponseBody
	public Response<Boolean> deleteEvent(@RequestParam("eventid") int eventId) throws BusinessException {
		Event event = eventService.findById(eventId);
		eventService.deleteEvent(event);
		
		return new Response<>(true);
	}
}