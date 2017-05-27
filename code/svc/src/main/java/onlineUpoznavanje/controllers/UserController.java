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
import onlineUpoznavanje.dto.LoginDataRequest;
import onlineUpoznavanje.models.Invite;
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
	
	private static List<Invite> invitesToReturn = new ArrayList<Invite>();

	
	private static List<User> usersToReturn = new ArrayList<User>();
	private static User _user = new User();
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
	
	@RequestMapping(value = "/searchUsers")
    public @ResponseBody List<User> searchUsers(@RequestParam("searchTerm") String searchTerm)
    {
		System.out.println(searchTerm);
		try {
			dbActions db = new dbActions();
	        db.connectToDB();
	        usersToReturn = db.searchUsers(searchTerm);
	        db.close();
			 }
			 catch (Exception e)
			 {
				 return UserRepository.findAll();
			 }
			 
	        return usersToReturn;

    }
	
	@RequestMapping(value = "/all")
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
	
	@RequestMapping(value = "/allExceptMe")
    public @ResponseBody List<User> findAllButMe(@RequestParam("id") int id)
    {
		 try {
		dbActions db = new dbActions();
        db.connectToDB();
        usersToReturn = db.readUsersButMe(id);
        db.close();
		 }
		 catch (Exception e)
		 {
			 return UserRepository.findAll();
		 }
		 
        return usersToReturn;

    }
	
	@RequestMapping(value = "/findInvites")
    public @ResponseBody List<Invite> findAllInvites(@RequestParam("id") int id)
    {
		 try {
		dbActions db = new dbActions();
        db.connectToDB();
        invitesToReturn = db.readInvites(id);
        db.close();
		 }
		 catch (Exception e)
		 {
			 return (List<Invite>) e;
		 }
		 
        return invitesToReturn;


    }
	
	@RequestMapping(value = "/promijenipassword", method = RequestMethod.GET)
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
	
	@RequestMapping(value = "/editkorisnik", method = RequestMethod.POST)
    public void editUser(@RequestBody String podatak)
    {

	try {
	   dbActions db = new dbActions();
       db.connectToDB();
       System.out.println(podatak);
       db.editKorisnikDB(podatak);
       db.close();
	   }
	catch (Exception e)
	{
			// return UserRepository.findAll();
	}

    }
	


}
