package br.com.academic.communication.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.academic.communication.models.People;
import br.com.academic.communication.models.Role;
import br.com.academic.communication.models.User;

public class RegisterUser {

	@NotBlank
	@Size(max=50)
	private String name;
	@NotBlank
	@Size(max=50)
	private String lastName;
	@NotBlank
	@Size(max=50)
	private String profession;
	@NotBlank
	@Size(max=100)
	private String email;
	@NotBlank
	@Size(max=50)
	private String username;
	@NotBlank
	@Size(max=200)
	private String password;
	
	public RegisterUser() {
	}
	
	public RegisterUser(String name, String lastName, String profession, String email, String username,
			String password) {
		this.name = name;
		this.lastName = lastName;
		this.profession = profession;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return lastName;
	}
	public void setSurname(String lastName) {
		this.lastName = lastName;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public User toUser() {
		User user = new User();
		
		user.setUsername(username);
		user.setPassword(password);
		user.setEnabled(true);
		user.setCreatedAt(LocalDateTime.now());
		user.setUpdatedAt(LocalDateTime.now());
		user.setEmail(email);
		
		return user;
	}

	public Role toRole(User user) {
		Role role = new Role();
		
		role.setUsername(username);
		role.setUpdatedAt(LocalDateTime.now());
		role.setCreatedAt(LocalDateTime.now());
		role.setUser(user);
		
		return role;
	}

	public People toPeople(User user) {
		
		People people = new People();

		people.setCreatedAt(LocalDateTime.now());
		people.setUpdatedAt(LocalDateTime.now());
		people.setName(name);
		people.setLast_name(lastName);
		people.setProfession(profession);
		people.setUser(user);
		
		return people;
	}
	
	
}
