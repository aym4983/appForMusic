package fr.imie.appformusic.service;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import fr.imie.appformusic.dao.IUserDao;
import fr.imie.appformusic.domain.User;
import fr.imie.appformusic.exceptions.BusinessException;

@RunWith(EasyMockRunner.class)
public class UserMetierTest {

	@Mock
	private IUserDao daoMock;
	
	@TestSubject
	private UserMetier service = new UserMetier();
	
	@Test
	public void testFindUserByIdOk() throws BusinessException{
		User user = new User();
		user.setEmail("user@mail.com");
		user.setPassword("userpass");
		
		expect(daoMock.findByUserName(user.getUserName())).andReturn(user);
		replay(daoMock);
		
		User userResult = service.findByUserName(user.getUserName());
		assertEquals(userResult.getUserName(), user.getUserName());
	}
	
	@Test
	public void testFindAllUsersOk(){
		/*List<User> userList = new ArrayList<>();
		
		for (int i=0; i<5; i++){
			User u = new User();
			u.setId(i);
			userList.add(u);
		}
		
		expect(daoMock.findAllUsers()).andReturn(userList);
		replay(daoMock);
		
		List<User> result = service.findAllUsers();
		
		assertEquals(result.size(), 5);
		assertEquals(result.get(1).getId(), 1);*/
	}
	
}
