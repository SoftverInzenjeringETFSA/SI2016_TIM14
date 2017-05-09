package bll.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dal.user.IUserRepository;
import models.User;
import models.dto.AccountCredentials;
import models.dto.LoginResponse;
import models.dto.UserRegisterRequest;

@Service
public class AuthService implements IAuthService {

	private IUserRepository _userRepository;
	
	@Autowired
	public AuthService(IUserRepository userRepository) {
		_userRepository = userRepository;
	}
	
	public LoginResponse login(AccountCredentials request) {
		User user = _userRepository.checkLoginData(request.getUsername(), request.getPassword());
		
		if (user != null) {
			return new LoginResponse(user, JwtService.issueToken(user.getIsAdmin()));
		}
		
		return null;
	}

	public Integer register(UserRegisterRequest request) {
		return _userRepository.register(request.getUsername(), request.getEmail(), request.getPassword());
	}

}
