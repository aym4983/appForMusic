/*
 *@filename Role.java
 *@author Sakhuraah
 *@date 17 août 2016
*/

package fr.imie.appformusic.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role implements Serializable {
	
	/** Members **/
	private static final long serialVersionUID = -6579344643641195794L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private byte id;
	
	@Column(name="label", nullable = false, length = 256)
	private String label;
	
	@ManyToMany
	@JoinTable(name = "user_role", 
		joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "username", referencedColumnName = "username"))
	private Set<AppUser> users;
	
	/** Constructors **/

	public Role(byte id, String label){
		this.id = id;
		this.label = label;
	}
	
	public Role(){
	}
	
	/*** Getters and setters **/
	public byte getId() {
		return id;
	}

	public void setId(byte id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Set<AppUser> getUsers() {
		return users;
	}

	public void setUsers(Set<AppUser> users) {
		this.users = users;
	}
	
}
