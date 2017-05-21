package onlineUpoznavanje.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import onlineUpoznavanje.models.User;
import onlineUpoznavanje.repositories.UserRepository;


@Controller //Ovo znaèi da je ova klasa kontroler (Controller)
@RequestMapping(path="/demo")  // This means URL's start with /demo (after Application path)
public class UserController {
	
	@Autowired 
	
	
    private UserRepository userRepository;
	
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser (@RequestParam String username
			, @RequestParam String email, @RequestParam String password) {
		
		// @ResponseBody means the returned String is the response, not a view name
	    // @RequestParam means it is a parameter from the GET or POST request

		User n = new User();
		n.setUsername(username);
		n.setEmail(email);
		n.setPassword(password);
		userRepository.save(n);
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<User> getAllUsers() {
		// Ovo vraæa JSON ili XML za sve user-e
		return userRepository.findAll();
	}


}
