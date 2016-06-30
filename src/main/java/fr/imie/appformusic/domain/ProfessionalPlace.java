package fr.imie.appformusic.domain;

/**
 * Classe représentant un établissement professionnel.
 * @author Dorian
 *
 */
public class ProfessionalPlace extends Place {
	
	private String publicName;
	private String siret;
	private boolean isValidated;
	private String googlePlaceId;
	
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
	/** Obtient la valeur précisant si l'établissement professionnel a été validé.
	 * @return La valeur précisant si l'établissement professionnel a été validé.
	 */
	public boolean isValidated() {
		return isValidated;
	}
	/** Définit la valeur précisant si l'établissement professionnel a été validé.
	 * @param isValidated La valeur à définir.
	 */
	public void setValidated(boolean isValidated) {
		this.isValidated = isValidated;
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

}
