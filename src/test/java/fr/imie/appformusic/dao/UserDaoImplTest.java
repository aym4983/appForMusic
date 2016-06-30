package fr.imie.appformusic.dao;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.*;

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
				.addScripts("init_script.sql")
				.build();
	}
	
	@Test
	@Transactional
	@Ignore
	public void test(){
		assertThat(userDao.findAllUsers()).isNotNull();
	}

	@After
	public void tearDown() throws Exception {
		database.shutdown();
	}

}