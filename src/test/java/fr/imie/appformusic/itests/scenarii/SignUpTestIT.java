package fr.imie.appformusic.itests.scenarii;

import org.fluentlenium.core.annotation.Page;
import org.junit.Test;

import fr.imie.appformusic.itests.pages.SignInPage;
import fr.imie.appformusic.itests.pages.SignUpPage;
import fr.imie.appformusic.itests.utils.AppForMusicPageTest;
import fr.imie.support.Browser;
import fr.imie.support.BrowserSize;


public class SignUpTestIT extends AppForMusicPageTest {

	public SignUpTestIT(Browser browser, BrowserSize size) {
		super(browser, size);
	}
	
	@Page
	private SignUpPage signUp;
	@Page
	private SignInPage signIn;
	
	@Test
	public void testSignIn(){
		goTo(signUp);
		signUp.isAt();
		
		signUp.setUsername("toto");
		signUp.setEmail("toto@test.com");
		signUp.setPassword("toto");
		signUp.setPasswordConfirm("toto");
		signUp.submitForm();
		
		// on vérifie que l'on arrive bien sur la page signIn
		signIn.isAt();
	}
}
