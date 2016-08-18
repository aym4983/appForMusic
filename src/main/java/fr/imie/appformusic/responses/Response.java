package fr.imie.appformusic.responses;

public abstract class Response {
	
	private boolean succeeded;
	
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

}
