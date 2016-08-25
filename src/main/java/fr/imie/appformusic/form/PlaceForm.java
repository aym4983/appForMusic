/*
 *@filename PlaceForm.java
 *@author Sakhuraah
 *@date 18 août 2016
*/

package fr.imie.appformusic.form;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class PlaceForm {
	
	private String publicLabel;
	private String street;
	private String zipcode;
	private String city;
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	private String longitude;
	private String latitude;
	
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

}
