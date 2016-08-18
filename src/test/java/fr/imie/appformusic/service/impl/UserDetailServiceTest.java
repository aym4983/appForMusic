package fr.imie.appformusic.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

import java.util.HashSet;
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

@RunWith(EasyMockRunner.class)
public class UserDetailServiceTest {

	@Mock
	private IUserDao daoMock;
	
	@TestSubject
	private UserDetailService service = new UserDetailService();
	
	@Test
	public void testLoadUserByUsername(){
		
		Set<Role> roles = new HashSet<>();
		Role role = new Role();
		role.setLabel("user");
		role.setId(new Byte("1"));
		roles.add(role);
		
		AppUser appUser = new AppUser();
		appUser.setUsername("toto");
		appUser.setPasswordHash("password");
		appUser.setRoles(roles);
		
		expect(daoMock.findByUserName("toto")).andReturn(appUser);
		replay(daoMock);
		
		UserDetails user = service.loadUserByUsername("toto");
		
		assertThat(user.getUsername()).isEqualTo("toto");
		assertThat(user.getAuthorities()).isNotEmpty();
		
		for (GrantedAuthority auth : user.getAuthorities()){
			assertThat(auth.getAuthority()).isEqualTo("user");
		}
		
	}
	
}
