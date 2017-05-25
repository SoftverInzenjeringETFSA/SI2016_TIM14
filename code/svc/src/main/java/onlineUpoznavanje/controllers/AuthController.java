package onlineUpoznavanje.controllers;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import onlineUpoznavanje.db.dbActions;
import onlineUpoznavanje.dto.LoginDataRequest;
import onlineUpoznavanje.dto.LoginDataResponse;
import onlineUpoznavanje.models.User;
import onlineUpoznavanje.repositories.UserRepository;
import onlineUpoznavanje.services.AuthService;
import onlineUpoznavanje.services.JwtService;

@RestController
@CrossOrigin
//@Configuration
//@ComponentScan("onlineUpoznavanje.service")
@RequestMapping("/auth")
public class AuthController {
	 
	    @Autowired
		private AuthService _authService;
	    
	   // @Autowired
		//private static UserRepository UserRepository;
	    
	    
		@RequestMapping(path="", method = RequestMethod.POST)
	    public @ResponseBody ResponseEntity<LoginDataResponse> login(@RequestBody LoginDataRequest request) {
	 
				try {
	    		 
	        	User user = _authService.checkLoginData(request.getUsername(), request.getPassword());
	        	
	        	if (user != null) {

	        		    String token=null;
	        			token = JwtService.issueToken(false,false);	        		
		                 return ResponseEntity
		            		      .status(HttpStatus.OK)
		                           .body(new LoginDataResponse(user, token));
	        	}
	        	else {
	        		throw new ServiceException("");
	        	}
	           
	    	}
	    	catch (ServiceException e) {
	    		return ResponseEntity
	    				.status(HttpStatus.BAD_REQUEST)
	                    .body(new LoginDataResponse("Incorrect username or password."));
	    	}
	    }
}
