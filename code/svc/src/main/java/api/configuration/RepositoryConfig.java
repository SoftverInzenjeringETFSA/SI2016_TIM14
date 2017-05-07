package api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dal.user.IUserRepository;
import dal.user.UserRepository;

@Configuration
public class RepositoryConfig implements IRepositoryConfig {

	@Bean
	public IUserRepository userRepository() {
		return new UserRepository();
	}
	
}
