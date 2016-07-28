package fr.imie.appformusic.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PK Proposes
 * @author Tiphanie
 */

@Embeddable
public class ProposesPK implements Serializable{
	
	/** Members **/
	@Column(name="gearId")
	private int gearId;
	
	@Column(name="placeId")
	private int placeId;
	
}
