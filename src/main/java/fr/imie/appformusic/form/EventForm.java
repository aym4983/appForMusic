/*
 *@filename EventForm.java
 *@author Lila
 *@date 07 septembre 2016
*/

package fr.imie.appformusic.form;

public class EventForm {

	private String startevent;
	private String endevent;
	private String titleevent;
	private int placeId;
	
	
	public int getPlaceId() {
		return placeId;
	}
	public void setPlaceId(int placeId) {
		this.placeId = placeId;
	}
	public String getStartevent() {
		return startevent;
	}
	public void setStartevent(String startevent) {
		this.startevent = startevent;
	}
	public String getEndevent() {
		return endevent;
	}
	public void setEndevent(String endevent) {
		this.endevent = endevent;
	}
	public String getTitleevent() {
		return titleevent;
	}
	public void setTitleevent(String titleevent) {
		this.titleevent = titleevent;
	}
}
