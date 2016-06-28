package fr.imie.appformusic.exceptions;

@SuppressWarnings("serial")
public class TechnicalException extends RuntimeException {

	public TechnicalException(Throwable t){
		super(t);
	}
	
}
