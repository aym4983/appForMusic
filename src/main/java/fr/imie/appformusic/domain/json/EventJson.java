package fr.imie.appformusic.domain.json;

import org.joda.time.DateTime;

import fr.imie.appformusic.domain.Event;

public class EventJson {
	
	private int eventid;
	private String startevent;
	private String endevent;
	private String titleevent;
	private PlaceJson place;

	
	
	public EventJson(Event event) {
		eventid = event.getid();
		startevent = event.getStartevent();
		endevent = event.getEndevent();
		titleevent = event.getTitleevent();
		place = new PlaceJson(event.getPlace());
	}
	
	public PlaceJson getPlace() {
		return place;
	}

	public void setPlace(PlaceJson place) {
		this.place = place;
	}
	public int getEventid() {
		return eventid;
	}
	public void setEventid(int eventid) {
		this.eventid = eventid;
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