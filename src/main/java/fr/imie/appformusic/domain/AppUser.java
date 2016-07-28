package fr.imie.appformusic.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Classe représentant un utilisateur.
 * @author Dorian
 *
 */
@Entity
public class AppUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5219643569000183378L;
	
	@Id
	private String userName;
	private String email;
	private String password;
	private String salt;
	private String firstName;
	private String lastName;
	@OneToMany
	private Set<Place> places;
	@OneToMany
	private Set<UserRole> roles;
	private boolean enabled;
	
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
	 * @return L'adresse e-mail de l'utilisateur.
	 */
	public String getEmail() {
		return email;
	}
	
	/** Définit l'adresse e-mail de l'utilisateur.
	 * @param email L'adresse e-mail à définnir.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/** Obtient le mot de passe de l'utilisateur.
	 * @return Le mot de passe de l'utilisateur.
	 */
	public String getPassword() {
		return password;
	}
	
	/** Définit le mot de passe de l'utilisateur.
	 * @param password Le mot de passe à définir.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/** Obtient le sal du mot de passe de l'utilisateur.
	 * @return Le sel du mot de passe de l'utilisateur.
	 */
	public String getSalt() {
		return salt;
	}

	/** Définit le sel du mot de passe de l'utilisateur.
	 * @param salt Le sel à définir.
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}

	/** Obtient le prénom de l'utilisateur.
	 * @return Le prénom de l'utilisateur.
	 */
	public String getFirstName() {
		return firstName;
	}

	/** Définit le prénom de l'utilisateur.
	 * @param firstName Le prénom à définir
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/** Obtient le nom de famille de l'utilisateur.
	 * @return Le nom de famille de l'utilisateur.
	 */
	public String getLastName() {
		return lastName;
	}
	
	/** Définit le nom de famille de l'utilisateur.
	 * @param lastName Le nom de famille à définir.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/** Obtient la liste des lieux possédés par l'utilisateur.
	 * @return La liste des lieux possédés par l'utilisateur.
	 */
	public Set<Place> getPlaces() {
		return places;
	}

	/** Définit la liste des lieux possédés par l'utilisateur.
	 * @param places La liste des lieux à définir.
	 */
	public void setPlaces(Set<Place> places) {
		this.places = places;
	}

	/** Obtient la liste des rôle de l'utilisateur.
	 * @return Les rôles de de l'utilisateur.
	 */
	public Set<UserRole> getRoles() {
		return roles;
	}

	/** Définit la liste des rôles de l'utilisateur.
	 * @param roles La liste des rôles à définir.
	 */
	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

	/** Obtient la valeur précisant si l'utilisateur est actif.
	 * @return La valeur précisant si l'utilisateur est actif.
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/** Définit la valeur précisant si l'utilisateur est actif.
	 * @param enabled La valeur à définir.
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
