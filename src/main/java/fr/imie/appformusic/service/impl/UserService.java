package fr.imie.appformusic.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.imie.appformusic.dao.IUserDao;
import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.domain.Role;
import fr.imie.appformusic.exceptions.BusinessException;
import fr.imie.appformusic.service.IUserService;

/*
 * Non implémenté car exemple pour test driven development
 */
@Service
@Transactional
public class UserService implements IUserService, UserDetailsService {

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
			throw new BusinessException(BusinessException.Code.EMAIL_EMPTY);
		}
		return userDao.findByEmail(email);
	}
	
	@Override
	public List<AppUser> findAllUsers(){
		return userDao.findAllUsers();
	}

	@Override
	public List<AppUser> findUsersLike(String username) throws BusinessException {
		return userDao.findUsersLike(username);
	}

	@Override
	public void create(AppUser user, String password, String confirmPassword) 
			throws BusinessException {
		if (password.equals(confirmPassword)) {
			BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
			user.setPasswordHash(passEncoder.encode(password));
			userDao.create(user);
		} else {
			throw new BusinessException(BusinessException.Code.DIFFERENT_PASSWORDS);
		}
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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user = userDao.findByUserName(username);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());
		
		return buildUserForAuthentication(user, authorities);
	}
	
	// Converts AppUser user to
		// org.springframework.security.core.userdetails.User
		protected User buildUserForAuthentication(AppUser user, 
			List<GrantedAuthority> authorities) {
			return new User(user.getUsername(), user.getPasswordHash(), 
				user.isEnabled(), true, true, true, authorities);
		}
	
	protected List<GrantedAuthority> buildUserAuthority(Set<Role> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (Role role : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(role.getLabel()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}
	
}
