package onlineUpoznavanje.controllers;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
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


@RestController 
@CrossOrigin
@RequestMapping(path="/korisnici")  
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
    public ResponseEntity inviteUser(@RequestBody String data)
    {
		return ResponseEntity.status(HttpStatus.OK).body(UserService.inviteUser(data));
    }
	
	@RequestMapping(value = "/searchUserPerEmail", method = RequestMethod.POST)
    public @ResponseBody List<User> searchUserPerEmail(@RequestBody String email)
    {
		System.out.println("Why hellp there");
		System.out.println(email);
		try {
			dbActions db = new dbActions();
	        db.connectToDB();
	        usersToReturn = db.searchUserPerEmail(email);
	        db.close();
			 }
			 catch (Exception e)
			 {
				 return UserRepository.findAll();
			 }
			 
	        return usersToReturn;

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
	
	@RequestMapping(value = "/promijenipassword", method = RequestMethod.POST)
    public void changePassword(@RequestBody String podatak)
    {

	try {
	   dbActions db = new dbActions();
       db.connectToDB();
       System.out.println(podatak);
       db.changePasswordDB(podatak);
       db.close();
	   }
	catch (Exception e)
	{
			// return UserRepository.findAll();
	}

    }
	
	


}
