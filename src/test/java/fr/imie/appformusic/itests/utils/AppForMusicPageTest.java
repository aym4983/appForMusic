package fr.imie.appformusic.itests.utils;

import org.fluentlenium.adapter.FluentTest;
import org.fluentlenium.core.annotation.Page;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.ActiveProfiles

import fr.imie.appformusic.itests.pages.HomePage;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class AppForMusicPageTest extends FluentTest {

	@Value("${local.server.port}")
	private int port;
	
	@Value("${browsers}")
	private String browser;
	
	@Value("${phantomjs.path")
	private String phantomJsPath;
	
	private WebDriver webDriver;
	
	@Page
	protected HomePage page;

	public AppForMusicPageTest(){
		super();
	}
	
	@Override
	public WebDriver getDefaultDriver() {
		if (browser.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "C:/PROGRAMJAVA/chromedriver.exe");
			webDriver = new ChromeDriver();
		}
		else {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(
					PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, 
					System.getProperty("phantomjs.binary.path"));
			webDriver = new PhantomJSDriver(caps);
		}
		
		return webDriver;
	}

	@Override
	public String getDefaultBaseUrl() {
		return "http://localhost:" + port + "/appForMusic";
	}
	
	

	
}
