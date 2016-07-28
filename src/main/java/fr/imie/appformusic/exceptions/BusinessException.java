package fr.imie.appformusic.exceptions;

@SuppressWarnings("serial")
public class BusinessException extends Exception {

	private Code code;
	
	public static enum Code {
		/** L'adresse e-mail est vide. */
		EMAIL_EMPTY
	}
	
	public BusinessException(Code code){
		this.code = code;
	}

	public Code getCode() {
		return code;
	}

	public void setCode(Code code) {
		this.code = code;
	}
	
}
