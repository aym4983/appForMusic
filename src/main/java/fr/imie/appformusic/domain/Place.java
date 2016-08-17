package fr.imie.appformusic.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity Place
 * @author Tiphanie
 *
 */

@Entity
@Table(name="place")
public class Place implements Serializable {

	/** Members **/ 
	private static final long serialVersionUID = 6450129037706488936L;
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO) @Column(name="placeid")
	private int placeId;
	
	@Column(name="privatelabel", length = 50, nullable = false)
	private String privateLabel;
	
	@Column(name="publiclabel", length = 50, nullable = false)
	private String publicLabel;
	
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
	
	@ManyToOne
	@JoinColumn(name="owner", nullable = false)
	private AppUser owner;
	
	@OneToMany(mappedBy="place")
	private Set<Borrows> borrows;
	
	@OneToMany(mappedBy="place")
	private Set<Favourites> favourites;
	
	@OneToMany(mappedBy="place")
	private Set<Proposes> proposes;


	/** Constructors **/
	public Place(){};
	
	public Place(int placeId, String label, String city, String street, String zipcode, double latitude, double longitude) {
		super();
		this.placeId = placeId;
		this.privateLabel = label;
		this.street = street;
		this.city = city;
		this.zipcode = zipcode;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getPlaceId() {
		return placeId;
	}

	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}

	public String getPrivateLabel() {
		return privateLabel;
	}

	public void setPrivateLabel(String privateLabel) {
		this.privateLabel = privateLabel;
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

	public AppUser getOwner() {
		return owner;
	}

	public void setOwner(AppUser user) {
		this.owner = user;
	}

}
