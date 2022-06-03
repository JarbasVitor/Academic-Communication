package br.com.academic.communication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.academic.communication.models.User;

public class UserDetailsServiceImp implements UserDetailsService {

	@Autowired
	CrudUserService crudUserService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = crudUserService.findByUsername(username);

		UserBuilder builder = null;

		if (user != null) {
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.password(user.getPassword());
			builder.roles("user");
		} else {
			throw new UsernameNotFoundException("User not found.");
		}

		return builder.build();
	}

}
