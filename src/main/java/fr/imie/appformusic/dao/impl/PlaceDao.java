package fr.imie.appformusic.dao.impl;


import java.io.File;
import java.util.ArrayList;
 
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.imie.appformusic.dao.IPlaceDao;
import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.domain.Picture;
import fr.imie.appformusic.domain.Place;
import fr.imie.appformusic.exceptions.TechnicalException;

@Repository
public class PlaceDao implements IPlaceDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void create(Place place) throws TechnicalException {
		try {
			sessionFactory.getCurrentSession().persist(place);
		} catch (Exception e) {
			throw new TechnicalException(e);
		}
	}

	@Override
	public Place findById(int placeId) throws TechnicalException {
		try {
			return (Place) sessionFactory
					.getCurrentSession().createCriteria(Place.class)
					.add(Restrictions.idEq(placeId));
		} catch (Exception e) {
			throw new TechnicalException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Place> findAllPlaces() throws TechnicalException {
		try {
			return sessionFactory
					.getCurrentSession()
					.createCriteria(Place.class).list();
		} catch (Exception e) {
			throw new TechnicalException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Place> findPlacesLike(String likePublicLabel) throws TechnicalException {
		try {
			return sessionFactory
					.getCurrentSession()
					.createCriteria(Place.class)
					.add(Restrictions.ilike("publicLabel", "%"+likePublicLabel+"%"))
					.list();
		} catch (Exception e) {
			throw new TechnicalException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Place> FindUserPlaces(AppUser user) throws TechnicalException {
		try {
			return sessionFactory
					.getCurrentSession()
					.createCriteria(Place.class)
					.add(Restrictions.eq("owner", user))
					.list();
		} catch (Exception e) {
			throw new TechnicalException(e);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Place> findUserPlacesLike(String username, String likePrivateLabel) throws TechnicalException {
		try {
		return sessionFactory
				.getCurrentSession()
				.createCriteria(Place.class)
				.add(Restrictions.eq("owner", username))
				.add(Restrictions.and(Restrictions.ilike("privateLabel", "%"+likePrivateLabel+"%")))
				.list();
		} catch (Exception e) {
			throw new TechnicalException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void delete(Place place) throws TechnicalException {
		sessionFactory.getCurrentSession().delete(place);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void saveImage(Picture picture){
		try {
			sessionFactory.getCurrentSession().persist(picture);
		} catch (Exception e) {
			throw new TechnicalException(e);
		}
	}
	
	

}
