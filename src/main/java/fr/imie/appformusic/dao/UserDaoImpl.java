package fr.imie.appformusic.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.imie.appformusic.domain.User;
import fr.imie.appformusic.exceptions.TechnicalException;

/**
 * Implémentation de l'interface IUserDao.
 * @author Dorian
 *
 */
@Repository
public class UserDaoImpl implements IUserDao {

	@Override
	public User findByUserName(String userName) throws TechnicalException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAllUsers() throws TechnicalException {
		// TODO Auto-generated method stub
		return null;
	}

}
