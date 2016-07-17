package fr.imie.appformusic.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.imie.appformusic.domain.User;
import fr.imie.appformusic.exceptions.TechnicalException;

/**
 * Implémentation de l'interface IUserDao.
 * @author Dorian
 *
 */
@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public User findByUserName(String userName) throws TechnicalException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllUsers() throws TechnicalException {
		List<User> list = sessionFactory.getCurrentSession().createQuery("from User", User.class).getResultList();
		return list;
	}

	@Override
	public User findByEmail(String email) throws TechnicalException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(User user) {
		// TODO Auto-generated method stub
		
	}

}
