package fr.imie.appformusic.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
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
			return sessionFactory
					.getCurrentSession()
					.createQuery("from Place where placeId = :placeId", Place.class)
					.setParameter("placeId", placeId).getSingleResult();
		} catch (Exception e) {
			throw new TechnicalException(e);
		}
	}

	@Override
	public List<Place> findAllPlaces() throws TechnicalException {
		try {
			return sessionFactory
					.getCurrentSession()
					.createQuery("from Place", Place.class)
					.getResultList();
		} catch (Exception e) {
			throw new TechnicalException(e);
		}
	}

	@Override
	public List<Place> findPlacesLike(String likePublicName) throws TechnicalException {
		return sessionFactory
				.getCurrentSession()
				.createQuery("from Place where publicName like :publicName", Place.class)
				.setParameter("publicName", "%" + likePublicName + "%")
				.getResultList();
	}

	@Override
	public List<Place> FindUserPlaces(String username) throws TechnicalException {
		return sessionFactory
				.getCurrentSession()
				.createQuery("from Place where owner = :username", Place.class)
				.setParameter("username", username)
				.getResultList();
	}

	@Override
	public List<Place> findUserPlacesLike(String username, String likePrivateName) throws TechnicalException {
		return sessionFactory
				.getCurrentSession()
				.createQuery("from Place where owner = :username and privateName like :publicName", Place.class)
				.setParameter("username", username)
				.setParameter("publicName", "%" + likePrivateName + "%")
				.getResultList();
	}

}
