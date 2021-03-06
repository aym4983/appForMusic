package fr.imie.appformusic.dao;

import java.util.List;

import fr.imie.appformusic.domain.AppUser;
import fr.imie.appformusic.exceptions.TechnicalException;

public interface IUserDao {
	
	public void create(AppUser user) throws TechnicalException;
	public AppUser findByUserName(String userName)throws TechnicalException;
	public AppUser findByEmail(String email) throws TechnicalException;
	public List<AppUser> findAllUsers() throws TechnicalException;
	public List<AppUser> findUsersLike(String username) throws TechnicalException;
	public void update(AppUser user) throws TechnicalException;
	public void updateUserInfos(AppUser user, String newEmail, String newFirstName, String newLastName);
	public void updateUserPass(AppUser user, String newPasswordHash);
	
}
