package fr.imie.appformusic.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.replay;

import java.util.ArrayList;
import java.util.List;

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
import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.domain.Place;
import fr.imie.appformusic.exceptions.BusinessException;
import fr.imie.appformusic.form.PlaceForm;
import fr.imie.appformusic.service.IPlaceService;
import fr.imie.appformusic.service.IUserService;

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
	
	@Mock(type=MockType.NICE)
	private IUserService userServiceMock;
	@Test
	public void testShowMyPlace() throws BusinessException{
		Model model = new BindingAwareModelMap();
		
		AppUser user = new AppUser();
		user.setUsername("test");
		List<Place> places = new ArrayList<>();
		Place place = new Place();
		places.add(place);
		
		// comportement des mocks
		PowerMock.mockStatic(SecurityContextHolder.class);
		expect(SecurityContextHolder.getContext()).andReturn(securContext);
		expect(securContext.getAuthentication()).andReturn(auth);
		expect(auth.getName()).andReturn("test");
		expect(userServiceMock.findByUserName("test")).andReturn(user);
		expect(serviceMock.findUserPlaces(user)).andReturn(places);
		
		PowerMock.replayAll(securContext, auth, userServiceMock, serviceMock);
		
		ModelAndView mav = controller.showMyPlaces(model);
		
		assertThat(mav.getModel()).isNotNull();
		assertThat(model.containsAttribute("placeForm")).isTrue();
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
		
		assertThat(mav.getViewName()).isEqualTo("redirect:" + Routes.PLACE);	
	}
	
}
