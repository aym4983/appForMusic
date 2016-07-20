package fr.imie.appformusic.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Place")
public class Place implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @Column
	private int idPlace;
	@Column(name="PlaceName")
	private String placeName;
	@Column(name="Description")
	private String description;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="IdUser")
	private User user;

	public Place(){};
	
	public Place(int idPlace, String placeName, String description) {
		super();
		this.idPlace = idPlace;
		this.placeName = placeName;
		this.description = description;
	}



	public int getIdPlace() {
		return idPlace;
	}

	public void setIdPlace(int idPlace) {
		this.idPlace = idPlace;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
