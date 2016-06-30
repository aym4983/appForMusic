package fr.imie.appformusic.domain;

import java.util.Date;
import java.util.List;

/**
 * Classe représentant un boeuf.
 * @author Dorian
 *
 */
public class Boeuf {
	
	private int id;
	private String label;
	private Date startDate;
	private Date endDate;
	private int maxMusicians;
	private String[] genres;
	private String[] instruments;
	private User owner;
	private List<User> musicians;
	private Place place;
	
	/** Obtient l'identifiant numérique du boeuf.
	 * @return L'identifiant du boeuf.
	 */
	public int getId() {
		return id;
	}
	/** Définit l'identifiant numérique du boeuf.
	 * @param id L'identifiant à définir.
	 */
	public void setId(int id) {
		this.id = id;
	}
	/** Obtient le libellé du boeuf.
	 * @return Le libellé du boeuf.
	 */
	public String getLabel() {
		return label;
	}
	/** Définit le libellé du boeuf.
	 * @param label Le libellé à définir.
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	/** Obtient la date de début du boeuf.
	 * @return La date de début du boeuf.
	 */
	public Date getStartDate() {
		return startDate;
	}
	/** Définit la date de début du boeuf.
	 * @param startDate La date de début à définir.
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/** Obtient la date de fin du boeuf.
	 * @return La date de fin du boeuf.
	 */
	public Date getEndDate() {
		return endDate;
	}
	/** Définit la date de fin du boeuf.
	 * @param endDate La date de fin à définir.
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/** Obtient le nombre maximum de musiciens autorisés pour le boeuf.
	 * @return La liste des musiciens participant au boeuf.
	 */
	public int getMaxMusicians() {
		return maxMusicians;
	}
	/** Définit le nombre maximum de musiciens autorisés pour le boeuf.
	 * @param maxMusicians the maxMusicians to set
	 */
	public void setMaxMusicians(int maxMusicians) {
		this.maxMusicians = maxMusicians;
	}
	/** Obtient la liste des genres musicaux du boeuf.
	 * @return Les genres musicaux du boeuf.
	 */
	public String[] getGenres() {
		return genres;
	}
	/** Définit la liste des genres musicaux du boeuf.
	 * @param genres Les genres musicaux à définir.
	 */
	public void setGenres(String[] genres) {
		this.genres = genres;
	}
	/** Obtient la liste des instruments attendus pour le boeuf.
	 * @return La liste des instruments attendus pour le boeuf.
	 */
	public String[] getInstruments() {
		return instruments;
	}
	/** Définit la liste des instruments attendus pour le boeuf.
	 * @param instruments La liste des instruments à définir.
	 */
	public void setInstruments(String[] instruments) {
		this.instruments = instruments;
	}
	/** Obtient l'utilisateur propriétaire du boeuf.
	 * @return L'utilisateur propriétaire du boeuf.
	 */
	public User getOwner() {
		return owner;
	}
	/** Définit l'utilisateur propriétaire du boeuf.
	 * @param owner L'utiliateur à définir.
	 */
	public void setOwner(User owner) {
		this.owner = owner;
	}
	/** Obtient la liste des musiciens participant au boeuf.
	 * @return La liste des musiciens participant au boeuf.
	 */
	public List<User> getMusicians() {
		return musicians;
	}
	/** Définit la liste des musiciens participant au boeuf.
	 * @param musicians La liste des musiciens à définir.
	 */
	public void setMusicians(List<User> musicians) {
		this.musicians = musicians;
	}
	/** Obtient le lieu dans lequel se déroule le boeuf.
	 * @return Le lieu dans lequel se déroule le boeuf.
	 */
	public Place getPlace() {
		return place;
	}
	/** Définit le lieu dans lequel se déroule le boeuf.
	 * @param place Le lieu à définir.
	 */
	public void setPlace(Place place) {
		this.place = place;
	}

}
