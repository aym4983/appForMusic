package fr.imie.appformusic.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PK Owns
 * @author Tiphanie
 */

@Embeddable
public class OwnsPK implements Serializable{

	/** Members **/
	private static final long serialVersionUID = 1078387525574164822L;
	
	@Column(name="userId")
	private int userId;
	
	@Column(name="placeId")
	private int placeId;
}
