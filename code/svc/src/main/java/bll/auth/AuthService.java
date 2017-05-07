package bll.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dal.user.IUserRepository;
import models.dto.AccountCredentials;
import models.dto.LoginResponse;

@Service
public class AuthService implements IAuthService {

	private IUserRepository _userRepository;
	
	@Autowired
	public AuthService(IUserRepository userRepository) {
		_userRepository = userRepository;
	}
	
	public LoginResponse login(AccountCredentials request) {
		Integer id = _userRepository.checkLoginData(request.getUsername(), request.getPassword());
		
		if (id != -1) {
			Boolean isAdmin = _userRepository.getById(id).getIsAdmin();
			
			return new LoginResponse(id, isAdmin, JwtService.issueToken(isAdmin));
		}
		
		return null;
	}

}
