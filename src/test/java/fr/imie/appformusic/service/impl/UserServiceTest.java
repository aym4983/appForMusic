package fr.imie.appformusic.service.impl;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import fr.imie.appformusic.dao.IUserDao;

@RunWith(EasyMockRunner.class)
public class UserServiceTest {

	@Mock
	private IUserDao daoMock;
	
	@TestSubject
	private UserService service = new UserService();
	
	@Test
	public void testLoadUserByUsername() throws Exception {
		
//		// Création d'un AppUser
//		AppUser user = new AppUser();
//		UserRole role = new UserRole();
//		Role roletab = new Role("1","admin");
//		
//		Set<UserRole> roles = new HashSet<>();
//		user.setUsers(roles);
//		user.getRoles().add(role);
//		user.setUsername("toto");
//		user.setPasswordHash("passwd");
//		user.setEnabled(true);
//
//		role.setUser(user);
//		role.setRole(roletab);
//
//
//		// comportement du mock
//		expect(daoMock.findByUserName("toto")).andReturn(user);
//		replay(daoMock);
//		
//		UserDetails details = service.loadUserByUsername("toto");
//		assertThat(details.getUsername()).isEqualTo("toto");
//		assertThat(details.isEnabled()).isEqualTo(true);
		
	}

}
