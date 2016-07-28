package fr.imie.appformusic.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PK Owns
 * @author Tiphanie
 */

@Embeddable
public class OwnsPK {
	/** Members **/
	@Column(name="userId")
	private int userId;
	
	@Column(name="placeId")
	private int placeId;
}
