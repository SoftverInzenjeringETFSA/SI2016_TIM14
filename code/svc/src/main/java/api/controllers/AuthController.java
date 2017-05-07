package api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bll.auth.IAuthService;
import common.exception.EntityNotFoundException;
import models.dto.AccountCredentials;
import models.dto.LoginResponse;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private final IAuthService _authService;
	
	@Autowired
	public AuthController(IAuthService authService) {
		_authService = authService;
	}
	
    @PostMapping("/login")
    public LoginResponse login(@RequestBody AccountCredentials request) {
        LoginResponse data = _authService.login(request);
        
        if (data == null) {
        	throw new EntityNotFoundException("User not found: username = " + request.getUsername());
        }
        
        return data;
    }
}