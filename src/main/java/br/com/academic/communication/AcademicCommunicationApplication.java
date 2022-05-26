package br.com.academic.communication;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.academic.communication.models.Role;
import br.com.academic.communication.models.User;
import br.com.academic.communication.services.CrudRoleService;
import br.com.academic.communication.services.CrudUserService;

@SpringBootApplication
public class AcademicCommunicationApplication implements CommandLineRunner {

	@Autowired
	CrudUserService crudUserService;
	@Autowired
	CrudRoleService crudRoleService;
	
	public static void main(String[] args) {
		SpringApplication.run(AcademicCommunicationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		//User user = new User("Pitor", "jarbas", true);
		//Role role = new Role(user.getUsername());
		
		//crudUserService.save(user);
		//crudRoleService.save(role);
	}

}
