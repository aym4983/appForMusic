package fr.imie.appformusic.dao.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * 
 * @author Tiphanie Aubry
 *
 */
@Entity
@Table(name="Genre")
public class Genre {

	/** Attributes **/
	@Id
	@Column(name="id", unique=true, nullable=false)
	private String id;
	
	@OneToMany(mappedBy="genre")
	private Set<Boeuf> ListBoeuf;
	
	@OneToMany(mappedBy="genre")
	private Set<Events> ListEvents;
	
	/** Constructeur **/
	public Genre(){
		
	}

	/** Getters and setters **/
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Set<Boeuf> getListBoeuf() {
		return ListBoeuf;
	}
	public void setListBoeuf(Set<Boeuf> listBoeuf) {
		ListBoeuf = listBoeuf;
	}

	public Set<Events> getListEvents() {
		return ListEvents;
	}
	public void setListEvents(Set<Events> listEvents) {
		ListEvents = listEvents;
	}
	
}
