package fr.imie.appformusic.itests.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fr.imie.support.Browser;
import fr.imie.support.BrowserFactory;
import fr.imie.support.BrowserSize;

@RunWith(value=Parameterized.class)
public abstract class MultbrowserTests extends BaseTest {

	/**
	 * constante de la property indiquant les navigateurs à lancer
	 */
	private static final String BROWSERS_PROPERTY = "browsers";
	
	/**
	 * nom du fichier de valeurs par défaut de la property BROWSERS_PROPERTY
	 */
	private static final String DEFAULT_BROWSERS_PROPERTIES = "default-browsers.properties";
	
	private static final Logger LOG = Logger.getLogger(BrowserFactory.class);
	
	public MultbrowserTests(Browser browser, BrowserSize size){
		super(browser, size);
	}
	
	@Parameters(name = "{0}_{1}")
	public static Collection<Object[]> data() {
		
		Browser[] browsers = new Browser[] {Browser.Phantom};
		
		String browsersName = System.getProperty(BROWSERS_PROPERTY);
		if(browsersName == null){
			LOG.trace("Propriétés de test lues depuis "+ DEFAULT_BROWSERS_PROPERTIES);
			
			Properties prop = new Properties();
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(DEFAULT_BROWSERS_PROPERTIES);
			if(is != null){
				try {
					prop.load(is);
					browsersName = prop.getProperty(BROWSERS_PROPERTY);
				} catch(IOException e){
					LOG.error("Echec du chargement de "+DEFAULT_BROWSERS_PROPERTIES, e);
				} 
			} else {
				LOG.info("pas de fichier de propriétés "+DEFAULT_BROWSERS_PROPERTIES+" dans le classPath");
			}
		}
		
		/// on stocke les navigateurs
		if (browsersName != null){
			String[] names = browsersName.split(",");
			
			browsers = new Browser[names.length];
			
			for(int i=0; i < names.length; i++){
				browsers[i] = Browser.valueOf(names[i]);
			}
		}
		
		// et on boucle sur le tableau de navigateurs
		List<Object[]> params = new ArrayList<>();
		for (Browser browser : browsers){
			params.add(new Object []{browser, BrowserSize.PC});
		}
		
		return params;
		
	}
	
}
