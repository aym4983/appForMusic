package fr.imie.appformusic.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.imie.appformusic.dao.IPlaceDao;
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
			List <Place> places = sessionFactory
					.getCurrentSession()
					.createCriteria(Place.class).list();
			return places;
		} catch (Exception e) {
			throw new TechnicalException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Place> findPlacesLike(String likePublicLabel) throws TechnicalException {
		return sessionFactory
				.getCurrentSession()
				.createCriteria(Place.class)
				.add(Restrictions.like("publicLabel", "%"+likePublicLabel+"%"))
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Place> FindUserPlaces(String username) throws TechnicalException {
		return sessionFactory
				.getCurrentSession()
				.createCriteria(Place.class)
				.add(Restrictions.eq("owner", username))
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Place> findUserPlacesLike(String username, String likePrivateLabel) throws TechnicalException {
		return sessionFactory
				.getCurrentSession()
				.createCriteria(Place.class)
				.add(Restrictions.eq("owner", username))
				.add(Restrictions.and(Restrictions.like("privateLabel", "%"+likePrivateLabel+"%")))
				.list();
	}

}
