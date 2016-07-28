package fr.imie.appformusic.dao;

import java.util.List;

import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.exceptions.TechnicalException;

public interface IUserDao {
	public AppUser findByUserName(String userName)throws TechnicalException;
	public List<AppUser> findAllUsers() throws TechnicalException;
	public AppUser findByEmail(String email) throws TechnicalException;
	public void create(AppUser user);
}
