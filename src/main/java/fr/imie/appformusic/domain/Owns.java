package fr.imie.appformusic.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * Entity Owns
 * @author Tiphanie
 *
 */

@Entity
public class Owns implements Serializable{

	/** Members **/ 
	private static final long serialVersionUID = -3178690710367907449L;
	
	/** Members **/
	@EmbeddedId
	private OwnsPK id;
	
	/** Constructors **/ 
	public Owns(){}
}
