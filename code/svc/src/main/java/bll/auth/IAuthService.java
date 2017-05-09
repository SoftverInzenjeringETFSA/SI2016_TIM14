package bll.auth;

import org.springframework.stereotype.Service;

import models.dto.AccountCredentials;
import models.dto.LoginResponse;
import models.dto.UserRegisterRequest;

@Service
public interface IAuthService {
	public LoginResponse login(AccountCredentials request);
	public Integer register(UserRegisterRequest request);
}