package fr.imie.appformusic.responses;


public class Response<T> {

	
	private boolean succeeded;
	private T content;
	
	public Response(T content) {
		succeeded = true;
		this.content = content;
	}
	public Response() {
		succeeded = true;
	}
	
	public Response(boolean succeeded) {
		this.succeeded = succeeded;
	}

	public boolean isSucceeded() {
		return succeeded;
	}

	public void setSucceeded(boolean succeeded) {
		this.succeeded = succeeded;
	}
	
	public T getContent() {
		return content;
	}
	
	public void setContent(T content) {
		this.content = content;
	}

}
