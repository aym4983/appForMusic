package fr.imie.appformusic.domain;

import java.util.List;

/**
 * Classe représentant un établissement professionnel.
 * @author Dorian
 *
 */
public class ProfessionalPlace extends Place {
	
	private String publicName;
	private String siret;
	private boolean validated;
	private boolean published;
	private String googlePlaceId;
	private List<Event> Events;
	
	/** Obtient le nom public de l'établissement professionnel.
	 * @return Le nom public de l'établissement professionnel.
	 */
	public String getPublicName() {
		return publicName;
	}
	/** Définit le nom public de l'établissement professionnel.
	 * @param publicName Le nom public à définir.
	 */
	public void setPublicName(String publicName) {
		this.publicName = publicName;
	}
	/** Obtient le numéro SIRET de l'établissement professionnel.
	 * @return Le numéro SIRET de l'établissement professionnel.
	 */
	public String getSiret() {
		return siret;
	}
	/** Définit le nnuméro SIRET de l'établissement professionnel.
	 * @param siret Le numéro SIRET à définir.
	 */
	public void setSiret(String siret) {
		this.siret = siret;
	}
	/** Obtient la donnée précisant si l'établissement professionnel a été validé.
	 * @return La donnée précisant si l'établissement professionnel a été validé.
	 */
	public boolean isValidated() {
		return validated;
	}
	/** Définit la donnée précisant si l'établissement professionnel a été validé.
	 * @param validated La donnée à définir.
	 */
	public void setValidated(boolean validated) {
		this.validated = validated;
	}
	/** Obtient la donnée précisant si l'établissement professionnel est publié.
	 * @return La donnée précisant si l'établissement professionnel est publié.
	 */
	public boolean isPublished() {
		return published;
	}
	/** Définit la donnée précisant si l'établissement professionnel est publié.
	 * @param published La donnée à définir.
	 */
	public void setPublished(boolean published) {
		this.published = published;
	}
	/** Obtient l'identifiant de lieu Google.
	 * @return L'identifiant de lieu Google.
	 */
	public String getGooglePlaceId() {
		return googlePlaceId;
	}
	/** Définit l'identifiant de lieu Google.
	 * @param googlePlaceId L'identifiant de lieu Google à définir.
	 */
	public void setGooglePlaceId(String googlePlaceId) {
		this.googlePlaceId = googlePlaceId;
	}
	/** Obtient la liste des événements de l'établissement professionnel.
	 * @return La liste des événements de l'établissement professionnel.
	 */
	public List<Event> getEvents() {
		return Events;
	}
	/** Définit la liste des événements de l'établissement professionnel.
	 * @param events La liste des événements à définir.
	 */
	public void setEvents(List<Event> events) {
		Events = events;
	}

}
