package fr.imie.appformusic.exceptions;

@SuppressWarnings("serial")
public class BusinessException extends Exception {

	private String code;
	
	public BusinessException(String code){
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
