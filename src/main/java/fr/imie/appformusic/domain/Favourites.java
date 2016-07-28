package fr.imie.appformusic.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * Entity Favourites
 * @author Tiphanie
 */

@Entity
public class Favourites implements Serializable {

	/** Members **/
	private static final long serialVersionUID = -8371951894398688411L;

	/** Members **/
	@EmbeddedId
	private FavouritesPK id;
	
	/** Constructors **/ 
	public Favourites(){}
}
