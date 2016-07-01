package fr.imie.appformusic.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PlayedInstruments")
public class PlayedInstruments {

	/** Attributes **/ 
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id",nullable=false,unique=true)
	private int id;
	
	@ManyToOne
	private Users users;
	
	@ManyToOne
	private Instruments instrument;
	
	/** Constructeurs **/
	public PlayedInstruments()
	{
		
	}

	/** Getters and Setters **/
	public Users getUser() {
		return users;
	}
	public void setUser(Users user) {
		this.users = user;
	}
	
	public Instruments getInstrument() {
		return instrument;
	}
	public void setInstrument(Instruments instrument) {
		this.instrument = instrument;
	}
}
