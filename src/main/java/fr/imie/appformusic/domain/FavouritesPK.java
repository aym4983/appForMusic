package fr.imie.appformusic.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FavouritesPK {
	/** Members **/
	@Column(name="userId")
	private int userId;
	
	@Column(name="placeId")
	private int placeId;
}
