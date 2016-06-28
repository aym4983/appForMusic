package fr.imie.appformusic.dao;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
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
import fr.imie.appformusic.domain.User;

@ContextConfiguration(classes={TestDispatcherConfig.class})
@WebAppConfiguration()
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoImplTest {

	@Autowired
	private IUserDao dao;
	private EmbeddedDatabase database;
	
	@Before
	public void setUp() {
	     database = new EmbeddedDatabaseBuilder()
	            .setType(EmbeddedDatabaseType.HSQL)
	            .setName("test_base")
	            .addScript("init_script.sql")
	            .build();
	}
	
	@Test
	@Transactional
	public void testFindAllUsers() throws Exception {
		User user = dao.findUserById(1);
		
		assertEquals(user.getName(), "nomTest");
	}

	@After
	public void tearDown(){
		database.shutdown();
	}
}
