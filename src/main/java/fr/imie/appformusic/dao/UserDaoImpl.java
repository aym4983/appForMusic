package fr.imie.appformusic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import fr.imie.appformusic.domain.User;
import fr.imie.appformusic.exceptions.TechnicalException;

@Repository
public class UserDaoImpl implements IUserDao {

	@Autowired
	@Qualifier(value="datasource")
	private DataSource ds;
	
	@Override
	public User findUserById(int userId) throws TechnicalException{
		try (Connection connect = ds.getConnection()){
			String sql = "select * from utilisateur where id = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			
			// traitement du résultat
			User user = new User();
			while(rs.next()){
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("nom"));
				user.setPassword(rs.getString("mdp"));
				user.setEmail(rs.getString("email"));
			}
			return user;
		}
		catch (SQLException e){
			throw new TechnicalException(e);
		}
	}
	
	@Override
	public List<User> findAllUsers() throws TechnicalException{
		return null;
	}
	
}
