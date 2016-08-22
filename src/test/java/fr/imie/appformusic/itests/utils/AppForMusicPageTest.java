package fr.imie.appformusic.itests.utils;

import org.fluentlenium.core.annotation.Page;

import fr.imie.appformusic.itests.pages.HomePage;
import fr.imie.support.Browser;
import fr.imie.support.BrowserSize;

public class AppForMusicPageTest extends MultbrowserTests {

	public AppForMusicPageTest(Browser browser, BrowserSize size){
		super(browser, size);
	}
	
	@Page
	protected HomePage page;
	
}
