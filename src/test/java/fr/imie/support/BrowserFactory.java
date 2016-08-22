package fr.imie.support;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import fr.imie.support.exception.ConfigurationRuntimeException;
import fr.imie.support.impl.WebDriverFactory;

public final class BrowserFactory {

	private static final Logger LOG = Logger.getLogger(BrowserFactory.class);
	
	/**
	 * instance de la factory
	 */
	private static final BrowserFactory INSTANCE = new BrowserFactory();
	
	private BrowserFactory(){
		init();
	}
	
	private void init(){
		OSData osdata = new OSData();
		String name = null;
		if(osdata.isWindows()){
			name="windows";
		} else if(osdata.isLinux() && osdata.isArch64bits()){
			name="linux";
		} else if(osdata.isLinux() && !osdata.isArch64bits()){
			name="linux32";
		} else {
			String message = new StringBuilder("OS non géré : ").append(System.getProperty("os.name")).toString();
			throw new UnsupportedOperationException(message);
		}
		name = name.concat("-default-webdriver.properties");
		
		Properties prop = new Properties();
		java.io.InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(name);
		if(is != null){
			try {
				prop.load(is);
				// parcours des properties chargées, et si on ne touve pas de property déjà
				// définie (et venant donc d'un -D, on affecte la valeur par défaut issue du
				// fichier de propriétés
				for(String key : prop.stringPropertyNames()){
					if(System.getProperty(key) == null){
						System.setProperty(key, prop.getProperty(key));
					}
				}
			} catch (IOException e){
				LOG.error("Echec du chargement de "+name, e);
			}
		} else {
			LOG.info("pas de fichier de propriétés "+name+" dans le classpath");
		}
	}
	
	public static BrowserFactory getIinstance(){
		return INSTANCE;
	}
	
	public WebDriver getDriver (Browser browser, BrowserSize size){
		try {
			WebDriverFactory driverFactory = (WebDriverFactory) Class.forName(browser.getClassName()).newInstance();
			return driverFactory.getDriver(size);
		} catch (Exception e){
			LOG.error("Echec acquisition webdriver factory pour "+browser.getClassName(), e);
			throw new ConfigurationRuntimeException("Exception durant acquisition driver", e);
			
		}
	}
	
}
