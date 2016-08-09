package fr.imie.appformusic.exceptions;

import java.util.ArrayList;
import java.util.List;

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
		DIFFERENT_PASSWORDS
	}

	private List<Code> codes;
	
	public BusinessException(Code code) {
		List<Code> codes = new ArrayList<Code>();
		codes.add(code);
		this.codes = codes;
	}
	
	public BusinessException(List<Code> codes) {
		this.codes = codes;
	}

	/** Obtient la liste des codes de l'exception.
	 * @return Les codes de l'exception.
	 */
	public List<Code> getCodes() {
		return codes;
	}
	
}
