package br.com.academic.communication.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.academic.communication.dto.RegisterUser;
import br.com.academic.communication.models.People;
import br.com.academic.communication.models.Role;
import br.com.academic.communication.models.User;

@Controller
public class LoginController {

	@GetMapping
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping
	@RequestMapping("/registration")
	public String registration() {
		return "registration";
	}
	
	@PostMapping
	@RequestMapping("/register")
	public String Register(RegisterUser registerUser) {
		
		User user = registerUser.toUser();
		Role role = registerUser.toRole();
		People info = registerUser.toPeople();
		
		return "register";
	}
}
