package fr.imie.appformusic.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.*;

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
import fr.imie.appformusic.exceptions.BusinessException;
import fr.imie.appformusic.service.IUserService;

@RunWith(EasyMockRunner.class)
/** Teste le contrôleur AccountController. */
public class AccountControllerTest {
	
	@TestSubject
	private AccountController accountController = new AccountController();
	@Mock
	private IUserService userServiceMock;
	@Mock
	private HttpServletRequest requestMock;
	
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
	public void testSubmitSignUpFormOK() throws BusinessException {
		String userName = "userName";
		String email = "email@email.com";
		String password = "password";
		String passwordConfirm = "password";
		
		AppUser user = new AppUser();
		user.setUserName(userName);
		user.setEmail(email);
		user.setPassword(password);
		
		ModelAndView mav = accountController.submitSignUpForm(user, passwordConfirm, requestMock);
		assertThat(mav.getViewName()).isEqualTo("redirect:/" + Routes.HOME);
	}
	
	/** Teste l'invalidation de la méthode submitSignUpForm. */
	@Test(expected=BusinessException.class)
	public void testSubmitSignUpFormKO() throws BusinessException {
		userServiceMock.create(null);
		expectLastCall().andThrow(new BusinessException(null));
		replay(userServiceMock);
		accountController.submitSignUpForm(null, "", requestMock);
	}

	/** Teste la validation de la méthode submitSignInForm. */
	@Test
	public void testSubmitSignInFormOK() throws BusinessException {
		AppUser user = new AppUser();
		user.setUserName("userName");
		user.setPassword("password");
		
		ModelAndView mav = accountController.submitSignInForm(user, requestMock);
		assertThat(mav.getViewName()).isEqualTo("redirect:/" + Routes.HOME);
	}

}
