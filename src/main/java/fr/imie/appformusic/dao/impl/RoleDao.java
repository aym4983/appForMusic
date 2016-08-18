package fr.imie.appformusic.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
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
			return sessionFactory
					.getCurrentSession()
					.createQuery("from Role where id = :roleId", Role.class)
					.setParameter("roleId", roleId)
					.getSingleResult();
		} catch (Exception e) {
			throw new TechnicalException(e);
		}
	}

	@Override
	public Role findByLabel(String roleLabel) throws TechnicalException {
		try {
			return sessionFactory
					.getCurrentSession()
					.createQuery("from Role where label = :roleLabel", Role.class)
					.setParameter("roleLabel", roleLabel)
					.getSingleResult();
		} catch (Exception e) {
			throw new TechnicalException(e);
		}
	}

	@Override
	public List<Role> findAll() throws TechnicalException {
		try {
			return sessionFactory
					.getCurrentSession()
					.createQuery("from Role", Role.class)
					.getResultList();
		} catch (Exception e) {
			throw new TechnicalException(e);
		}
	}

}
