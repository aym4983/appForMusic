package fr.imie.appformusic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.imie.appformusic.dao.IUserDao;
import fr.imie.appformusic.domain.User;
import fr.imie.appformusic.exceptions.BusinessException;

/*
 * Non implémenté car exemple pour test driven development
 */
@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	public User findByUserName(String userName) throws BusinessException{
		// contrôles métier si nécessaire
		
		// appel de la dao
		return userDao.findByUserName(userName);
	}
	
	public List<User> findAllUsers(){
		return userDao.findAllUsers();
	}

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		
	}
	
}
