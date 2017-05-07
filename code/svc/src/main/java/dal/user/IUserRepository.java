package dal.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import models.User;

@Repository
public interface IUserRepository {
	public List<User> getAll();
	public User getById(Integer id);
	public Integer checkLoginData(String username, String password);
}
