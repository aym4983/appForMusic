package fr.imie.support.exception;

public class ConfigurationRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2865322200463263205L;

	public ConfigurationRuntimeException(){
		super();
	}
	
	public ConfigurationRuntimeException(String message){
		super(message);
	}
	
	public ConfigurationRuntimeException(Throwable cause){
		super(cause);
	}
	
	public ConfigurationRuntimeException(String message, Throwable cause){
		super(message, cause);
	}
	
}
