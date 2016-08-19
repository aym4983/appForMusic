package fr.imie.appformusic.itests.scenarii;

import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import fr.imie.appformusic.itests.pages.SignUpPage;

public class SignUpTest extends FluentTest {

	private WebDriver driver = getDriver();
	
	
	@Page
	private SignUpPage signUp;
	
	@Test
	public void testSignIn(){
		goTo(signUp);
		signUp.isAt();
	}

	@Override
	public WebDriver getDefaultDriver() {
		System.setProperty("webdriver.chrome.driver", "C:/PROGRAMJAVA/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
	
	
}
