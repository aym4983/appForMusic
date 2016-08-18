package fr.imie.appformusic.service.impl;

import static org.easymock.EasyMock.*;
import static org.assertj.core.api.Assertions.*;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import fr.imie.appformusic.dao.IUserDao;
import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.exceptions.BusinessException;

@RunWith(EasyMockRunner.class)
public class UserServiceTest {

	private final String EMAIL = "email";
	
	@Mock
	private IUserDao daoMock;
	
	@TestSubject
	private UserService service = new UserService();
	
	@Test
	public void testFindByEmail() throws BusinessException{
		
		AppUser user = createAppUser();

		expect(daoMock.findByEmail(EMAIL)).andReturn(user);
		replay(daoMock);
		
		AppUser userResult = service.findByEmail(EMAIL);
		assertThat(userResult.getUsername()).isEqualTo(user.getUsername());
		
	}
	
	@Test(expected=BusinessException.class)
	public void testFindByEmailKo() throws BusinessException {
		AppUser user = createAppUser();
		
		expect(daoMock.findByEmail(EMAIL)).andReturn(user);
		replay(daoMock);
		
		service.findByEmail("");
	}
	
	private AppUser createAppUser(){
		AppUser user = new AppUser();
		user.setEmail(EMAIL);
		user.setUsername("user");
		user.setPasswordHash("password");
		return user;
	}
	
}
