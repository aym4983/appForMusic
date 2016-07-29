package fr.imie.appformusic.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PK Favourites
 * @author Tiphanie
 *
 */

@Embeddable
public class FavouritesPK implements Serializable{
	
	/** Members **/
	private static final long serialVersionUID = 3216228574389414597L;
	
	@Column(name="userId")
	private int userId;
	
	@Column(name="placeId")
	private int placeId;
}
