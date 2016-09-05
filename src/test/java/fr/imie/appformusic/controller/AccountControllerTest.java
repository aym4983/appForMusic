package fr.imie.appformusic.controller;

import static org.assertj.core.api.Assertions.assertThat;

import javax.servlet.http.HttpServletRequest;

import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.MockType;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.ui.Model;

import fr.imie.appformusic.configuration.constants.Views;
import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.exceptions.BusinessException;
import fr.imie.appformusic.form.UserForm;
import fr.imie.appformusic.service.IUserService;

@RunWith(EasyMockRunner.class)
/** Teste le contrôleur AccountController. */
public class AccountControllerTest {
	
	@TestSubject
	private AccountController accountController = new AccountController();
	@Mock(type=MockType.NICE)
	private IUserService userServiceMock;
	@Mock
	private HttpServletRequest requestMock;
	@Mock
	private Model model;
	
	/** Teste la méthode showSignUpForm. */
	@Test
	public void testShowSignUpForm() {
		assertThat(accountController.showSignUpForm(model).getViewName()).isEqualTo(Views.SIGNUP);
	}

	
	/** Teste la méthode showSignInForm. 
	 * @throws BusinessException */
	
	@Test
	public void testShowSignInForm() throws BusinessException {
		assertThat(accountController.showSignInForm(model).getViewName()).isEqualTo(Views.SIGNIN);
	}
	
	@Test
	public void testSubmitSignUpForm() throws BusinessException{
		UserForm form = new UserForm();
		form.setUsername("test");
		form.setPassword("pwd");
		form.setPasswordConfirm("pwd");
		form.setEmail("test@mail.com");
		
		AppUser user = new AppUser();
		
		userServiceMock.create(user, "pwd", "pwd");
		EasyMock.expectLastCall();
		EasyMock.replay(userServiceMock);
		
		accountController.submitSignUpForm(form);
		
	}

}
