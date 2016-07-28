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

import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.exceptions.BusinessException;
import fr.imie.appformusic.service.UserService;

@RunWith(EasyMockRunner.class)
public class MainControllerTest {

	@Mock
	private UserService serviceMock;
	
	@TestSubject
	private MainController controller = new MainController();
	
	@Test
	public void testInit(){
		ModelAndView path = controller.init();
		assertEquals("main", path.getViewName());
	}

	@Test
	public void testGetAllUsersOk() throws Exception {
		List<AppUser> listUsers = new ArrayList<>();
		AppUser user = new AppUser();
		user.setEmail("userTest");
		listUsers.add(user);
		
		// Définition du comportement du mock
		expect(serviceMock.findAllUsers()).andReturn(listUsers);
		replay(serviceMock);
		
		// Appel de la méthode à tester
		List<AppUser>resultList = controller.getAllUsers();
		
		// assertions
		assertEquals(resultList.size(), 1);
		assertEquals(resultList.get(0).getEmail(), "userTest");
	}
	
	/*
	 * Si la méthode du service lance une exception
	 */
	@Test(expected=Exception.class)
	public void testGetAllUsersKo() throws BusinessException{
		expect(serviceMock.findAllUsers()).andThrow(new Exception("Erreur")).times(1);
		replay(serviceMock);
		
		// Appel de la méthode à tester
		controller.getAllUsers();
		
		// Permet de controler que l'appel du mock à bien eu lieu (sinon exception)
		verify(serviceMock.findAllUsers());
	}
	
}
