package fr.imie.appformusic.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Entity Borrows
 * @author Tiphanie
 *
 */

@Entity
@Table(name="borrows")
public class Borrows implements Serializable{

	/** Members **/ 
	private static final long serialVersionUID = 1077164344082542652L;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="validate")
	private boolean validate;
	
	@Column(name="startdate")
	private Date startdate;
	
	@Column(name="enddate")
	private Date enddate;
	
	@ManyToOne
	private AppUser user;
	
	@ManyToOne
	private Place place;

	/** Constructors **/ 
	public Borrows(){}

	public Borrows(long id, boolean validate, Date startdate, Date enddate) {
		super();
		this.id = id;
		this.validate = validate;
		this.startdate = startdate;
		this.enddate = enddate;
	}

	/** Members **/ 
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isValidate() {
		return validate;
	}

	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public AppUser getUser() {
		return user;
	}

	public void setUser(AppUser user) {
		this.user = user;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
}
