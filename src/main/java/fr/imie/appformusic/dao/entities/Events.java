package fr.imie.appformusic.dao.entities;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	private Genre genre;
	
	@Column(name="startDate",nullable=false)
	private Date startDate;
	
	@Column(name="endDate",nullable=false)
	private Date endDate;
	
	@OneToMany(mappedBy="event")
	private Set<Boeuf> ListBoeuf;
	
	@OneToMany(mappedBy="event")
	private Set<Created> listCreated;
	
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

	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
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
	
	public void addBoeuf(Boeuf b){
		ListBoeuf.add(b);
	}
	public Set<Boeuf> getListBoeuf(){
		return ListBoeuf;
	}
}
