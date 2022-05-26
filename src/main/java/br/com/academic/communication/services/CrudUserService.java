package br.com.academic.communication.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.academic.communication.models.User;
import br.com.academic.communication.repositories.UserRepository;

@Service
public class CrudUserService {
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	private final UserRepository userRepository;
	
	public CrudUserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
	}
}
