package fr.imie.appformusic.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity Gear
 * @author Tiphanie
 */

@Entity
public class Gear implements Serializable{

	/** Members **/
	private static final long serialVersionUID = -1819250623420683484L;
	
	@Id @Column(name="gearId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int gearId;
	
	@Column(name="type", length = 50, nullable = true)
	 private String type;
	 
	 @Column(name="brand", length = 50, nullable = false)
	 private String brand;
	 
	 @Column(name="details", length = 255, nullable = true)
	 private String details;
	 
	/** Constructors **/
	 public Gear(){}
	 
	 public Gear(int gearId, String type, String brand, String details){
		 super();
		 this.gearId = gearId;
		 this.type = type;
		 this.brand = brand;
		 this.details = details;
	 }
	 
	 /** Getters and Setters **/ 
	 public int getGearId() {
		return gearId;
	}

	public void setGearId(int gearId) {
		this.gearId = gearId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	 
	 
}
