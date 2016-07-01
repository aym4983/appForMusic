package fr.imie.appformusic.dao.entities;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * 
 * @author Tiphanie Aubry
 *
 */
@Entity
@Table(name="Events")
public class Events {
	
	/** Attributes **/
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id",nullable=false,unique=true)
	private int id;
	
	@ManyToOne
	private Genres genre;
	
	@Column(name="startDate",nullable=false)
	private Date startDate;
	
	@Column(name="endDate",nullable=false)
	private Date endDate;
	
	@OneToMany(mappedBy="event")
	private Set<Boeufs> listBoeuf;
	
	@OneToMany(mappedBy="event")
	private Set<Organize> listOrganize;
	
	/** Constructeur **/
	public Events(){
		
	}
	
	/** Getters and Setters **/ 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public Genres getGenre() {
		return genre;
	}
	public void setGenre(Genres genre) {
		this.genre = genre;
	}

	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
