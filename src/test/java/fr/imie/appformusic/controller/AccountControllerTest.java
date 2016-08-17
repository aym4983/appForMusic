package fr.imie.appformusic.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import fr.imie.appformusic.configuration.constants.Routes;
import fr.imie.appformusic.configuration.constants.Views;
import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.exceptions.BusinessException;
import fr.imie.appformusic.exceptions.BusinessException.Code;
import fr.imie.appformusic.form.UserForm;
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
	@Mock
	private Model model;
	
	/** Teste la méthode showSignUpForm. */
	@Test
	public void testShowSignUpForm() {
		assertThat(accountController.showSignUpForm(model).getViewName()).isEqualTo(Views.SIGNUP);
	}

	/** Teste la méthode showSignInForm. */
	@Test
	public void testShowSignInForm() {
		assertThat(accountController.showSignInForm(model).getViewName()).isEqualTo(Views.SIGNIN);
	}

}
