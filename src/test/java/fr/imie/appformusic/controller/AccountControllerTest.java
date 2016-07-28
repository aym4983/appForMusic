package fr.imie.appformusic.controller;

import static org.assertj.core.api.Assertions.assertThat;

import javax.servlet.http.HttpServletRequest;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.web.servlet.ModelAndView;

import fr.imie.appformusic.configuration.constants.Routes;
import fr.imie.appformusic.configuration.constants.Views;
import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.service.IUserService;

@RunWith(EasyMockRunner.class)
/** Teste le contrôleur AccountController. */
public class AccountControllerTest {
	
	@TestSubject
	private AccountController accountController = new AccountController();
	@Mock
	private IUserService userServiceMock;
	@Mock
	private HttpServletRequest request;
	
	/** Teste la méthode showSignUpForm. */
	@Test
	public void testShowSignUpForm() {
		assertThat(accountController.showSignUpForm().getViewName()).isEqualTo(Views.SIGNUP);
	}

	/** Teste la méthode showSignInForm. */
	@Test
	public void testShowSignInForm() {
		assertThat(accountController.showSignInForm().getViewName()).isEqualTo(Views.SIGNIN);
	}

	/** Teste la validation de la méthode submitSignUpForm. */
	@Test
	public void testSubmitSignUpFormOK() {
		String userName = "userName";
		String email = "email@email.com";
		String password = "password";
		String passwordConfirm = "password";
		
		AppUser user = new AppUser();
		user.setUserName(userName);
		user.setEmail(email);
		user.setPassword(password);
		
		ModelAndView mav = accountController.submitSignUpForm(user, passwordConfirm, request);
		assertThat(mav.getViewName()).isEqualTo("redirect:/" + Routes.HOME);
	}
	
	/** Teste l'invalidation de la méthode submitSignUpForm. */
	@Test
	public void testSubmitSignUpFormKO() {
		String userName = "userName";
		String email = "email@email.com";
		String password = "password";
		String passwordConfirm = "password";
		
		AppUser user = new AppUser();
		user.setUserName(userName);
		user.setEmail(email);
		user.setPassword(password);
		
		ModelAndView mav = accountController.submitSignUpForm(user, passwordConfirm, request);
		assertThat(mav.getViewName()).isEqualTo("redirect:/" + Routes.HOME);
	}

	/** Teste la méthode submitSignInForm. */
	@Test
	public void testSubmitSignInForm() {
		
	}

}
