package fr.imie.appformusic.service;

import java.util.List;

import fr.imie.appformusic.domain.User;
import fr.imie.appformusic.exceptions.BusinessException;

public interface IUserService {
	/**
	 * Trouve un utilisateur via son identifiant.
	 * @param userName L'identifiant de l'utilisateur.
	 * @return L'utilisateur correspondant à l'identifiant spécifié.
	 * @throws BusinessException
	 */
	public User findByUserName(String userName) throws BusinessException;
	/**
	 * Trouve tous les utilisateurs.
	 * @return La liste de tous les utilisateurs.
	 */
	public List<User> findAllUsers();
	public void add(User user);
}
