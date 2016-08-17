package fr.imie.appformusic.service.impl;

import static org.assertj.core.api.Assertions.*;
import static org.easymock.EasyMock.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import fr.imie.appformusic.dao.IUserDao;
import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.domain.Role;
import fr.imie.appformusic.domain.UserRole;

@RunWith(EasyMockRunner.class)
public class UserServiceTest {

	@Mock
	private IUserDao daoMock;
	
	@TestSubject
	private UserService service = new UserService();
	
	@Test
	public void testLoadUserByUsername() throws Exception {
		
		// Création d'un AppUser
		AppUser user = new AppUser();
		UserRole role = new UserRole();
		Role roletab = new Role("1","admin");
		
		Set<UserRole> roles = new HashSet<>();
		user.setRoles(roles);
		user.getRoles().add(role);
		user.setUsername("toto");
		user.setPasswordHash("passwd");
		user.setEnabled(true);
		
		role.setUser(user);
		role.setRole(roletab);

		// comportement du mock
		expect(daoMock.findByUserName("toto")).andReturn(user);
		replay(daoMock);
		
		UserDetails details = service.loadUserByUsername("toto");
		assertThat(details.getUsername()).isEqualTo("toto");
		assertThat(details.isEnabled()).isEqualTo(true);
		
	}

}
