package fr.imie.appformusic.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import fr.imie.appformusic.configuration.constants.Views;

public class SearchControllerTest {

	private SearchController controller = new SearchController();
	
	@Test
	public void testInit(){
		ModelAndView view = controller.init();
		assertThat(view.getViewName()).isEqualTo(Views.SEARCH);
	}
	
}
