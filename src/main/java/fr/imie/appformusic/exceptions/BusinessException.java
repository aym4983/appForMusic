package fr.imie.appformusic.exceptions;

@SuppressWarnings("serial")
public class BusinessException extends Exception {
	
	public static enum Code {
		/** Le nom d'utilisateur est vide. */
		USERNAME_EMPTY,
		/** L'adresse e-mail est vide. */
		EMAIL_EMPTY,
		/** Le mot de passe est vide. */
		PASSWORD_EMPTY,
		/** La confirmation de mot de passe est vide. */
		PASSWORD_CONFIRM_EMPTY,
		/** Les mots de passe sont différents. */
		DIFFERENT_PASSWORDS,
		/** Le mot de passe est faux. */
		WRONG_PASSWORD
	}

	private Code code;
	
	public BusinessException(Code code) {
		this.code = code;
	}

	/** Obtient la liste des codes de l'exception.
	 * @return Les codes de l'exception.
	 */
	public Code getCode() {
		return code;
	}
	
}
