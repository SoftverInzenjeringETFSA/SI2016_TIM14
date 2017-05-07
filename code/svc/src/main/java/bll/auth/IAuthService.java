package bll.auth;

import org.springframework.stereotype.Service;

import models.dto.AccountCredentials;
import models.dto.LoginResponse;

@Service
public interface IAuthService {
	public LoginResponse login(AccountCredentials request);
}