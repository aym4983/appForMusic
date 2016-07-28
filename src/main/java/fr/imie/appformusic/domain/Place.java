package fr.imie.appformusic.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Place")
public class Place implements Serializable {

	/**
	 *  Entity Place
	 */
	private static final long serialVersionUID = 1L;
	
	/** Members **/ 
	@Id @Column
	private int placeId;
	
	@Column(name="label", length = 50, nullable = false)
	private String label;
	
	@Column(name="street", length = 255, nullable = false)
	private String street;
	
	@Column(name="zipcode", length = 5, nullable = false)
	private String zipcode;
	
	@Column(name="city", length = 50, nullable = false)
	private String city;
	
	@Column(name="latitude", nullable = false)
	private double latitude;
	
	@Column(name="longitude", nullable = false)
	private double longitude;
	
	@OneToOne(mappedBy="place")
	@JoinColumn(name="UserId")
	private AppUser user;


	/** Constructors **/
	public Place(){};
	
	public Place(int placeId, String label, String city, String street, String zipcode, double latitude, double longitude) {
		super();
		this.placeId = placeId;
		this.label = label;
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	/** Getters and setters **/
	public int getPlaceId() {
		return placeId;
	}

	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
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

	public AppUser getUser() {
		return user;
	}

	public void setUser(AppUser user) {
		this.user = user;
	}

}
