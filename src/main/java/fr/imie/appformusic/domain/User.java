package fr.imie.appformusic.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Classe représentant un utilisateur.
 * @author Dorian
 *
 */
@Entity
@Table(name="Users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5219643569000183378L;
	
	@Id @Column(name="IdUser")
	private int id;
	@Column(name="Username")
	private String userName;
	@Column(name="Email")
	private String email;
	@Column(name="Password")
	private String password;
	@Column(name="Rank")
	private int rank;
	@Column(name="Firstname")
	private String firstName;
	@Column(name="Lastname")
	private String lastName;
	@OneToOne(mappedBy="user", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.LAZY)
	private Place place;
	
	public User(){}
	
	public User(int id, String userName, String email, String password, int rank, String firstName, String lastName) {
		super();
		this.id = id;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.rank = rank;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/** Obtient l'identifiant de l'utilisateur.
	 * @return L'identifiant de l'utilisateur.
	 */
	public String getUserName() {
		return userName;
	}
	/** Définit l'identifiant de l'utilisateur.
	 * @param L'identifiant à définir.
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/** Obtient l'adresse e-mail de l'utilisateur.
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/** Définit l'adresse e-mail de l'utilisateur.
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/** Obtient le mot de passe de l'utilisateur.
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/** Définit le mot de passe de l'utilisateur.
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}
	
}
