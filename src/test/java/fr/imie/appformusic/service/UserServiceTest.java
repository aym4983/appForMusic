package fr.imie.appformusic.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import fr.imie.appformusic.dao.IUserDao;
import fr.imie.appformusic.domain.User;
import fr.imie.appformusic.exceptions.BusinessException;

@RunWith(EasyMockRunner.class)
public class UserServiceTest {

	@Mock
	private IUserDao daoMock;
	
	@TestSubject
	private IUserService service = new UserService();
	
	@Test
	public void testFindUserByIdOk() throws BusinessException {
		User user = new User();
		user.setEmail("user@mail.com");
		user.setPassword("userpass");
		
		expect(daoMock.findByUserName(user.getUserName())).andReturn(user);
		replay(daoMock);
		
		User userResult = service.findByUserName(user.getUserName());
		assertEquals(userResult.getUserName(), user.getUserName());
	}
	
	@Test
	public void testFindAllUsersOk() throws BusinessException {
		List<User> userList = new ArrayList<>();
		
		for (int i=0; i<5; i++){
			User u = new User();
			u.setUserName("user_" + i);
			userList.add(u);
		}
		
		expect(daoMock.findAllUsers()).andReturn(userList);
		replay(daoMock);
		
		List<User> result = service.findAllUsers();
		
		assertThat(result).isNotNull();
		assertThat(result.size()).isEqualTo(5);
		assertThat(result.get(1).getUserName()).contains("user_1");
	}
	
}
