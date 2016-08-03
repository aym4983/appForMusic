package fr.imie.appformusic.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity Owns
 * @author Tiphanie
 *
 */

@Entity
public class Owns implements Serializable{

	/** Members **/ 
	private static final long serialVersionUID = -3178690710367907449L;
	
	/** Members **/
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private AppUser user;
	
	@ManyToOne
	private Place place;
	
	/** Constructors **/ 
	public Owns(){}

	public Owns(long id, AppUser user, Place place) {
		super();
		this.id = id;
		this.user = user;
		this.place = place;
	}

	/** Members **/
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
