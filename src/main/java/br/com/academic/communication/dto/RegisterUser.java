package br.com.academic.communication.dto;

import br.com.academic.communication.models.People;
import br.com.academic.communication.models.Role;
import br.com.academic.communication.models.User;

public class RegisterUser {

	private String name;
	private String surname;
	private String profession;
	private String email;
	private String username;
	private String password;
	
	public RegisterUser() {
	}
	
	
	public RegisterUser(String name, String surname, String profession, String email, String username,
			String password) {
		this.name = name;
		this.surname = surname;
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
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
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
		
		return user;
	}

	public Role toRole() {
		Role role = new Role();
		
		role.setUsername(username);
		
		return role;
	}

	public People toPeople() {
		People info = new People();
		
		info.setEmail(email);
		info.setName(name);
		info.setSurname(surname);
		info.setProfession(profession);
		
		return info;
	}
	
	
}
