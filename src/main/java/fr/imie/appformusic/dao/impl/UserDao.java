package fr.imie.appformusic.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.imie.appformusic.dao.IUserDao;
import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.exceptions.TechnicalException;

/**
 * Implémentation de l'interface IUserDao.
 * @author Dorian
 *
 */
@Repository
public class UserDao implements IUserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public AppUser findByUserName(String userName) throws TechnicalException {
		AppUser result = (AppUser) sessionFactory.getCurrentSession()
				.createQuery("from AppUser u where u.username = :name")
				.setParameter("name", userName)
				.getSingleResult();
		
		return result;
	}

	@Override
	public List<AppUser> findAllUsers() throws TechnicalException {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from appuser");
		
		List<AppUser> listUser = query.getResultList();
		return listUser;
	}

	@Override
	public AppUser findByEmail(String email) throws TechnicalException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(AppUser user) throws TechnicalException {
		try {
			sessionFactory.getCurrentSession().persist(user);
		} catch (Exception e) {
			throw new TechnicalException(e);
		}
	}

}
