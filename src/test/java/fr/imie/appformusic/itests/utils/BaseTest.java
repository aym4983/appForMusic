package fr.imie.appformusic.itests.utils;

import org.fluentlenium.adapter.FluentTest;
import org.openqa.selenium.WebDriver;

import fr.imie.support.Browser;
import fr.imie.support.BrowserFactory;
import fr.imie.support.BrowserSize;

public abstract class BaseTest extends FluentTest {

	/**
	 * Navigateur en cours d'utilisation pour les tests
	 */
	private final Browser browser;
	private final BrowserSize size;
	
	public BaseTest(Browser browser, BrowserSize size){
		super();
		this.browser = browser;
		this.size = size;
	}
	
	@Override
	public WebDriver getDefaultDriver() {
		return BrowserFactory.getIinstance().getDriver(browser, size);
	}

	public Browser getBrowser(){
		return browser;
	}
	
}
