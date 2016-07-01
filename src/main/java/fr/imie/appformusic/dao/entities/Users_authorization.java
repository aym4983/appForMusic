package fr.imie.appformusic.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Users_authorization")
public class Users_authorization {

	/** Attributes **/
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id",nullable=false,unique=true)	
	private int user_role_id;
	
	@ManyToOne
	private Users users;
	
	@Column(name="role", nullable=false, length=30)
	private String role;
	
	/** Getters and Setters **/
	public int getUser_role_id() {
		return user_role_id;
	}
	public void setUser_role_id(int user_role_id) {
		this.user_role_id = user_role_id;
	}
	
	public Users getUser() {
		return users;
	}
	public void setUser(Users user) {
		this.users = user;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}
