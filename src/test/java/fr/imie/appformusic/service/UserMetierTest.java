package fr.imie.appformusic.service;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import fr.imie.appformusic.dao.UserDao;
import fr.imie.appformusic.domain.User;
import fr.imie.appformusic.exceptions.BusinessException;

@RunWith(EasyMockRunner.class)
public class UserMetierTest {

	@Mock
	private UserDao daoMock;
	
	@TestSubject
	private UserMetier service = new UserMetier();
	
	@Test
	public void testFindUserByIdOk() throws BusinessException{
		User user = new User();
		user.setId(1);
		user.setName("test");
		user.setEmail("user@mail.com");
		user.setPassword("userpass");
		
		expect(daoMock.findUserById(user.getId())).andReturn(user);
		replay(daoMock);
		
		User userResult = service.findUserById(user.getId());
		assertEquals(userResult.getName(), user.getName());
	}
	
}
