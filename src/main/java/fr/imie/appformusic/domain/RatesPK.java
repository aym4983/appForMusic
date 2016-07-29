package fr.imie.appformusic.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PK Rates
 * @author Tiphanie
 * 
 */

@Embeddable
public class RatesPK implements Serializable{
	
	/** Members **/
	private static final long serialVersionUID = 7566880716434444496L;
	
	@Column(name="userId")
	private int userId;
	
	@Column(name="userBeingRatedId")
	private int userBeingRatedId;
}
