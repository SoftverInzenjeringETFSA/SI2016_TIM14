package onlineUpoznavanje.controllers;

//import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import onlineUpoznavanje.models.User;
import onlineUpoznavanje.repositories.UserRepository;


@RestController //Ovo znaèi da je ova klasa kontroler (Controller)
@CrossOrigin
@RequestMapping(path="/korisnici")  // This means URL's start with /demo (after Application path)
public class UserController {
	
	@Autowired
    private UserService korisnikService;
	
	
	//registracija korisnika
	@RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody User korisnik)
    {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(korisnikService.addUsers(korisnik));
        }
        catch (ServiceException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                .body(e.getLocalizedMessage());
        }


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
		// Ovo vraæa JSON ili XML za sve user-e
		return userRepository.findAll();
	}*/


}
