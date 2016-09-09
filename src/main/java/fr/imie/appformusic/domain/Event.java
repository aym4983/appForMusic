package fr.imie.appformusic.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.joda.time.DateTime;

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

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="eventid")
	private int eventid;
	
	@Column(name="startevent", length = 255, nullable = false)
	private String startevent;
	
	@Column(name="endevent", length = 255, nullable = false)
	private String endevent;
	
	@Column(name="titleevent", length = 255, nullable = false)
	private String titleevent;
	
	@ManyToOne
	@JoinColumn(name="place", nullable = false)
	private Place place;

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	/** Constructors **/ 
	public Event(){}

	public Event(int eventid, String startevent, String endevent, String titleevent) {
		super();
		this.eventid = eventid;
		this.startevent = startevent;
		this.endevent = endevent;
		this.titleevent = titleevent;
	}

	/** Members **/ 
	public int getid() {
		return eventid;
	}

	public void setid(int eventid) {
		this.eventid = eventid;
	}

	public String getStartevent() {
		return startevent;
	}

	public void setStartevent(String startevent) {
		this.startevent = startevent;
	}

	public String getEndevent() {
		return endevent;
	}

	public void setEndevent(String endevent) {
		this.endevent = endevent;
	}
	
	public String getTitleevent() {
		return titleevent;
	}

	public void setTitleevent(String titleevent) {
		this.titleevent = titleevent;
	}

//	public Place getPlace() {
//		return place;
//	}
//
//	public void setPlace(Place place) {
//		this.place = place;
//	}
	
}