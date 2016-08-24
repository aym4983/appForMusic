package fr.imie.appformusic.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.imie.appformusic.dao.IRoleDao;
import fr.imie.appformusic.domain.Role;
import fr.imie.appformusic.exceptions.TechnicalException;

@Repository
public class RoleDao implements IRoleDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void create(Role role) throws TechnicalException {
		try {
			sessionFactory.getCurrentSession().persist(role);
		} catch (Exception e) {
			throw new TechnicalException(e);
		}
	}

	@Override
	public Role findById(byte roleId) throws TechnicalException {
		try {
			Criteria c = sessionFactory
					.getCurrentSession()
					.createCriteria(Role.class)
					.add(Restrictions.idEq(roleId));
			Role role = (Role) c.uniqueResult();
			return role;
		} catch (Exception e) {
			throw new TechnicalException(e);
		}
	}

	@Override
	public Role findByLabel(String roleLabel) throws TechnicalException {
		try {
			Criteria c = sessionFactory
					.getCurrentSession()
					.createCriteria(Role.class)
					.add(Restrictions.eq("label", roleLabel));
			
			Role role = (Role) c.uniqueResult();
			return role;
		} catch (Exception e) {
			throw new TechnicalException(e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> findAll() throws TechnicalException {
		try {
			return sessionFactory
					.getCurrentSession()
					.createCriteria(Role.class)
					.list();
		} catch (Exception e) {
			throw new TechnicalException(e);
		}
	}

}
