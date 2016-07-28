package fr.imie.appformusic.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * Entity Borrows
 * @author Tiphanie
 *
 */

@Entity
public class Borrows implements Serializable{

	/** Members **/ 
	private static final long serialVersionUID = 1077164344082542652L;
	
	/** Members **/
	@EmbeddedId
	private BorrowsPK id;
	
	@Column(name="validate")
	private boolean validate;
	
	/** Constructors **/ 
	public Borrows(){}
	
	public Borrows(BorrowsPK id, boolean validate){
		super();
		this.id = id;
		this.validate = validate;
	}
}
