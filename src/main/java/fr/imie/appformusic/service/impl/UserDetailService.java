package fr.imie.appformusic.service.impl;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.imie.appformusic.configuration.constants.Session;
import fr.imie.appformusic.dao.IUserDao;
import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.domain.Role;

@Service
public class UserDetailService implements UserDetailsService {

	@Autowired
	private IUserDao userDao;
	
	HttpServletRequest request;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser appUser = userDao.findByUserName(username);
		
		Set<GrantedAuthority> grantedAuthority = new HashSet<>();
		for (Role role : appUser.getRoles()){
			grantedAuthority.add(new SimpleGrantedAuthority(role.getLabel()));
		}
		User user = new User(appUser.getUsername(), appUser.getPasswordHash(),grantedAuthority);
		
		//HttpSession session = request.getSession();
		//session.setAttribute(Session.CURRENT_NAME, appUser.getUsername());
		
		return user;
	}

}
