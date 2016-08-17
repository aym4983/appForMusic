package fr.imie.appformusic.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.hsqldb.rights.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.imie.appformusic.dao.IRoleDao;
import fr.imie.appformusic.dao.IUserDao;
import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.domain.Role;
import fr.imie.appformusic.exceptions.BusinessException;
import fr.imie.appformusic.service.IUserService;

@Service
@Transactional
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Autowired
	private IRoleDao roleDao;

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public void create(AppUser user, String password, String confirmPassword) 
			throws BusinessException {
		if (password.equals(confirmPassword)) {
			BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
			
			Set<Role> roles = new HashSet<Role>();
			roles.add(roleDao.findByLabel("user"));
			
			user.setPasswordHash(passEncoder.encode(password));
			user.setRoles(roles);
			user.setEnabled(true);
			
			userDao.create(user);
		} else {
			throw new BusinessException(BusinessException.Code.DIFFERENT_PASSWORDS);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public AppUser findByUserName(String userName) 
			throws BusinessException {
		// contrôles métier si nécessaire
		
		// appel de la dao
		return userDao.findByUserName(userName);
	}

	@Override
	@Transactional(readOnly = true)
	public AppUser findByEmail(String email) throws BusinessException {
		if(StringUtils.isEmpty(email)){
			throw new BusinessException(BusinessException.Code.EMAIL_EMPTY);
		}
		return userDao.findByEmail(email);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<AppUser> findAllUsers(){
		return userDao.findAllUsers();
	}

	@Override
	@Transactional(readOnly = true)
	public List<AppUser> findUsersLike(String username) throws BusinessException {
		return userDao.findUsersLike(username);
	}

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public void remove(AppUser user) 
			throws BusinessException {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(rollbackFor = Throwable.class)
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
	@Transactional(rollbackFor = Throwable.class)
	public AppUser updateUserName(AppUser user, String newUserName)
			throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public AppUser updateEmail(AppUser user, String newEmail)
			throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public AppUser updatePassword(AppUser user, String newPassword)
			throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public AppUser updateFirstName(AppUser user, String newFirstName)
			throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(rollbackFor = Throwable.class)
	public AppUser updateLastName(AppUser user, String newLastName)
			throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}


}
