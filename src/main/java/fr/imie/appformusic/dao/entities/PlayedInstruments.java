package fr.imie.appformusic.dao.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="PlayedInstruments")
public class PlayedInstruments {

	/** Attributes **/ 
	private Users user;
	private Instruments instrument;
	
	/** Constructeurs **/
	public PlayedInstruments()
	{
		
	}
	
	/** Getters and Setters **/
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	
	public Instruments getInstrument() {
		return instrument;
	}
	public void setInstrument(Instruments instrument) {
		this.instrument = instrument;
	}
}
