package br.com.academic.communication.configs;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {

	@Autowired
	private DataSource dataSource;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
			.authorizeRequests()
				.anyRequest().authenticated()
			.and()
			.formLogin(form -> form
					.loginPage("/login")
					.defaultSuccessUrl("/feed", true)
					.permitAll())
			.logout(logout -> logout.
					logoutUrl("/logout"));
		
		return http.build();
	}
	
	@Bean
	public UserDetailsManager users(AuthenticationManagerBuilder auth) throws Exception{

		JdbcUserDetailsManager login = new JdbcUserDetailsManager(dataSource);
		return login;
	}	
	
}
