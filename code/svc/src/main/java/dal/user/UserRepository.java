package dal.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import models.User;

@Repository
public class UserRepository implements IUserRepository {

	public List<User> getAll() {
		List<User> users = new ArrayList<User>();
		
		users.add(new User(1, "Mirza", "Vucijak"));
		users.add(new User(2, "SI", "ETF"));
		
		return users;
	}

	public User getById(Integer id) {
		if (id == 2)
			return new User(2, "SI", "ETF");
		else
			return null;
	}

}
