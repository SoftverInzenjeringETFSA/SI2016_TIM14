package api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dal.user.IUserRepository;

@Configuration
public interface IRepositoryConfig {
	@Bean IUserRepository userRepository();
}
