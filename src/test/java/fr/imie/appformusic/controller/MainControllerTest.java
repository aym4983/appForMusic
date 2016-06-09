package fr.imie.appformusic.controller;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;
import static org.junit.Assert.*;

public class MainControllerTest {

	private MainController controller = new MainController();
	
	@Test
	public void testInit(){
		ModelAndView path = controller.init();
		assertEquals("main", path.getViewName());
	}
	
}
