package fr.imie.appformusic.controller;

import static org.easymock.EasyMock.*;
import static org.assertj.core.api.Assertions.*;

import org.easymock.Mock;
import org.easymock.MockType;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.servlet.ModelAndView;

import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.service.IUserService;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SecurityContextHolder.class)
@PowerMockIgnore("javax.security.*")
public class ProfileControllerTest {

	@TestSubject
	private ProfileController controller = new ProfileController();
	
	@Mock(type=MockType.NICE)
	private SecurityContext securContextMock;
	
	@Mock(type=MockType.NICE)
	private Authentication authMock;
	
	@Mock(type=MockType.NICE)
	private IUserService serviceMock;
	
	@Test
	public void testShowUserProfile() throws Exception {
		BindingAwareModelMap model = new BindingAwareModelMap();
		String username = "test";
		AppUser user = new AppUser();
		user.setUsername(username);
		
		// comportement des mocks
		PowerMock.mockStatic(SecurityContextHolder.class);
		expect(SecurityContextHolder.getContext()).andReturn(securContextMock);
		expect(securContextMock.getAuthentication()).andReturn(authMock);
		expect(serviceMock.findByUserName(username)).andReturn(user);
		expect(authMock.getName()).andReturn(username);
		PowerMock.replayAll(securContextMock, authMock, serviceMock);
		
		ModelAndView mav = controller.showUserProfile(model, username);
		assertThat(model.get("user")).isEqualTo(user);
		assertThat(mav.getViewName()).isEqualTo("profile");
		
	}

	@Test
	public void testUpdateMyProfile() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

}
