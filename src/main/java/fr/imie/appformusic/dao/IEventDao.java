package fr.imie.appformusic.dao;

import java.util.List;

import fr.imie.appformusic.domain.Event;
import fr.imie.appformusic.domain.Place;
import fr.imie.appformusic.exceptions.TechnicalException;

public interface IEventDao {

	public void create(Event event) throws TechnicalException;
	public Event findById(int eventid) throws TechnicalException;
	public List<Event> findAllEvents() throws TechnicalException;
	public void delete(Event event) throws TechnicalException;
	
}
