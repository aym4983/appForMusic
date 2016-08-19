package fr.imie.appformusic.domain.json;

import fr.imie.appformusic.domain.AppUser;

public class UserJson {
	
	private String username;
	private String firstname;
	private String lastname;
	
	public UserJson(AppUser user) {
		username = user.getUsername();
		firstname = user.getFirstname();
		lastname = user.getLastname();
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
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

}
