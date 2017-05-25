package onlineUpoznavanje.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import onlineUpoznavanje.db.dbActions;
import onlineUpoznavanje.dto.LoginDataResponse;
import onlineUpoznavanje.models.User;
import onlineUpoznavanje.repositories.UserRepository;


//@Configuration
//@ComponentScan("onlineUpoznavanje.repository")
@Service
public class AuthService {
	
	
	//@Autowired
    //public static UserRepository repository;
	private static User _user = new User();
	 
	public User checkLoginData(String username, String password){
		System.out.print("   heh     " + "  NESTO  ");
		try {
			dbActions db = new dbActions();
	        db.connectToDB();
	        _user = db.searchUserForLogin(username, password);
	         db.close();
	         if(_user != null)
			   return _user;
	         else
	        	 return null;
	        	 
		 }
		catch (Exception e)
			 {
				 return null;
			 }
    }

}
