package fr.imie.appformusic.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
				.createQuery("from appUser where username = ?")
				.setParameter(0, userName)
				.getSingleResult();
		
		return result;
	}

	@Override
	public List<AppUser> findAllUsers() throws TechnicalException {
		EntityManager em = sessionFactory.createEntityManager();
		Query query = em.createQuery("from AppUser");
		return query.getResultList();
	}

	@Override
	public AppUser findByEmail(String email) throws TechnicalException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(AppUser user) {
		EntityManager em = sessionFactory.createEntityManager();
		em.persist(user);
	}

}
