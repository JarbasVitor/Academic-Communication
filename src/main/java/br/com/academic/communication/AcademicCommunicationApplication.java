package br.com.academic.communication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import br.com.academic.communication.models.People;
import br.com.academic.communication.models.Role;
import br.com.academic.communication.models.User;
import br.com.academic.communication.services.CrudPeopleService;
import br.com.academic.communication.services.CrudRoleService;
import br.com.academic.communication.services.CrudUserService;

@SpringBootApplication
public class AcademicCommunicationApplication implements CommandLineRunner {

	@Autowired
	CrudUserService crudUserService;
	@Autowired
	CrudRoleService crudRoleService;
	@Autowired
	CrudPeopleService crudInformationService;

	public static void main(String[] args) {
		SpringApplication.run(AcademicCommunicationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//CreateUserForTests();
	}

	@Transactional
	private void CreateUserForTests() {
		User user = new User();
		Role role = new Role();
		People info = new People();
		
		user.setUsername("jarbas");
		user.setPassword("jarbas");
		user.setEnabled(true);
		role.setUsername(user.getUsername());
		info.setEmail("jarbas@jarbas.com");
		info.setName("jarbas");
		info.setProfession("Programador");
		info.setSurname("Vitor");
		info.setUser(user);
		
		crudUserService.save(user);
		crudInformationService.save(info);
		crudRoleService.save(role);
		
		
	}

}
