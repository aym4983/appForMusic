package fr.imie.appformusic.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.imie.appformusic.dao.IUserDao;
import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.exceptions.BusinessException;
import fr.imie.appformusic.service.IUserService;

/*
 * Non implémenté car exemple pour test driven development
 */
@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;
	
	@Override
	public AppUser findByUserName(String userName) 
			throws BusinessException {
		// contrôles métier si nécessaire
		
		// appel de la dao
		return userDao.findByUserName(userName);
	}

	@Override
	public AppUser findByEmail(String email) throws BusinessException {
		if(StringUtils.isEmpty(email)){
			throw new BusinessException("email is empty");
		}
		return userDao.findByEmail(email);
	}
	
	@Override
	public List<AppUser> findAllUsers(){
		return userDao.findAllUsers();
	}

	@Override
	public void create(AppUser user) 
			throws BusinessException {
		userDao.create(user);
		
	}

	@Override
	public void remove(AppUser user) 
			throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AppUser updateUser(
			AppUser user, 
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
	public AppUser updateUserName(AppUser user, String newUserName)
			throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppUser updateEmail(AppUser user, String newEmail)
			throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppUser updatePassword(AppUser user, String newPassword)
			throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppUser updateFirstName(AppUser user, String newFirstName)
			throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppUser updateLastName(AppUser user, String newLastName)
			throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	
}