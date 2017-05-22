package onlineUpoznavanje.controllers;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
//import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import onlineUpoznavanje.services.UserService;
import onlineUpoznavanje.services.izuzetak.ServiceException;
import onlineUpoznavanje.db.dbActions;
import onlineUpoznavanje.models.User;
import onlineUpoznavanje.repositories.UserRepository;


@RestController //Ovo zna�i da je ova klasa kontroler (Controller)
@CrossOrigin
@RequestMapping(path="/korisnici")  // This means URL's start with /demo (after Application path)
public class UserController {
	
	
	@Autowired
    private static UserService korisnikService;
	
	@Autowired
	private static UserRepository UserRepository;
	
	private static List<User> usersToReturn = new ArrayList<User>();
	//registracija korisnika
	@RequestMapping(value = "/store", method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody String korisnik)
    {
		return ResponseEntity.status(HttpStatus.OK).body(UserService.storeUser(korisnik));
    }
	
	@RequestMapping(value = "/inviteUser", method = RequestMethod.POST)
    public ResponseEntity inviteUser(@RequestBody String email)
    {
		return ResponseEntity.status(HttpStatus.OK).body(UserService.inviteUser(email));
    }
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
    public @ResponseBody List<User> findAll()
    {
		 try {
		dbActions db = new dbActions();
        db.connectToDB();
        usersToReturn = db.readUsers();
        db.close();
		 }
		 catch (Exception e)
		 {
			 return UserRepository.findAll();
		 }
		 
        return usersToReturn;


    }
	
	
	/*@GetMapping(path="/add") // Map ONLY GET Requests
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
		// Ovo vra�a JSON ili XML za sve user-e
		return userRepository.findAll();
	}*/


}
