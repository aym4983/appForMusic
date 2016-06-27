package fr.imie.appformusic.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import static org.easymock.EasyMock.*;

import org.easymock.EasyMockRunner;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.web.servlet.ModelAndView;

import fr.imie.appformusic.domaine.User;
import fr.imie.appformusic.service.UserMetier;

@RunWith(EasyMockRunner.class)
public class MainControllerTest {

	@Mock
	private UserMetier serviceMock;
	
	@TestSubject
	private MainController controller = new MainController();
	
	@Test
	public void testInit(){
		ModelAndView path = controller.init();
		assertEquals("main", path.getViewName());
	}

	@Test
	public void testGetAllUsersOk() throws Exception {
		List<User> listUsers = new ArrayList<>();
		User user = new User();
		user.setId(1);
		user.setName("userTest");
		user.setEmail("userTest");
		listUsers.add(user);
		
		// Définition du comportement du mock
		expect(serviceMock.findAllUsers()).andReturn(listUsers);
		replay(serviceMock);
		
		// Appel de la méthode à tester
		List<User>resultList = controller.getAllUsers();
		
		// assertions
		assertEquals(resultList.size(), 1);
		assertEquals(resultList.get(0).getName(), "userTest");
	}
	
	/*
	 * Si la méthode du service lance une exception
	 */
	@Test(expected=Exception.class)
	public void testGetAllUsersKo(){
		expect(serviceMock.findAllUsers()).andThrow(new Exception("Erreur")).times(1);
		replay(serviceMock);
		
		// Appel de la méthode à tester
		controller.getAllUsers();
		
		// Permet de controler que l'appel du mock à bien eu lieu (sinon exception)
		verify(serviceMock.findAllUsers());
	}
	
}
