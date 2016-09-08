package fr.imie.appformusic.service;
<<<<<<< HEAD

=======

<<<<<<< Upstream, based on origin/master
>>>>>>> refs/remotes/origin/master_lila
import java.io.File;
<<<<<<< HEAD
import java.util.ArrayList;
=======
import java.util.ArrayList;
=======
>>>>>>> 948f88c ajout des evenements en bdd
>>>>>>> refs/remotes/origin/master_lila
import java.util.List;

import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.domain.Picture;
import fr.imie.appformusic.domain.Place;
import fr.imie.appformusic.exceptions.BusinessException;

public interface IPlaceService {

	public void create(Place place) throws BusinessException;
	public Place findById(int placeId) throws BusinessException;
	public List<Place> findAllPlaces() throws BusinessException;
	public List<Place> findPlacesLike(String likePublicName) throws BusinessException;
	public List<Place> findUserPlaces(AppUser user) throws BusinessException;
	public List<Place> findUserPlacesLike(AppUser user, String likePrivateName) throws BusinessException;
	public void deletePlace(Place place) throws BusinessException;
	public void saveImage(Picture picture)throws BusinessException;
}
