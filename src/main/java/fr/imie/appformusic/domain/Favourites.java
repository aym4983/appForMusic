package fr.imie.appformusic.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity Favourites
 * @author Tiphanie
 */

@Entity
@Table(name="favourites")
public class Favourites implements Serializable {

	/** Members **/
	private static final long serialVersionUID = -8371951894398688411L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private AppUser user;
	
	@ManyToOne
	private Place place;
	
	/** Constructors **/ 
	public Favourites(){}

	public Favourites(long id, AppUser user, Place place) {
		super();
		this.id = id;
		this.user = user;
		this.place = place;
	}

	/** Getters and Setters **/
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public AppUser getUser() {
		return user;
	}

	public void setUser(AppUser user) {
		this.user = user;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
}
