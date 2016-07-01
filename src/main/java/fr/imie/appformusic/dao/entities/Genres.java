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
public class Genres {

	/** Attributes **/
	@Id
	@Column(name="id", unique=true, nullable=false)
	private String id;
	
	@OneToMany(mappedBy="genre")
	private Set<Boeufs> listBoeuf;
	
	@OneToMany(mappedBy="genre")
	private Set<Events> listEvents;
	
	/** Constructeur **/
	public Genres(){
		
	}

	/** Getters and setters **/
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
