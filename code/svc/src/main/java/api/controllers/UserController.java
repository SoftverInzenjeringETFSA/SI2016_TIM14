package api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bll.user.IUserService;
import common.exception.EntityNotFoundException;
import models.User;

@RestController
@RequestMapping("/api/user")
public class UserController {

	private final IUserService _userService;
	
	@Autowired
	public UserController(IUserService userService) {
		_userService = userService;
	}
	
    @RequestMapping(method = RequestMethod.GET, path = "")
    public List<User> getAll() {
        return _userService.getAll();
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public User getById(@PathVariable Integer id) throws Exception {
    	User user = _userService.getById(id);
    	
    	if (user == null) {
    	    throw new EntityNotFoundException("User not found: id = " + id);
    	}
    	
    	return user;
    }
}