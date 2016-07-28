package fr.imie.appformusic.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Classe représentant un label d'utilisateur.
 * @author Dorian
 *
 */
@Entity
public class UserRole {

	@Id
	@Column(name="roleId")
	private int id;
	private String label;
	
	/** Obtient l'identifiant numérique du rôle.
	 * @return L'identifiant numérique du rôle.
	 */
	public int getId() {
		return id;
	}
	
	/** Définit l'identifiant numérique du rôle.
	 * @param id L'identifiant numérique à définir.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/** Obtient le libellé du rôle.
	 * @return Le libellé du rôle.
	 */
	public String getRole() {
		return label;
	}
	
	/** Définit le libellé du rôle.
	 * @param label Le libellé à définir.
	 */
	public void setRole(String label) {
		this.label = label;
	}

}
