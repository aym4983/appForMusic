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
@Table(name="Boeuf")
public class Boeufs {
	
	/** Attributes **/
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id", nullable=false,unique=true)
	private int id;
	
	@ManyToOne
	private Genres genre;
	
	@ManyToOne
	private Events event;
	
	@ManyToOne
	private Users user;
	
	@Column(name="label",nullable=false,length=255)
	private String label;
	
	@Column(name="maxMusicians",nullable=false)
	private int maxMusicians;
	
	@Column(name="startDate",nullable=false)
	private Date startDate;
	
	@Column(name="endDate",nullable=false)
	private Date endDate;
	
	@OneToMany(mappedBy="boeuf")
	private Set<Participate> listParticipate;
	
	/** Constructeur **/
	public Boeufs(){
		
	}
	
	/** Getters and setters **/
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getMaxMusicians() {
		return maxMusicians;
	}

	public void setMaxMusicians(int maxMusicians) {
		this.maxMusicians = maxMusicians;
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
