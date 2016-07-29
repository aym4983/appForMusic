package fr.imie.appformusic.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * Entity Rates
 * @author Tiphanie
 *
 */
@Entity
public class Rates implements Serializable{

	/** Members **/ 
	private static final long serialVersionUID = -6181193605743886589L;
	
	/** Members **/
	@EmbeddedId
	private RatesPK id;
	
	@Column(name="grade", nullable = false)
	private int grade;
	
	@Column(name="com", length = 255, nullable = false)
	private int com;
	
	/** Constructors **/ 
	public Rates(){}
}
