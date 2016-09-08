package fr.imie.appformusic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.easymock.EasyMock;
import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.MockType;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;

import fr.imie.appformusic.dao.IPlaceDao;
import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.domain.Picture;
import fr.imie.appformusic.domain.Place;
@RunWith(EasyMockRunner.class)
public class PlaceServiceTest {

	@TestSubject
	private PlaceService service = new PlaceService();
	
	@Mock(type=MockType.NICE)
	private IPlaceDao daoMock;
	
	@Test
	public void testCreate() throws Exception {
		Place place = new Place();
		place.setCity("ville");
		
		daoMock.create(place);
		EasyMock.expectLastCall();
		EasyMock.replay(daoMock);
		
		service.create(place);
	}

	@Test
	public void testFindById() throws Exception {
		Place place = new Place();
		place.setPlaceId(1);
		place.setPublicLabel("placeTest");
		
		EasyMock.expect(daoMock.findById(1)).andReturn(place);
		EasyMock.replay(daoMock);
		
		Place result = service.findById(1);
		Assertions.assertThat(result.getPublicLabel()).isEqualTo("placeTest");
	}

	@Test
	public void testFindAllPlaces() throws Exception {
		List<Place> liste = new ArrayList<>();
		Place place = new Place();
		liste.add(place);
		place.setCity("Angers");
		
		EasyMock.expect(daoMock.findAllPlaces()).andReturn(liste);
		EasyMock.replay(daoMock);
		
		List<Place> result = service.findAllPlaces();
		Assertions.assertThat(result).isNotEmpty()
			.contains(place);
		Assertions.assertThat(result.get(0).getCity()).isEqualTo("Angers");
	}

	@Test
	public void testFindPlacesLike() throws Exception {
		List<Place> liste = new ArrayList<>();
		Place place1 = new Place();
		Place place2 = new Place();
		Place place3 = new Place();
		place1.setCity("Angers");
		place2.setCity("Paris");
		place3.setCity("Anglet");
		liste.add(place1);
		liste.add(place3);
		
		EasyMock.expect(daoMock.findPlacesLike("ng")).andReturn(liste);
		EasyMock.replay(daoMock);
		
		List<Place> result = service.findPlacesLike("ng");
		Assertions.assertThat(result)
			.isNotNull()
			.isNotEmpty()
			.contains(place1, place3);
	}

	@Test
	public void testFindUserPlaces() throws Exception {
		AppUser user = new AppUser();
		user.setUsername("toto");
		
		List<Place> liste = new ArrayList<>();
		Place place = new Place();
		place.setOwner(user);
		place.setPublicLabel("placeTest");
		liste.add(place);
		
		EasyMock.expect(daoMock.FindUserPlaces(user)).andReturn(liste);
		EasyMock.replay(daoMock);
		
		List<Place> result = service.findUserPlaces(user);
		Assertions.assertThat(result)
			.isNotNull()
			.isNotEmpty()
			.contains(place);
		Assertions.assertThat(result.get(0).getOwner().getUsername())
			.isEqualTo("toto");
	}

	@Test
	public void testFindUserPlacesLike() throws Exception {
		List<Place> liste = new ArrayList<>();
		AppUser user = new AppUser();
		Place place = new Place();
		
		user.setUsername("toto");
		place.setPublicLabel("placeTest");
		liste.add(place);
		
		EasyMock.expect(daoMock.findUserPlacesLike(user.getUsername(), place.getPublicLabel())).andReturn(liste);
		EasyMock.replay(daoMock);
		
		List<Place> result = service.findUserPlacesLike(user, place.getPublicLabel());
		Assertions.assertThat(result)
			.isNotNull()
			.isNotEmpty()
			.contains(place);
	}

	@Test
	public void testDeletePlace() throws Exception {
		Place place = new Place();
		
		daoMock.delete(place);
		EasyMock.expectLastCall();
		
		service.deletePlace(place);
	}

	@Test
	public void testSaveImage() throws Exception {
		Picture pic = new Picture();
		
		daoMock.saveImage(pic);
		EasyMock.expectLastCall();
		
		service.saveImage(pic);
	}

}
