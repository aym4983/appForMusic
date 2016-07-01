package fr.imie.appformusic.dao.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Place")
public class Places {
		
	/** Attributes **/
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id",nullable=false,unique=true)		
	private int id;
	
	@ManyToOne
	private Users users;
	
	@Column(name="label",nullable=false,length=255)
	private String label;
	
	@Column(name="address",nullable=false,length=255)
	private String address;
	
	@Column(name="cp",nullable=false,length=5)
	private String cp;
	
	@Column(name="city",nullable=false,length=255)
	private String city;
	
	@Column(name="capacity",nullable=false)
	private int capacity;
	
	@Column(name="latitude",nullable=false)
	private double latitude;
	
	@Column(name="longtitude",nullable=false)
	private double longtitude;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private ProfessionalsPlaces professionalplace;
	
	@OneToMany(mappedBy="place")
	private Set<Organize> listOrganize;
	
	/** Constructeurs **/
	public Places(){
		
	}
	
	/** Getters and Setters **/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Users getUser() {
		return users;
	}
	public void setUser(Users user) {
		this.users = user;
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLongtitude() {
		return longtitude;
	}
	public void setLongtitude(double longtitude) {
		this.longtitude = longtitude;
	}

	public ProfessionalsPlaces getProfessionalplace() {
		return professionalplace;
	}
	public void setProfessionalplace(ProfessionalsPlaces professionalplace) {
		this.professionalplace = professionalplace;
	}
}
