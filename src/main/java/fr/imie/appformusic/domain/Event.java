package fr.imie.appformusic.domain;

import java.util.Date;

/**
 * Classe représentant un événement.
 * @author Dorian
 *
 */
public class Event {
	
	private int id;
	private Date startDate;
	private Date endDate;
	private String[] genres;
	private boolean published;
	
	/**
	 * Obtient l'identifiant numérique de l'événement.
	 * @return L'identifiant numérique de l'événement.
	 */
	public int getId() {
		return id;
	}
	/**
	 * Définit l'identifiant numérique de l'événement.
	 * @param id L'identifiant numérique à définir.
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Obtient la date de début de l'événement.
	 * @return La date de début de l'événement.
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * Définit la date de début de l'événement.
	 * @param startDate La date de début à définir.
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * Obtient la date de fin de l'événement.
	 * @return La date de fin de l'événement.
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * Définit la date de fin de l'événement.
	 * @param endDate La date de fin à définir.
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * Obtient la liste des genres musicaux de l'événement.
	 * @return La liste des genres musicaux de l'événement.
	 */
	public String[] getGenres() {
		return genres;
	}
	/**
	 * Définit la liste des genres musicaux de l'événement.
	 * @param genres La liste des genres musicaux à définir.
	 */
	public void setGenres(String[] genres) {
		this.genres = genres;
	}
	/**
	 * Obtient la donnée précisant si l'événement est publié.
	 * @return La donnée précisant si l'événement est publié.
	 */
	public boolean isPublished() {
		return published;
	}
	/**
	 * Définit la donnée précisant si l'événement est publié.
	 * @param published La donnée à définir.
	 */
	public void setPublished(boolean published) {
		this.published = published;
	}

}
