package fr.imie.appformusic.domain;

import java.util.List;

/**
 * Classe représentant un utilisateur.
 * @author Dorian
 *
 */
public class User {

	private String userName;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private boolean professional;
	private String[] instruments;
	private List<Place> places;
	private List<Boeuf> ownedBoeufs;
	private List<Boeuf> playedBoeufs;
	
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
	public String getFirstName() {
		return firstName;
	}
	/** Définit le prénom de l'utilisateur.
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/** Obtient le nom de famille de l'utilisateur.
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/** Définit le nom de famille de l'utilisateur.
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/** Obtient la donnée précisant si l'utilisateur est un prefessionnel.
	 * @return the professional
	 */
	public boolean isProfessional() {
		return professional;
	}
	/** Définit la donnée précisant si l'utilisateur est un professionnel.
	 * @param professional the professional to set
	 */
	public void setProfessional(boolean professional) {
		this.professional = professional;
	}
	/** Obtient la liste des instruments joués par l'utilisateur.
	 * @return the instruments
	 */
	public String[] getInstruments() {
		return instruments;
	}
	/** Définit la liste des instruments joués par l'utilisateur.
	 * @param instruments the instruments to set
	 */
	public void setInstruments(String[] instruments) {
		this.instruments = instruments;
	}
	/** Obtient la liste des lieux enregistrés par l'utilisateur.
	 * @return the places
	 */
	public List<Place> getPlaces() {
		return places;
	}
	/** Définit la liste des lieux enregistrés par l'utilisateur.
	 * @param places the places to set
	 */
	public void setPlaces(List<Place> places) {
		this.places = places;
	}
	/** Obtient la liste des boeufs organisés par l'utilisateur.
	 * @return the ownedBoeufs
	 */
	public List<Boeuf> getOwnedBoeufs() {
		return ownedBoeufs;
	}
	/** Définit la liste des boeufs organisés par l'utilisateur.
	 * @param ownedBoeufs the ownedBoeufs to set
	 */
	public void setOwnedBoeufs(List<Boeuf> ownedBoeufs) {
		this.ownedBoeufs = ownedBoeufs;
	}
	/** Obtient la liste des boeufs dans lesquels l'utilisateur joue.
	 * @return the playedBoeufs
	 */
	public List<Boeuf> getPlayedBoeufs() {
		return playedBoeufs;
	}
	/** Définit la liste des boeufs dans lesquels l'utilisateur joue.
	 * @param playedBoeufs the playedBoeufs to set
	 */
	public void setPlayedBoeufs(List<Boeuf> playedBoeufs) {
		this.playedBoeufs = playedBoeufs;
	}
	
}
