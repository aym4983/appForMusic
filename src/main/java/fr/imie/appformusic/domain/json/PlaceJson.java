package fr.imie.appformusic.domain.json;

import fr.imie.appformusic.domain.Place;

public class PlaceJson {
	
	private int placeId;
	private String publicLabel;
	private String street;
	private String zipcode;
	private String city;
	private double latitude;
	private double longitude;
	private UserJson owner;
	
	public PlaceJson(Place place) {
		placeId = place.getPlaceId();
		publicLabel = place.getPublicLabel();
		street = place.getStreet();
		zipcode = place.getZipcode();
		city = place.getCity();
		latitude = place.getLatitude();
		longitude = place.getLongitude();
		owner = new UserJson(place.getOwner());
	}

	public int getPlaceId() {
		return placeId;
	}

	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}

	public String getPublicLabel() {
		return publicLabel;
	}

	public void setPublicLabel(String publicLabel) {
		this.publicLabel = publicLabel;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public UserJson getOwner() {
		return owner;
	}

	public void setOwner(UserJson owner) {
		this.owner = owner;
	}

}
