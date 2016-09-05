package fr.imie.appformusic.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity Event
 * @author Lila
 *
 */
@Entity
@Table(name="event")
public class Event implements Serializable{
	
	/** Members **/ 
	private static final long serialVersionUID = -2789957003132330594L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="startevent")
	private Date startevent;
	
	@Column(name="endevent")
	private Date endevent;
	
	@ManyToOne
	private Place place;

	/** Constructors **/ 
	public Event(){}

	public Event(long id, String title, Date startevent, Date endevent) {
		super();
		this.id = id;
		this.title = title;
		this.startevent = startevent;
		this.endevent = endevent;
	}

	/** Members **/ 
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartevent() {
		return startevent;
	}

	public void setStartevent(Date startevent) {
		this.startevent = startevent;
	}

	public Date getEndevent() {
		return endevent;
	}

	public void setEndevent(Date endevent) {
		this.endevent = endevent;
	}
	
	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
	
}