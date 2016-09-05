package fr.imie.appformusic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
	public void update(AppUser user) throws TechnicalException {
		try {
			
			Session session = sessionFactory.openSession();
			session.saveOrUpdate(user);
			session.close();
		} catch (Exception e) {
			throw new TechnicalException(e);
		}
	}
	
	@Override
	public AppUser findByUserName(String userName) throws TechnicalException {
		return (AppUser) sessionFactory.getCurrentSession()
				.createCriteria(AppUser.class)
				.add(Restrictions.eq("username", userName))
				.uniqueResult();
	}

	@Override
	public AppUser findByEmail(String email) throws TechnicalException {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AppUser> findAllUsers() throws TechnicalException {
		return sessionFactory.getCurrentSession()
				.createCriteria(AppUser.class)
				.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AppUser> findUsersLike(String username) throws TechnicalException {
		List<AppUser> users = new ArrayList<AppUser>();
		users = sessionFactory.getCurrentSession()
				.createCriteria(AppUser.class)
				.add(Restrictions.like("username", "%"+username+"%"))
				.list();
		
		for (AppUser appUser : users) {
			for (Role role : appUser.getRoles()) {
				role = roleDao.findById(role.getId());
			}
		}
		
		return users;
	}

	@Override
	public void updateUser(
			AppUser user, 
			String newEmail, 
			String newPasswordHash, 
			String newFirstName,
			String newLastName
	) throws TechnicalException {
		if (null != newEmail && !newEmail.isEmpty()) user.setEmail(newEmail);
		if (null != newPasswordHash && !newPasswordHash.isEmpty()) user.setPasswordHash(newPasswordHash);
		if (null != newFirstName && !newFirstName.isEmpty()) user.setFirstname(newFirstName);
		if (null != newLastName && !newLastName.isEmpty()) user.setLastname(newLastName);
		sessionFactory.getCurrentSession().merge(user);
	}

}
