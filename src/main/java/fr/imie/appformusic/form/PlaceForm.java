/*
 *@filename PlaceForm.java
 *@author Sakhuraah
 *@date 18 août 2016
*/

package fr.imie.appformusic.form;

public class PlaceForm {
	
	private String street;
	private String zipcode;
	private String city;
	private double longitude;
	private double latitude;
	private String publicLabel;
	private String type;
	private String description;
	private String image;

	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPublicLabel() {
		return publicLabel;
	}
	public void setPublicLabel(String publicLabel) {
		this.publicLabel = publicLabel;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
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

}
