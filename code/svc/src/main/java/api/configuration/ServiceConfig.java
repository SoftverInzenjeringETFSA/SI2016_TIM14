package api.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import bll.auth.AuthService;
import bll.auth.IAuthService;
import bll.user.IUserService;
import bll.user.UserService;

@Configuration
public class ServiceConfig {
	
	@Autowired
	private IRepositoryConfig repositoryConfig;
	
	@Bean
	public IUserService userService() {
		return new UserService(repositoryConfig.userRepository());
	}
	
	@Bean
	public IAuthService authService() {
		return new AuthService(repositoryConfig.userRepository());
	}
		
}
