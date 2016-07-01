package fr.imie.appformusic.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="ProfessionalPlace")
public class ProfessionalsPlaces {

	/** Attributes **/
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id",nullable=false,unique=true)	
	private int id;
	
	@Column(name="siret",nullable=false,length=255)
	private String siret;
	
	@Column(name="isValidated")
	private boolean isValidated;
	
	@Column(name="googlePlaceId",nullable=false,length=255)
	private String googlePlaceId;
	
	@OneToOne(mappedBy="professionalplace")
	@PrimaryKeyJoinColumn
	private Places place;

	/** Constructeurs **/
	public ProfessionalsPlaces(){
		
	}
	
	/** Getters and Setters **/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSiret() {
		return siret;
	}
	public void setSiret(String siret) {
		this.siret = siret;
	}
	
	public boolean isValidated() {
		return isValidated;
	}
	public void setValidated(boolean isValidated) {
		this.isValidated = isValidated;
	}
	
	public String getGooglePlaceId() {
		return googlePlaceId;
	}
	public void setGooglePlaceId(String googlePlaceId) {
		this.googlePlaceId = googlePlaceId;
	}
	
	public Places getPlace() {
		return place;
	}
	public void setPlace(Places place) {
		this.place = place;
	}
}
