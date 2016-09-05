package fr.imie.appformusic.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.*;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.MockType;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.servlet.ModelAndView;

import fr.imie.appformusic.configuration.constants.Routes;
import fr.imie.appformusic.configuration.constants.Views;
import fr.imie.appformusic.domain.Place;
import fr.imie.appformusic.exceptions.BusinessException;
import fr.imie.appformusic.form.PlaceForm;
import fr.imie.appformusic.service.IPlaceService;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SecurityContextHolder.class)
@PowerMockIgnore("javax.security.*")
public class PlaceControllerTest {

	@TestSubject
	private PlaceController controller = new PlaceController();
	
	@Mock(type=MockType.NICE)
	private IPlaceService serviceMock;
	
	@Mock
	private SecurityContext securContext;
	
	@Mock
	private Authentication auth;
	
	@Test
	public void testShowMyPlace(){
		Model model = new BindingAwareModelMap();
		ModelAndView mav = controller.showMyPlaces(model);
		
		assertThat(mav.getModel()).isNotNull();
		assertThat(model.containsAttribute("form")).isTrue();
	}
	
	@Test
	public void testSubmitPlaceForm() throws BusinessException{
		
		Place place = new Place();
		PlaceForm form = new PlaceForm();
		
		form.setCity("Angers");
		form.setLatitude(123456);
		form.setPublicLabel("place test");
		form.setLongitude(987654);
		form.setStreet("rue");
		form.setType("type");
		form.setZipcode("49000");
		
		PowerMock.mockStatic(SecurityContextHolder.class);
		
		// définition du mock
		expect(SecurityContextHolder.getContext()).andReturn(securContext);
		expect(securContext.getAuthentication()).andReturn(auth);
		expect(auth.getName()).andReturn("test");
		
		serviceMock.create(place);
		expectLastCall();
			
		PowerMock.replayAll(securContext,auth);
		replay(serviceMock);
		
		ModelAndView mav = controller.submitPlaceForm(form);
		
		assertThat(mav.getViewName()).isEqualTo("redirect://" + Views.PLACE);	
	}
	
}
