package fr.imie.appformusic.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.servlet.ModelAndView;

import fr.imie.appformusic.configuration.constants.Views;
import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.domain.Place;
import fr.imie.appformusic.exceptions.BusinessException;
import fr.imie.appformusic.responses.GlobalSearchResponse;
import fr.imie.appformusic.responses.Response;
import fr.imie.appformusic.service.IPlaceService;
import fr.imie.appformusic.service.IUserService;

@RunWith(EasyMockRunner.class)
public class SearchControllerTest {

	@TestSubject
	private SearchController controller = new SearchController();
	
	@Mock
	private IUserService userServiceMock;
	
	@Mock
	private IPlaceService placeServiceMock;
	
	@Test
	public void testInit() throws BusinessException{
		List<Place> places = new ArrayList<Place>();
		places.add(createPlace());
		
		expect(placeServiceMock.findAllPlaces()).andReturn(places).anyTimes();
		replay(placeServiceMock);
		
		Model model = new BindingAwareModelMap();
		ModelAndView view = controller.init(model);
		
		assertThat(view.getViewName()).isEqualTo(Views.SEARCH);
	}

	@Test
	public void testSearchAllOk() throws BusinessException {
		String search = "test";
		
		List<AppUser> users = new ArrayList<AppUser>();
		users.add(createAppUser());
		
		expect(userServiceMock.findUsersLike(search)).andReturn(users).anyTimes();
		replay(userServiceMock);
		
		List<Place> places = new ArrayList<Place>();
		places.add(createPlace());
		
		expect(placeServiceMock.findPlacesLike(search)).andReturn(places).anyTimes();
		replay(placeServiceMock);
		
		Response<GlobalSearchResponse> response = controller.searchAll(search);

		assertThat(response.getContent().getUsers().size()).isEqualTo(1);
		assertThat(response.getContent().getPlaces().size()).isEqualTo(1);
	}
	
	private AppUser createAppUser(){
		AppUser user = new AppUser();
		user.setEmail("test@test.fr");
		user.setUsername("usernameTest");
		user.setPasswordHash("passwordTest");
		return user;
	}
	
	private Place createPlace(){
		Place place = new Place();
		place.setPlaceId(1);
		place.setPublicLabel("public test label");
		place.setStreet("street");
		place.setZipcode("49100");
		place.setCity("Angers");
		place.setLatitude(47.4698);
		place.setLongitude(-0.5593);
		place.setOwner(createAppUser());
		return place;
	}
	
}
