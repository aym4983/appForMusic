package fr.imie.appformusic.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Participate")
public class Participate {

	/** Attributes **/
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id",nullable=false,unique=true)	
	private int id;
	
	@ManyToOne
	private Instruments instrument;
	
	@ManyToOne
	private Users users;
	
	@ManyToOne
	private Boeufs boeuf;
	
	/** Constructeur **/
	public Participate(){
		
	}
	
	/** Getters and setters **/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Instruments getInstrument() {
		return instrument;
	}
	public void setInstrument(Instruments instrument) {
		this.instrument = instrument;
	}

	public Users getUser() {
		return users;
	}
	public void setUser(Users user) {
		this.users = user;
	}

	public Boeufs getBoeuf() {
		return boeuf;
	}
	public void setBoeuf(Boeufs boeuf) {
		this.boeuf = boeuf;
	}
}
