package fr.imie.appformusic.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Classe représentant un utilisateur.
 * @author Dorian
 *
 */
@Entity
@Table(name="appuser", uniqueConstraints=@UniqueConstraint(columnNames = { "email" }))
public class AppUser implements Serializable {
	
	/** Members **/ 
	private static final long serialVersionUID = 5219643569000183378L;
	
	@Id
	@Column(name="username", length = 32)
	private String username;
	
	@Column(name="email", nullable = false, length = 256)
	private String email;
	
	@Column(name="passwordhash", nullable = false, length = 512)
	private String passwordHash;
	
	@Column(name="firstname", length = 32)
	private String firstname;
	
	@Column(name="lastname", length = 32)
	private String lastname;
	
	@OneToMany(mappedBy="user")
	private Set<Borrows> borrows;
	
	@OneToMany(mappedBy="user")
	private Set<Favourites> favourites;
	
	@OneToMany(mappedBy="user")
	private Set<UserRole> roles;
	
	@OneToMany(mappedBy="userbeingrated")
	private Set<Rates> ratesbeingrated;
	
	@OneToMany(mappedBy="user")
	private Set<Rates> rates;
	
	@Column(name="enabled")
	private boolean enabled;

	/** Constructors **/
	public AppUser(){}
	
	public AppUser(String username, String email, String password, String firstname, String lastname,
			Set<Borrows> borrows, Set<UserRole> roles, boolean enabled) {
		super();
		this.username = username;
		this.email = email;
		this.passwordHash = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.borrows = borrows;
		this.roles = roles;
		this.enabled = enabled;
	}

	/** Getters and Setters **/ 
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Set<Borrows> getBorrows() {
		return borrows;
	}

	public void setBorrows(Set<Borrows> borrows) {
		this.borrows = borrows;
	}

	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
