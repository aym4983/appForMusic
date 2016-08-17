package fr.imie.appformusic.responses;

import java.util.List;

import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.domain.Place;

public class GlobalSearchResponse extends Response {

	private List<AppUser> users;
	private List<Place> places;
	
	public List<AppUser> getUsers() {
		return users;
	}
	
	public void setUsers(List<AppUser> users) {
		this.users = users;
	}
	
	public List<Place> getPlaces() {
		return places;
	}
	
	public void setPlaces(List<Place> places) {
		this.places = places;
	}

}
