package fr.imie.appformusic.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity Picture
 * @author Tiphanie
 */

@Entity
public class Picture implements Serializable {

	/** Members **/ 
	private static final long serialVersionUID = -8785577158010174641L;
	
	@Id @Column(name="pictureId")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pictureId;
	
	@Column(name="path", length = 255, nullable = false)
	private String path;
	
	/** Constructors **/ 
	public Picture(){}
	
	public Picture(int pictureId, String path){
		super();
		this.pictureId = pictureId;
		this.path = path;
	}
	
	/** Getters and Setters **/
	public int getPictureId() {
		return pictureId;
	}

	public void setPictureId(int pictureId) {
		this.pictureId = pictureId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
}
