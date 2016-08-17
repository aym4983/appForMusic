package fr.imie.appformusic.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe représentant un label d'utilisateur.
 * @author Dorian
 *
 */
@Entity
@Table(name="userrole")
public class UserRole {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private AppUser user;
	
	@ManyToOne
	private Role role;
	
	public UserRole(){}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public AppUser getUser() {
		return user;
	}

	public void setUser(AppUser user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
