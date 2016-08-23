package fr.imie.support;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import fr.imie.support.constante.WebDriverProperties;
import fr.imie.support.impl.WebDriverFactory;

public class ChromeDriverFactory implements WebDriverFactory {

	@Override
	public WebDriver getDriver(BrowserSize size) {
		String chromePath = System.getProperty(WebDriverProperties.CHROMEDRIVER_PATH);
		if (chromePath != null){
			System.setProperty(WebDriverProperties.WEBDRIVER_CHROME_DRIVER, chromePath);
		}
		
		// driver chrome
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(size.getWidth(), size.getHeight()));
		driver.manage().window().setPosition(new Point(0, 0));
		return driver;
	}

}
