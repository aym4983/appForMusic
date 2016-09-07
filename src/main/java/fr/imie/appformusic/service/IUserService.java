package fr.imie.appformusic.service;

import java.util.List;

import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.exceptions.BusinessException;

public interface IUserService {
	
	/**
	 * Crée un utilisateur.
	 * @param user L'utilisateur à créer.
	 */
	public void create(AppUser user, String password, String confirmPassword) throws BusinessException;
	
	/**
	 * Trouve un utilisateur via son identifiant.
	 * @param userName 	L'identifiant de l'utilisateur.
	 * @return 			L'utilisateur recherché.
	 * @throws BusinessException
	 */
	public AppUser findByUserName(String userName) throws BusinessException;
	
	/**
	 * Trouve un utilisateur via son identifiant.
	 * @param email L'identifiant de l'utilisateur.
	 * @return 		L'utilisateur recherché.
	 * @throws BusinessException
	 */
	public AppUser findByEmail(String email) throws BusinessException;
	
	/**
	 * Trouve tous les utilisateurs.
	 * @return La liste de tous les utilisateurs.
	 * @throws BusinessException
	 */
	public List<AppUser> findAllUsers() throws BusinessException;
	
	/**
	 * Trouve tous les utilisateurs dont le username est proche de celui spécifié.
	 * @return La liste des utilisateurs dont le username est proche de celui spécifié.
	 * @throws BusinessException
	 */
	public List<AppUser> findUsersLike(String username) throws BusinessException;
	
	/**
	 * Supprime l'utilisateur spécifié.
	 * @param user L'utilisateur à supprimer.
	 */
	public void remove(AppUser user) throws BusinessException;
	
	/**
	 * Modifie les attributs spécifiés de l'utilisateur.
	 * @param user 			L'utilisateur à modifier.
	 * @param newEmail 		La nouvelle adresse e-mail de l'utilisateur.
	 * @param newFirstName 	Le nouveau prénom de l'utilisateur.
	 * @param newLastName 	Le nouveau nom de famille de l'utilisateur.
	 * @return 				L'utilisateur modifié.
	 */
	public AppUser updateUserInfos(
			AppUser user, 
			String newEmail, 
			String newFirstName, 
			String newLastName) 
			throws BusinessException;
	
	/**
	 * Modifie le mot de passe de l'utilisateur.
	 * @param user 					L'utilisateur à modifier.
	 * @param oldPassword 			L'ancien mot de passe de l'utilisateur.
	 * @param newPassword 			Le nouveau mot de passe de l'utilisateur.
	 * @param newPasswordConfirm 	La confirmation du nouveau mot de l'utilisateur.
	 * @return L'utilisateur modifié.
	 */
	public AppUser updateUserPass(
			AppUser user, 
			String oldPassword, 
			String newPassword, 
			String newPasswordConfirm) 
			throws BusinessException;
	
	/**
	 * Modifie l'identifiant de l'utilisateur spécifié.
	 * @param user 			L'utilisateur à modifier.
	 * @param newUserName 	Le nouvel identifiant de l'utilisateur.
	 * @return 				L'utilisateur modifié.
	 */
	public AppUser updateUserName(AppUser user, String newUserName) throws BusinessException;

	/**
	 * Modifie l'adresse e-mail de l'utilisateur spécifié.
	 * @param user 			L'utilisateur à modifier.
	 * @param newEmail 		La nouvelle adresse e-mail de l'utilisateur.
	 * @return 				L'utilisateur modifié.
	 */
	public AppUser updateEmail(AppUser user, String newEmail) throws BusinessException;

	/**
	 * Modifie le mot de passe de l'utilisateur spécifié.
	 * @param user 			L'utilisateur à modifier.
	 * @param newPassword 	Le nouveau mot de passe de l'utilisateur.
	 * @return 				L'utilisateur modifié.
	 */
	public AppUser updatePassword(AppUser user, String newPassword) throws BusinessException;

	/**
	 * Modifie le prénom de l'utilisateur spécifié.
	 * @param user 			L'utilisateur à modifier.
	 * @param newFirstName 	Le nouveau prénom de l'utilisateur.
	 * @return 				L'utilisateur modifié.
	 */
	public AppUser updateFirstName(AppUser user, String newFirstName) throws BusinessException;

	/**
	 * Modifie le nom de famille de l'utilisateur spécifié.
	 * @param user 			L'utilisateur à modifier.
	 * @param newLastName 	Le nouveau nom de famille de l'utilisateur.
	 * @return 				L'utilisateur modifié.
	 */
	public AppUser updateLastName(AppUser user, String newLastName) throws BusinessException;
	
	/**
	 * Crypte le mot de passe spécifié.
	 * @param password Le mot de passe à crypter.
	 * @return Le mot de passe crypté.
	 */
	public String encryptPassword(String password);
}
