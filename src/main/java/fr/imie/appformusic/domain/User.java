package fr.imie.appformusic.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	
	@Id @Column
	private int id;
	@Column(name="Username")
	private String userName;
	@Column(name="Email")
	private String email;
	@Column(name="Password")
	private String password;
	//private String firstName;
	//private String lastName;
	//private boolean professional;
	//private String[] instruments;
	//private List<Place> places;
	//private List<Boeuf> ownedBoeufs;
	//private List<Boeuf> playedBoeufs;
	
	public User(){}
	public User(int id, String username, String email, String password){
		this.id = id;
		this.userName = username;
		this.email = email;
		this.password = password;
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
	/** Obtient le prénom de l'utilisateur.
	 * @return the firstName
	 */
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
