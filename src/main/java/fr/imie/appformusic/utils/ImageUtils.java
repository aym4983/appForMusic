/*
 *@filename ImageUtils.java
 *@author Sakhuraah
 *@date 6 sept. 2016
*/

package fr.imie.appformusic.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;

import fr.imie.appformusic.configuration.constants.Image;
import fr.imie.appformusic.exceptions.TechnicalException;



public class ImageUtils {

	/***** Image Utilisateur ******/ 
	public static byte[] getAvatar(Integer userid){
		File file = new File(Image.AVATAR_PATH, Integer.toString(userid));
				if(!file.exists()){
					return null;
				}
		try{
			return IOUtils.toByteArray(new FileInputStream(file));
		}catch(IOException e){
			throw new TechnicalException(e);
		}
	}
	
	public static String getAvatarPath(Integer userId) {
		return String.format("%s/%s", Image.AVATAR_PATH, userId);
	}
	
	public static boolean AvatarExists(Integer userId){
		return new File(Image.AVATAR_PATH, userId.toString()).exists();
	}
	
	public static void store(InputStream avatar, int userId) throws FileNotFoundException{
		try{
			OutputStream output = new FileOutputStream(new File(Image.AVATAR_PATH, Integer.toString(userId)));
			
			try{
				byte[] buffer = new byte[1024];
				
				int nboctetlu = avatar.read(buffer);
	
				while(nboctetlu != -1){
					output.write(buffer, 0, nboctetlu);
					output.flush();
					nboctetlu = avatar.read(buffer);
				}
			}finally{
				output.close();
				avatar.close();
			}
			
		}catch(IOException e){
			throw new TechnicalException(e);
		}
	}
	
	public static boolean readAvatar(OutputStream output, int userId){
		File file = new File(Image.AVATAR_PATH, Integer.toString(userId));
		if(!file.exists()){
			return false;
		}
		try{
			InputStream avatar = new FileInputStream(file);
			try{
				IOUtils.copy(avatar, output);
			}finally{
				avatar.close();
				output.close();
			}
		}catch(IOException e){
			throw new TechnicalException(e);
		}
		return true;
	}
	
	
	/***** Image Place ******/ 
	public static byte[] getPlaceImage(Integer placeid){
		File file = new File(Image.IMAGE_PATH_DEV, Integer.toString(placeid));
				if(!file.exists()){
					return null;
				}
		try{
			return IOUtils.toByteArray(new FileInputStream(file));
		}catch(IOException e){
			throw new TechnicalException(e);
		}
	}
	
	public static String getImagePath(Integer placeid) {
		return String.format("%s/%s", Image.IMAGE_PATH_DEV, placeid);
	}
	
	public static boolean ImageExists(Integer placeid){
		return new File(Image.IMAGE_PATH_DEV, placeid.toString()).exists();
	}
	
	public static void storeImage(InputStream image, int placeid) throws FileNotFoundException{
		try{
			OutputStream output = new FileOutputStream(new File(Image.IMAGE_PATH_DEV, Integer.toString(placeid)));
			
			try{
				byte[] buffer = new byte[1024];
				
				int nboctetlu = image.read(buffer);
	
				while(nboctetlu != -1){
					output.write(buffer, 0, nboctetlu);
					output.flush();
					nboctetlu = image.read(buffer);
				}
			}finally{
				output.close();
				image.close();
			}
			
		}catch(IOException e){
			throw new TechnicalException(e);
		}
	}
	
	public static boolean readImage(OutputStream output, int placeid){
		File file = new File(Image.IMAGE_PATH_DEV, Integer.toString(placeid));
		if(!file.exists()){
			return false;
		}
		try{
			InputStream avatar = new FileInputStream(file);
			try{
				IOUtils.copy(avatar, output);
			}finally{
				avatar.close();
				output.close();
			}
		}catch(IOException e){
			throw new TechnicalException(e);
		}
		return true;
	}
	
	
}
