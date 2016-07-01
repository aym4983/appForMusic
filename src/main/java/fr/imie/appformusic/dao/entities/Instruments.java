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
@Table(name="Instruments")
public class Instruments {

	/** Attributes **/
	@Id 
	@Column(name="id",nullable=false,unique=true)
	private String id;
	
	@OneToMany(mappedBy="instrument")
	private Set<PlayedInstruments> listPlayedInstruments;

	@OneToMany(mappedBy="instrument")
	private Set<Participate> listParticipate;
	
	/** Constructeurs **/
	public Instruments(){
		
	}
	
	/** Getters and Setters **/
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}
