package fr.imie.appformusic.dao;

import java.util.List;

import fr.imie.appformusic.domain.User;
import fr.imie.appformusic.exceptions.TechnicalException;

public interface IUserDao {

	public User findUserById(int userId)throws TechnicalException;
	public List<User> findAllUsers() throws TechnicalException;
}
