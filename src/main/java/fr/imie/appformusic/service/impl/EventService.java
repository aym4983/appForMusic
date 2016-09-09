package fr.imie.appformusic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.imie.appformusic.dao.IEventDao;
import fr.imie.appformusic.domain.Event;
import fr.imie.appformusic.domain.Place;
import fr.imie.appformusic.exceptions.BusinessException;
import fr.imie.appformusic.service.IEventService;

@Service
public class EventService implements IEventService {
	
	@Autowired
	private IEventDao eventDao;

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public void create(Event event) throws BusinessException {
		eventDao.create(event);
	}

	@Override
	@Transactional(readOnly = true)
	public Event findById(int eventid) throws BusinessException {
		return eventDao.findById(eventid);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Event> findAllEvents() throws BusinessException {
		return eventDao.findAllEvents();
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Event> FindPlaceEvent(Place place) throws BusinessException{
		return eventDao.FindPlaceEvent(place);
	}
	
	@Override
	@Transactional(rollbackFor = Throwable.class)
	public void deleteEvent(Event event) throws BusinessException {
		eventDao.deleteEvent(event);
	}
	
}