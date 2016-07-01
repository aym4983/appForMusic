package fr.imie.appformusic.controller;

import static org.assertj.core.api.Assertions.*;

import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import fr.imie.appformusic.service.IUserService;

public class AccountControllerTest {
	
	@Mock
	private IUserService userServiceMock;
	
	@TestSubject
	private AccountController controller = new AccountController();
	
	@Test
	public void testSignUpForm() {
		ModelAndView mav = controller.signUpForm();
		assertThat(mav.getViewName()).contains("sign-up");
	}
	
	@Test
	public void testSignUpSubmit(){
		
	}

}
