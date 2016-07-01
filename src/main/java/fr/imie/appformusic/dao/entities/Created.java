package fr.imie.appformusic.dao.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * 
 * @author Tiphanie Aubry
 *
 */
@Entity
@Table(name="Created")
public class Created {

	/** Attributes **/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	private Events event;

	@ManyToOne
	private Place place;                                                 

	@ManyToOne
	private Users user;
	
	/** Constructeur **/
	public Created()
	{
		
	}

	/** Getters and Setters **/
	public Events getEvent() {
		return event;
	}
	public void setEvent(Events event) {
		this.event = event;
	}

	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}

	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
}
