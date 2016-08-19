package fr.imie.appformusic.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity Proposes
 * @author Tiphanie
 */

@Entity
@Table(name="proposes")
public class Proposes implements Serializable {

	private static final long serialVersionUID = 3896531394854038424L;
	
	/** Members **/
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private Gear gear;
	
	@ManyToOne
	private Place place;
	
	/** Constructors **/ 
	public Proposes(){}

	public Proposes(long id, Gear gear, Place place) {
		super();
		this.id = id;
		this.gear = gear;
		this.place = place;
	}

	/** Getters and Setters **/
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Gear getGear() {
		return gear;
	}

	public void setGear(Gear gear) {
		this.gear = gear;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
	
}
