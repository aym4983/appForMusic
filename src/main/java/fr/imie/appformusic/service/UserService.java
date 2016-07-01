package fr.imie.appformusic.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.imie.appformusic.dao.IUserDao;
import fr.imie.appformusic.domain.User;
import fr.imie.appformusic.exceptions.BusinessException;

/*
 * Non implémenté car exemple pour test driven development
 */
@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	@Override
	public User findByUserName(String userName) 
			throws BusinessException {
		// contrôles métier si nécessaire
		
		// appel de la dao
		return userDao.findByUserName(userName);
	}

	@Override
	public User findByEmail(String email) throws BusinessException {
		if(StringUtils.isEmpty(email)){
			throw new BusinessException("email is empty");
		}
		return userDao.findByEmail(email);
	}
	
	@Override
	public List<User> findAllUsers(){
		return userDao.findAllUsers();
	}

	@Override
	public void create(User user) 
			throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(User user) 
			throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User updateUser(
			User user, 
			String newUserName, 
			String newEmail,
			String newPassword, 
			String newFirstName, 
			String newLastName)
			throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUserName(User user, String newUserName)
			throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateEmail(User user, String newEmail)
			throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updatePassword(User user, String newPassword)
			throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateFirstName(User user, String newFirstName)
			throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateLastName(User user, String newLastName)
			throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
