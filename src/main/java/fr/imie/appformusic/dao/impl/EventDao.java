package fr.imie.appformusic.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.imie.appformusic.dao.IEventDao;
import fr.imie.appformusic.domain.Event;
import fr.imie.appformusic.domain.Place;
import fr.imie.appformusic.exceptions.TechnicalException;

@Repository
public class EventDao implements IEventDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(Event event) throws TechnicalException {
		try {
			sessionFactory.getCurrentSession().persist(event);
		} catch (Exception e) {
			throw new TechnicalException(e);
		}
	}

	@Override
	public Event findById(int eventid) throws TechnicalException {
		try {
			return (Event) sessionFactory
					.getCurrentSession().createCriteria(Event.class)
					.add(Restrictions.idEq(eventid));
		} catch (Exception e) {
			throw new TechnicalException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Event> findAllEvents() throws TechnicalException {
		try {
			List <Event> events = sessionFactory
					.getCurrentSession()
					.createCriteria(Event.class).list();
			return events;
		} catch (Exception e) {
			throw new TechnicalException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void delete(Event event) throws TechnicalException {
		try{ 
		Event eventToDelete = findById(event.getid());
		sessionFactory.getCurrentSession().delete(eventToDelete);
		}catch(Exception e){
			throw new TechnicalException(e);
		}
	}
	
}