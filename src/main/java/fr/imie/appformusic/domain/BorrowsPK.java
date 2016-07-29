package fr.imie.appformusic.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PK Borrows
 * @author Tiphanie
 */

@Embeddable
public class BorrowsPK implements Serializable{

	/** Members **/
	private static final long serialVersionUID = -3153871927486861135L;
	
	@Column(name="userId")
	private int userId;
	
	@Column(name="placeId")
	private int placeId;
}

