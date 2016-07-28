package fr.imie.appformusic.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * Entity Proposes
 * @author Tiphanie
 */

@Entity
public class Proposes implements Serializable {

	private static final long serialVersionUID = 3896531394854038424L;
	
	/** Members **/
	@EmbeddedId
	private ProposesPK id;
	
	/** Constructors **/ 
	public Proposes(){}
	
}
