package fr.imie.appformusic.utils;

import java.security.MessageDigest;

import fr.imie.appformusic.exceptions.TechnicalException;

public class Security {
	
	public static String hashPassword(String password, String salt) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			md.update(salt.getBytes("UTF-8"));
			return md.digest(password.getBytes("UTF-8")).toString();
		} catch (Exception e) {
			throw new TechnicalException(e);
		}
	}

}
