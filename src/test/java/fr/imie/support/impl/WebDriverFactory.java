package fr.imie.support.impl;

import org.openqa.selenium.WebDriver;

import fr.imie.support.BrowserSize;

public interface WebDriverFactory {

	WebDriver getDriver(final BrowserSize size);
	
}
