package fr.imie.appformusic.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
