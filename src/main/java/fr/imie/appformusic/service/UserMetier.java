package fr.imie.appformusic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.imie.appformusic.dao.UserDao;
import fr.imie.appformusic.domain.User;
import fr.imie.appformusic.exceptions.BusinessException;

/*
 * Non implémenté car exemple pour test driven development
 */
@Service
public class UserMetier {

	@Autowired
	private UserDao userDao;
	
	public User findUserById(int userId) throws BusinessException{
		// contrôles métier si nécessaire
		
		// appel de la dao
		return userDao.findUserById(userId);
	}
	
	public List<User> findAllUsers(){
		return userDao.findAllUsers();
	}
	
}
