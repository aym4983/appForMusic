package fr.imie.appformusic.domain;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

import org.springframework.context.i18n.LocaleContextHolder;

import fr.imie.appformusic.exceptions.TechnicalException;

/**
 * Représente un message d'alerte.
 * @author Dorian
 *
 */
public class Alert {
	
	private String code;
	private String message;
	private Locale locale;
	private String lang;
	private Alert.type alertType;
	
	/**
	 * Type d'alerte.
	 * @author Dorian
	 */
	public static enum type {
		/**  */
		SUCCESS,
		/**  */
		INFO,
		/**  */
		WARNING,
		/**  */
		DANGER
	}
	
	/**
	 * Instancie une nouvelle alerte en spécifiant le type, le code et la locale.
	 * @param alertType Type de l'alerte.
	 * @param code 		Code de l'alerte.
	 * @param locale 	Locale.
	 */
	public Alert(Alert.type alertType, String code, Locale locale) {
		this.alertType = alertType;
		this.code = code;
		this.locale = locale;
		this.lang = String.format("{0}-{1}", locale.getLanguage(), locale.getCountry());
		
		Properties alertsProps = new Properties();
		String propsFileName = String.format("alerts.{0}.properties", this.lang);
		
		try (InputStream propsFile = new FileInputStream(propsFileName)) {
			alertsProps.load(propsFile);
			this.message = alertsProps.getProperty(code);
		} catch (IOException e) {
			throw new TechnicalException(e);
		}
		
	}

	/**
	 * Obtient le code de l'alerte.
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @return the locale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * @return the lang
	 */
	public String getLang() {
		return lang;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

}
