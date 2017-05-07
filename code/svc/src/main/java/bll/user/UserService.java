package bll.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dal.user.IUserRepository;
import models.User;

@Service
public class UserService implements IUserService {

	private IUserRepository _userRepository;
	
	@Autowired
	public UserService(IUserRepository userRepository) {
		_userRepository = userRepository;
	}
	
	public List<User> getAll() {
		return _userRepository.getAll();
	}

	public User getById(Integer id) {
		return _userRepository.getById(id);
	}

}
