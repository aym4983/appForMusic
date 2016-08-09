package fr.imie.appformusic.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
				.createQuery("from appUser where username = ?")
				.setParameter(0, userName)
				.getSingleResult();
		
		return result;
	}

	@Override
	public List<AppUser> findAllUsers() throws TechnicalException {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from AppUser");
		
		List<AppUser> listUser = query.getResultList();
		return listUser;
	}

	@Override
	public AppUser findByEmail(String email) throws TechnicalException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void create(AppUser user) {
		try {
			EntityManager em = sessionFactory.createEntityManager();
			em.persist(user);
		} catch (Exception e) {
			throw new TechnicalException(e);
		}
	}

}
