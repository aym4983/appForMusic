package fr.imie.appformusic.service;

import java.util.List;

import fr.imie.appformusic.domain.Event;
import fr.imie.appformusic.domain.Place;
import fr.imie.appformusic.exceptions.BusinessException;

public interface IEventService {

	public void create(Event event) throws BusinessException;
	public Event findById(int eventid) throws BusinessException;
	public List<Event> findAllEvents() throws BusinessException;
	public void deleteEvent(Event event) throws BusinessException;
}
