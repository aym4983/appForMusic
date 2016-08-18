package fr.imie.appformusic.dao;

import java.util.List;

import fr.imie.appformusic.domain.Role;
import fr.imie.appformusic.exceptions.TechnicalException;

public interface IRoleDao {
	
	public void create(Role role) throws TechnicalException;
	public Role findById(byte roleId) throws TechnicalException;
	public Role findByLabel(String roleLabel) throws TechnicalException;
	public List<Role> findAll() throws TechnicalException;

}
