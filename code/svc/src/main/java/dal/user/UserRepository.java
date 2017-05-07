package dal.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import dal.DbHelper;
import models.User;

@Repository
public class UserRepository implements IUserRepository {

	private DbHelper _db = new DbHelper();
	
	public List<User> getAll() {
		List<User> users = new ArrayList<User>();
		
		try {
			String query = "SELECT * FROM user";
			PreparedStatement statement = _db.connect().prepareStatement(query);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				users.add(new User(rs));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			_db.disconnect();
		}
		
		return users;
	}

	public User getById(Integer id) {
		User user = null;
		
		try {
			String query = "SELECT * FROM user WHERE id = ?";
			PreparedStatement statement = _db.connect().prepareStatement(query);
			
			statement.setInt(1, id);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				user = new User(rs);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			_db.disconnect();
		}
		
		return user;
	}

	public Integer checkLoginData(String username, String password) {
		try {
			String query = "SELECT * FROM user WHERE username = ? AND password = ?";
			PreparedStatement statement = _db.connect().prepareStatement(query);
			
			statement.setString(1, username);
			statement.setString(2, password);
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				return rs.getInt("Id");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			_db.disconnect();
		}
		
		return -1;
	}

}
