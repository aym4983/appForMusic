package fr.imie.appformusic.itests.scenarii;

import org.fluentlenium.core.annotation.Page;
import org.junit.Test;

import fr.imie.appformusic.configuration.constants.Routes;
import fr.imie.appformusic.itests.pages.SignInPage;
import fr.imie.appformusic.itests.pages.SignUpPage;
import fr.imie.appformusic.itests.utils.AppForMusicPageTest;

public class SignUpIT extends AppForMusicPageTest {

	@Page
	private SignUpPage signUp;
	@Page
	private SignInPage signIn;
	
	@Test
	public void testSignIn(){
		goTo(getBaseUrl()+Routes.SIGNUP);
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
