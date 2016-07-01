package fr.imie.appformusic.service;

import java.util.List;

import fr.imie.appformusic.domain.User;
import fr.imie.appformusic.exceptions.BusinessException;

public interface IUserService {
	
	/**
	 * Trouve un utilisateur via son identifiant.
	 * @param userName 	L'identifiant de l'utilisateur.
	 * @return 			L'utilisateur recherché.
	 * @throws BusinessException
	 */
	public User findByUserName(String userName) throws BusinessException;
	
	/**
	 * Trouve un utilisateur via son identifiant.
	 * @param email L'identifiant de l'utilisateur.
	 * @return 		L'utilisateur recherché.
	 * @throws BusinessException
	 */
	public User findByEmail(String email) throws BusinessException;
	
	/**
	 * Trouve tous les utilisateurs.
	 * @return La liste de tous les utilisateurs.
	 * @throws BusinessException
	 */
	public List<User> findAllUsers() throws BusinessException;
	
	/**
	 * Crée un utilisateur.
	 * @param user L'utilisateur à créer.
	 */
	public void create(User user) throws BusinessException;
	
	/**
	 * Supprime l'utilisateur spécifié.
	 * @param user L'utilisateur à supprimer.
	 */
	public void remove(User user) throws BusinessException;
	
	/**
	 * Modifie les attributs spécifiés de l'utilisateur spécifié.
	 * @param user 			L'utilisateur à modifier.
	 * @param newUserName 	Le nouvel identifiant de l'utilisateur.
	 * @param newEmail 		La nouvelle adresse e-mail de l'utilisateur.
	 * @param newPassword	Le nouveau mot de passe de l'utilisateur.
	 * @param newFirstName 	Le nouveau prénom de l'utilisateur.
	 * @param newLastName 	Le nouveau nom de famille de l'utilisateur.
	 * @return 				L'utilisateur modifié.
	 */
	public User updateUser(
			User user, 
			String newUserName, 
			String newEmail, 
			String newPassword, 
			String newFirstName, 
			String newLastName) 
			throws BusinessException;
	
	/**
	 * Modifie l'identifiant de l'utilisateur spécifié.
	 * @param user 			L'utilisateur à modifier.
	 * @param newUserName 	Le nouvel identifiant de l'utilisateur.
	 * @return 				L'utilisateur modifié.
	 */
	public User updateUserName(User user, String newUserName) throws BusinessException;

	/**
	 * Modifie l'adresse e-mail de l'utilisateur spécifié.
	 * @param user 			L'utilisateur à modifier.
	 * @param newEmail 		La nouvelle adresse e-mail de l'utilisateur.
	 * @return 				L'utilisateur modifié.
	 */
	public User updateEmail(User user, String newEmail) throws BusinessException;

	/**
	 * Modifie le mot de passe de l'utilisateur spécifié.
	 * @param user 			L'utilisateur à modifier.
	 * @param newPassword 	Le nouveau mot de passe de l'utilisateur.
	 * @return 				L'utilisateur modifié.
	 */
	public User updatePassword(User user, String newPassword) throws BusinessException;

	/**
	 * Modifie le prénom de l'utilisateur spécifié.
	 * @param user 			L'utilisateur à modifier.
	 * @param newFirstName 	Le nouveau prénom de l'utilisateur.
	 * @return 				L'utilisateur modifié.
	 */
	public User updateFirstName(User user, String newFirstName) throws BusinessException;

	/**
	 * Modifie le nom de famille de l'utilisateur spécifié.
	 * @param user 			L'utilisateur à modifier.
	 * @param newLastName 	Le nouveau nom de famille de l'utilisateur.
	 * @return 				L'utilisateur modifié.
	 */
	public User updateLastName(User user, String newLastName) throws BusinessException;
}