package fr.imie.appformusic.dao;
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
import fr.imie.appformusic.exceptions.TechnicalException;

public interface IPlaceDao {
	
	public void create(Place place) throws TechnicalException;
	public void delete(Place place) throws TechnicalException;
	public Place findById(int placeId) throws TechnicalException;
	public List<Place> findAllPlaces() throws TechnicalException;
	public List<Place> findPlacesLike(String likePublicName) throws TechnicalException;
	public List<Place> FindUserPlaces(AppUser user) throws TechnicalException;
	public List<Place> findUserPlacesLike(String username, String likePrivateName) throws TechnicalException;
	public void saveImage(Picture picture);
}
