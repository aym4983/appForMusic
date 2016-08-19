package fr.imie.appformusic.responses;

import java.util.List;

import fr.imie.appformusic.domain.json.PlaceJson;
import fr.imie.appformusic.domain.json.UserJson;

public class GlobalSearchResponse extends Response {

	private List<UserJson> users;
	private List<PlaceJson> places;
	
	public List<UserJson> getUsers() {
		return users;
	}
	
	public void setUsers(List<UserJson> users) {
		this.users = users;
	}
	
	public List<PlaceJson> getPlaces() {
		return places;
	}
	
	public void setPlaces(List<PlaceJson> places) {
		this.places = places;
	}

}
