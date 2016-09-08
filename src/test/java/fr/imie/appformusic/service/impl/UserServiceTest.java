package fr.imie.appformusic.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import fr.imie.appformusic.dao.IRoleDao;
import fr.imie.appformusic.dao.IUserDao;
import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.domain.Role;
import fr.imie.appformusic.exceptions.BusinessException;

@RunWith(EasyMockRunner.class)
public class UserServiceTest {

	private final String EMAIL = "email";
	private final String USERNAME = "username";
	private final String PASS = "@test-pass";
	private final String PASS_CONFIRM = "@test-pass";
	private final String ROLE_LABEL = "user";

	@Mock
	private IUserDao userDaoMock;
	@Mock
	private IRoleDao roleDaoMock;
	
	@TestSubject
	private UserService service = new UserService();
	
	@Test
	public void testCreate() throws BusinessException {
		AppUser user = createAppUser();
		Role role = createRole();
		String password = PASS;
		String confirmPassword = PASS_CONFIRM;
		
		userDaoMock.create(user);
		expectLastCall();
		
		expect(roleDaoMock.findByLabel(ROLE_LABEL)).andReturn(role);
		
		replay(userDaoMock, roleDaoMock);
		
		service.create(user, password, confirmPassword);
	}
	
	@Test(expected=BusinessException.class)
	public void testCreateKo() throws BusinessException {
		AppUser user = createAppUser();
		String password = PASS;
		String confirmPassword = "bad";
		
		service.create(user, password, confirmPassword);
	}
	
	@Test
	public void testFindByEmail() throws BusinessException{
		AppUser user = createAppUser();

		expect(userDaoMock.findByEmail(EMAIL)).andReturn(user);
		replay(userDaoMock);
		
		AppUser userResult = service.findByEmail(EMAIL);
		assertThat(userResult.getUsername()).isEqualTo(user.getUsername());
	}
	
	@Test(expected=BusinessException.class)
	public void testFindByEmailKo() throws BusinessException {
		AppUser user = createAppUser();
		
		expect(userDaoMock.findByEmail(EMAIL)).andReturn(user);
		replay(userDaoMock);
		
		service.findByEmail("");
	}
	
	private AppUser createAppUser(){
		AppUser user = new AppUser();
		user.setEmail(EMAIL);
		user.setUsername(USERNAME);
		user.setPasswordHash(PASS);
		return user;
	}
	
	private Role createRole() {
		Role role = new Role();
		role.setLabel(ROLE_LABEL);
		return role;
	}
	
}
