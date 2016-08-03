package fr.imie.appformusic.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity Rates
 * @author Tiphanie
 *
 */
@Entity
@Table(name="rates")
public class Rates implements Serializable{

	/** Members **/ 
	private static final long serialVersionUID = -6181193605743886589L;
	
	/** Members **/
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private AppUser userbeingrated;
	
	@ManyToOne 
	private AppUser user;
	
	@Column(name="grade", nullable = false)
	private int grade;
	
	@Column(name="com", length = 255, nullable = false)
	private int com;
	
	/** Constructors **/ 
	public Rates(){}
}
