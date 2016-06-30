package fr.imie.appformusic.domain;

/**
 * Classe métier représentant un utilisateur.
 * @author Dorian
 *
 */
public class User {

	private String userName;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private boolean isProfessional;
	private String[] instruments; 
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the isProfessional
	 */
	public boolean isProfessional() {
		return isProfessional;
	}
	/**
	 * @param isProfessional the isProfessional to set
	 */
	public void setProfessional(boolean isProfessional) {
		this.isProfessional = isProfessional;
	}
	/**
	 * @return the instruments
	 */
	public String[] getInstruments() {
		return instruments;
	}
	/**
	 * @param instruments the instruments to set
	 */
	public void setInstruments(String[] instruments) {
		this.instruments = instruments;
	}
	
}
