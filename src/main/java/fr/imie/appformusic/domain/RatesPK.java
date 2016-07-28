package fr.imie.appformusic.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PK Rates
 * @author Tiphanie
 */

@Embeddable
public class RatesPK {
	
	/** Members **/
	@Column(name="userId")
	private int userId;
	
	@Column(name="userId")
	private int userBeingRatedId;
}
