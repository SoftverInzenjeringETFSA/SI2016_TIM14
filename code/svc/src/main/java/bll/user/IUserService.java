package bll.user;

import java.util.List;

import org.springframework.stereotype.Service;

import models.User;

@Service
public interface IUserService {
	public List<User> getAll();
	public User getById(Integer id);
}