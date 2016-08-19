package fr.imie.appformusic.itests.scenarii;

import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import fr.imie.appformusic.itests.pages.SignUpPage;

/** Garder l'annotation ignore pour l'instant, sinon çà va planter fort !! */

@Ignore
public class SignUpTest extends FluentTest {

	private WebDriver driver = getDefaultDriver();
	
	
	@Page
	private SignUpPage signUp;
	
	@Test
	public void testSignIn(){
		goTo(signUp);
		signUp.isAt();
	}

	@Override
	public WebDriver getDefaultDriver() {
		//System.setProperty("webdriver.chrome.driver", "C:/PROGRAMJAVA/chromedriver.exe");
		WebDriver driver = new PhantomJSDriver();
		return driver;
	}
	
	
	
}
