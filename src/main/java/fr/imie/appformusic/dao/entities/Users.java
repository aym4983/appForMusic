package fr.imie.appformusic.dao.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author Tiphanie Aubry
 *
 */

@Entity
@Table(name="Users")
public class Users {
	
	/** Attributes **/
	@Id
	@Column(name="userName", nullable=false, unique=true, length=255)
	private String userName;
	
	@Column(name="email", nullable=false,length=255)
	private String email;
	
	@Column(name="password", nullable=false,length=255)
	private String password;
	
	@Column(name="enabled", nullable=false)
	private boolean enabled;
	
	@Column(name="firstName", nullable=false,length=60)
	private String firstName;
	
	@Column(name="lastName", nullable=false,length=60)
	private String lastName;
	
	@Column(name="isProfessional", nullable=false)
	private boolean isProfessional;
	
	@Column(name="phone", nullable=false,length=10)
	private String phone;
	
	@OneToMany
	@JoinColumn(name="id")
	private Set<Boeuf> ListBoeuf = new HashSet<Boeuf>();
	
	@OneToMany
	@JoinColumn(name="id")
	private Set<Place> ListPlace = new HashSet<Place>();
	
	@OneToMany(mappedBy="user")
	private Set<Created> listCreated;
	
	/** Constructeur **/
	public Users(){
		
	}
	
	/** Getters and setters **/
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
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
	
	public boolean isProfessional() {
		return isProfessional;
	}
	public void setProfessional(boolean isProfessional) {
		this.isProfessional = isProfessional;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void addBoeuf(Boeuf b){
		ListBoeuf.add(b);
	}
	public Set<Boeuf> getListBoeuf(){
		return ListBoeuf;
	}
}
