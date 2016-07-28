package fr.imie.appformusic.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import fr.imie.appformusic.configuration.TestDispatcherConfig;
import fr.imie.appformusic.domain.Place;
import fr.imie.appformusic.domain.User;

/**
 * 
 * @author Loïc
 *
 * Attendre qu'hibernate soit configuré pour coder le test
 */

@ContextConfiguration(classes={TestDispatcherConfig.class})
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoImplTest {

	@Autowired
	private IUserDao userDao;
	private EmbeddedDatabase database;
	
	@Before
	public void setUp() throws Exception {
		database = new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.HSQL)
				.setName("test_base")
				.build();
	}
	
	@Test
	@Ignore
	@Transactional
	public void testFindAllUsers(){
		List<User> listUser = userDao.findAllUsers();
		assertThat(listUser).isNotNull();
		assertThat(listUser.get(0).getUserName()).isEqualTo("test");
		assertThat(listUser.get(0).getPlace().getIdPlace()).isEqualTo(2);
	}
	
	@Test
	@Transactional
	public void testCreateUser(){
		User user = new User(2, "user", "usermail", "mdp", 5, "loic", "chaucheprat");
		Place place = new Place(1, "placename", "blablabla");
		user.setPlace(place);
		place.setUser(user);
		
		userDao.create(user);
	}

	@After
	public void tearDown() throws Exception {
		database.shutdown();
	}

}
