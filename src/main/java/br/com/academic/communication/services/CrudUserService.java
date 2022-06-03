package br.com.academic.communication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.academic.communication.models.User;
import br.com.academic.communication.repositories.UserRepository;

@Service
public class CrudUserService {
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	@Autowired
	private final UserRepository userRepository;
	
	public CrudUserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public void save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userRepository.save(user);
	}
	
	public String checkUsername(User user) {
		
		User TempUser = userRepository.findByUsername(user.getUsername());
		
		if(TempUser != null ) {
			return "User alredy in database!";
		}
		
		return "No one user find!";
	}
	
	public String checkEmail(User user) {
		
		User TempUser = userRepository.findByEmail(user.getEmail());	
		
		if(TempUser != null ) {
			return "Email alredy in database!";
		}
		
		return "No one email find!";
	}
	
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
