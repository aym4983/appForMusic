package fr.imie.appformusic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.imie.appformusic.dao.IRoleDao;
import fr.imie.appformusic.dao.IUserDao;
import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.domain.Role;
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

	@Autowired
	private IRoleDao roleDao;

	@Override
	public void create(AppUser user) throws TechnicalException {
		try {
			sessionFactory.getCurrentSession().persist(user);
		} catch (Exception e) {
			throw new TechnicalException(e);
		}
	}
	
	@Override
	public AppUser findByUserName(String userName) throws TechnicalException {
		return sessionFactory.getCurrentSession()
				.createQuery("from AppUser u where u.username = :name", AppUser.class)
				.setParameter("name", userName)
				.getSingleResult();
	}

	@Override
	public AppUser findByEmail(String email) throws TechnicalException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AppUser> findAllUsers() throws TechnicalException {
		return sessionFactory.getCurrentSession()
				.createQuery("from AppUser", AppUser.class)
				.getResultList();
	}

	@Override
	public List<AppUser> findUsersLike(String username) throws TechnicalException {
		List<AppUser> users = new ArrayList<AppUser>();
		users = sessionFactory.getCurrentSession()
				.createQuery("from AppUser u where u.username like :username", AppUser.class)
				.setParameter("username", "%" + username + "%")
				.getResultList();
		
		for (AppUser appUser : users) {
			for (Role role : appUser.getRoles()) {
				role = roleDao.findById(role.getId());
			}
		}
		
		return users;
	}

}
