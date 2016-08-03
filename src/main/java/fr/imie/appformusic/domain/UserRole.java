package fr.imie.appformusic.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe représentant un label d'utilisateur.
 * @author Dorian
 *
 */
@Entity
@Table(name="userrole")
public class UserRole {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String label;
	
	@ManyToOne
	private AppUser user;
	
	
	public UserRole(){}
	/** Obtient l'identifiant numérique du rôle.
	 * @return L'identifiant numérique du rôle.
	 */
	public long getId() {
		return id;
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
