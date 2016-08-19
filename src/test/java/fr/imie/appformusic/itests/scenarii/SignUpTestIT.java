package fr.imie.appformusic.itests.scenarii;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import fr.imie.appformusic.itests.pages.SignUpPage;


public class SignUpTestIT extends FluentTest {

	public WebDriver driver = getDefaultDriver();
	
	
	@Page
	private SignUpPage signUp;
	
	@Test
	  public void shouldHavePhantomJsBinary() {
	    String binary = System.getProperty("phantomjs.binary.path");
	    assertNotNull(binary);
	    assertTrue(new File(binary).exists());
	  }
	
	@Test
	public void testSignIn(){
		goTo(signUp);
		signUp.isAt();
	}

	@Override
	public WebDriver getDefaultDriver() {
		WebDriver driver = new PhantomJSDriver();
		return driver;
	}
	
	
	
}
