package fr.imie.appformusic.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.imie.appformusic.dao.IPlaceDao;
import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.domain.Picture;
import fr.imie.appformusic.domain.Place;
import fr.imie.appformusic.exceptions.BusinessException;
import fr.imie.appformusic.service.IPlaceService;

@Service
public class PlaceService implements IPlaceService {
	
	@Autowired
	private IPlaceDao placeDao;

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public void create(Place place) throws BusinessException {
		placeDao.create(place);
	}

	@Override
	@Transactional(readOnly = true)
	public Place findById(int placeId) throws BusinessException {
		return placeDao.findById(placeId);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Place> findAllPlaces() throws BusinessException {
		return placeDao.findAllPlaces();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Place> findPlacesLike(String likePublicName) throws BusinessException {
		return placeDao.findPlacesLike(likePublicName);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Place> findUserPlaces(AppUser user) throws BusinessException {
		return placeDao.FindUserPlaces(user);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Place> findUserPlacesLike(AppUser user, String likePrivateName) throws BusinessException {
		return placeDao.findUserPlacesLike(user.getUsername(), likePrivateName);
	}
	
	@Override
	@Transactional(rollbackFor = Throwable.class)
	public void deletePlace(Place place) throws BusinessException {
		placeDao.delete(place);
	}
	
	@Override
	@Transactional(rollbackFor = Throwable.class)
	public void saveImage(Picture picture)throws BusinessException{
		placeDao.saveImage(picture);
	}
	

}
