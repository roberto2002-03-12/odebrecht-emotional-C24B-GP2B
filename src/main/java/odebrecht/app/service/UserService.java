package odebrecht.app.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import odebrecht.app.model.User;
import odebrecht.app.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
	User select(Long id);
}
