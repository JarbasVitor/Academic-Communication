package br.com.academic.communication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.academic.communication.services.CrudPeopleService;
import br.com.academic.communication.services.CrudRoleService;
import br.com.academic.communication.services.CrudUserService;

@SpringBootApplication
public class AcademicCommunicationApplication{

	@Autowired
	CrudUserService crudUserService;
	@Autowired
	CrudPeopleService crudPeopleService;
	@Autowired
	CrudRoleService crudRoleService;
	
	public static void main(String[] args) {
		SpringApplication.run(AcademicCommunicationApplication.class, args);
	}

	
/*	@Override
	@Transactional
	public void run(String... args) throws Exception {
		
		User user = new User();
		People people = new People();
		Role role = new Role();
		
		user.setUsername("admin");
		user.setEmail("admin@admin.com");
		user.setPassword("admin");
		user.setCreatedAt(LocalDateTime.now());
		user.setUpdatedAt(LocalDateTime.now());
		user.setEnabled(true);
		
		people.setCreatedAt(LocalDateTime.now());
		people.setUpdatedAt(LocalDateTime.now());
		people.setName("admin");
		people.setLast_name("admin");
		people.setProfession("admin");
		
		role.setUsername(user.getUsername());
		role.setCreatedAt(LocalDateTime.now());
		role.setUpdatedAt(LocalDateTime.now());
		
		people.setUser(user);
		role.setUser(user);
		
		crudUserService.save(user);
		crudPeopleService.save(people);
		crudRoleService.save(role);
		
	}
*/

}
