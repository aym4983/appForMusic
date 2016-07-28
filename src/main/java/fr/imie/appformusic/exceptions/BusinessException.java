package fr.imie.appformusic.exceptions;

@SuppressWarnings("serial")
public class BusinessException extends Exception {

	private Code code;
	
	public static enum Code {
		/** Le nom d'utilisateur est vide. */
		USERNAME_EMPTY,
		/** L'adresse e-mail est vide. */
		EMAIL_EMPTY,
		/** Le mot de passe est vide. */
		PASSWORD_EMPTY,
		/** La confirmation de mot de passe est vide. */
		PASSWORD_CONFIRM_EMPTY
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
