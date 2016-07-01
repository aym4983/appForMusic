package fr.imie.appformusic.dao.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * 
 * @author Tiphanie Aubry
 *
 */
@Entity
@Table(name="Organize")
public class Organize {

	/** Attributes **/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	private Events event;

	@ManyToOne
	private Places place;                                                 

	@ManyToOne
	private Users users;
	
	/** Constructeur **/
	public Organize()
	{
		
	}

	/** Getters and Setters **/
	public Events getEvent() {
		return event;
	}
	public void setEvent(Events event) {
		this.event = event;
	}

	public Places getPlace() {
		return place;
	}
	public void setPlace(Places place) {
		this.place = place;
	}

	public Users getUser() {
		return users;
	}
	public void setUser(Users user) {
		this.users = user;
	}
}
