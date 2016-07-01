package fr.imie.appformusic.dao.entities;

import javax.persistence.Entity;
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
	private Instruments instrument;
	private Users user;
	private Boeuf boeuf;
	
	/** Constructeur **/
	public Organize(){
		
	}
	
	/** Getters and Setters **/
	public Instruments getInstrument() {
		return instrument;
	}
	public void setInstrument(Instruments instrument) {
		this.instrument = instrument;
	}
	
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	
	public Boeuf getBoeuf() {
		return boeuf;
	}
	public void setBoeuf(Boeuf boeuf) {
		this.boeuf = boeuf;
	}
}
