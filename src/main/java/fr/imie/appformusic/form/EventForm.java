package fr.imie.appformusic.form;

import java.util.Date;

public class EventForm {

	private Date startEvent;
	private Date endEvent;
	private String titleEvent;
	
	
	public Date getStartEvent() {
		return startEvent;
	}
	public void setStartEvent(Date startEvent) {
		this.startEvent = startEvent;
	}
	public Date getEndEvent() {
		return endEvent;
	}
	public void setEndEvent(Date endEvent) {
		this.endEvent = endEvent;
	}
	public String getTitleEvent() {
		return titleEvent;
	}
	public void setTitleEvent(String titleEvent) {
		this.titleEvent = titleEvent;
	}
}
