package fr.imie.appformusic.domain;

import java.util.List;

/**
 * Classe réprésentant un lieu.
 * @author Dorian
 *
 */
public class Place {
	
	private int id;
	private String label;
	private String address;
	private double latitude;
	private double longitude;
	private User owner;
	private List<Boeuf> boeufs;
	
	/** Obtient l'identifiant numérique du lieu.
	 * @return L'identifiant numérique du lieu.
	 */
	public int getId() {
		return id;
	}
	/** Définit l'identifiant numérique du lieu.
	 * @param id L'identifiant numérique à définir.
	 */
	public void setId(int id) {
		this.id = id;
	}
	/** Obtient le libellé du lieu.
	 * @return Le libellé du lieu.
	 */
	public String getLabel() {
		return label;
	}
	/** Définit le libellé du lieu.
	 * @param label Le libellé à définir.
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	/** Obtient l'adresse postale du lieu.
	 * @return L'adresse postale du lieu.
	 */
	public String getAddress() {
		return address;
	}
	/** Définit l'adresse postale du lieu.
	 * @param address L'adresse postale à définir.
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/** Obtient la latitude du lieu.
	 * @return La latitude du lieu.
	 */
	public double getLatitude() {
		return latitude;
	}
	/** Définit la latitude du lieu.
	 * @param latitude La latitude à définir.
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	/** Obtient la longitude du lieu.
	 * @return La longitude du lieu.
	 */
	public double getLongitude() {
		return longitude;
	}
	/** Définit la longitude du lieu.
	 * @param longitude La longitude à définir.
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	/** Obtient l'utilisateur propriétaire du lieu.
	 * @return L'utilisateur propriétaire du lieu.
	 */
	public User getOwner() {
		return owner;
	}
	/** Définit l'utilisateur propriétaire du lieu.
	 * @param owner L'utilisateur propriétaire à définir.
	 */
	public void setOwner(User owner) {
		this.owner = owner;
	}
	/** Obtient la liste des boeufs organisés dans le lieu.
	 * @return La liste des boeufs organisés dans le lieu.
	 */
	public List<Boeuf> getBoeufs() {
		return boeufs;
	}
	/** Définit la liste des boeufs organisés dans le lieu.
	 * @param boeufs La liste des boeufs à définir.
	 */
	public void setBoeufs(List<Boeuf> boeufs) {
		this.boeufs = boeufs;
	}

}
