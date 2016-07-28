package fr.imie.appformusic.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PK Borrows
 * @author Tiphanie
 */

@Embeddable
public class BorrowsPK {
	/** Members **/
	@Column(name="userId")
	private int userId;
	
	@Column(name="placeId")
	private int placeId;
}

