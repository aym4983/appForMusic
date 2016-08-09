package fr.imie.appformusic.utils;

import java.security.MessageDigest;

import javax.xml.bind.DatatypeConverter;

import fr.imie.appformusic.exceptions.TechnicalException;

public class Security {
	
	public static String hashPassword(String password, String salt) {
		try {
			String toHash = password + salt;
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			return DatatypeConverter.printHexBinary(md.digest(toHash.getBytes("UTF-8")));
		} catch (Exception e) {
			throw new TechnicalException(e);
		}
	}

}
