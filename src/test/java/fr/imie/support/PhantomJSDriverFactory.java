package fr.imie.support;

import java.io.File;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import fr.imie.support.constante.WebDriverProperties;
import fr.imie.support.exception.ConfigurationRuntimeException;
import fr.imie.support.impl.WebDriverFactory;

public class PhantomJSDriverFactory implements WebDriverFactory {

	private static final Logger LOG = Logger.getLogger(PhantomJSDriverFactory.class);
	
	@Override
	public WebDriver getDriver(BrowserSize size) {
		String phantomPath = System.getProperty(WebDriverProperties.PHANTOMJS_BINARY_PATH);
		
		if(phantomPath == null){
			String systemPath = System.getenv("PATH");
			
			if(systemPath != null && systemPath.contains("phantomjs")){
				phantomPath = "Exécutable issu du PATH";
			} else {
				LOG.error("Impossible de trouver phantomJs dans le PATH");
				throw new ConfigurationRuntimeException("Impossible de trouver phantomJs dans le PATH");
			}
		}
		
		File execPath = new File(phantomPath);
		if(!execPath.canExecute()){
			LOG.error("Impossible d'exécuter "+execPath.getAbsolutePath());
			throw new ConfigurationRuntimeException("Impossible d'exécuter "+execPath.getAbsolutePath());
		}
		LOG.info("phantomJs driver path=" + phantomPath);
		
		WebDriver driver = new PhantomJSDriver();
		driver.manage().window().setSize(new Dimension(size.getWidth(), size.getHeight()));
		driver.manage().window().setPosition(new Point(0, 0));
		return driver;
	}

}
