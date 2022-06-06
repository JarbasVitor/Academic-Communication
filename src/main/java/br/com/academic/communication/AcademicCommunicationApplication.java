package br.com.academic.communication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.academic.communication.services.CrudPeopleService;
import br.com.academic.communication.services.CrudPostService;
import br.com.academic.communication.services.CrudRelationsSchoolService;
import br.com.academic.communication.services.CrudRoleService;
import br.com.academic.communication.services.CrudSchoolService;
import br.com.academic.communication.services.CrudUserService;

@SpringBootApplication
public class AcademicCommunicationApplication {

	@Autowired
	CrudUserService crudUserService;
	@Autowired
	CrudPeopleService crudPeopleService;
	@Autowired
	CrudRoleService crudRoleService;
	@Autowired
	CrudSchoolService crudSchoolService;
	@Autowired
	CrudPostService crudPostService;
	@Autowired
	CrudRelationsSchoolService crudRelationsSchoolService;
	
	public static void main(String[] args) {
		SpringApplication.run(AcademicCommunicationApplication.class, args);
	}

	
	/*@Override
	@Transactional
	public void run(String... args) throws Exception {
		
		
		User user = new User();
		People people = new People();
		Role role = new Role();
		
		School school = new School();
		Post post = new Post();
		RelationsSchool relationSchool = new RelationsSchool(); 
		

		user.setUsername("Edu");
		user.setEmail("edu@edu.com");
		user.setPassword("edu");
		user.setCreatedAt(LocalDateTime.now());
		user.setUpdatedAt(LocalDateTime.now());
		user.setEnabled(true);
		
		people.setCreatedAt(LocalDateTime.now());
		people.setUpdatedAt(LocalDateTime.now());
		people.setName("edu");
		people.setLast_name("edu");
		people.setProfession("edu");
		
		role.setUsername(user.getUsername());
		role.setCreatedAt(LocalDateTime.now());
		role.setUpdatedAt(LocalDateTime.now());
		
		school.setCreatedAt(LocalDateTime.now());
		school.setUpdatedAt(LocalDateTime.now());
		school.setUser(user);
		school.setSchool("EEFM Pq Presidente Vargas");
		
		post.setCreatedAt(LocalDateTime.now());
		post.setUpdatedAt(LocalDateTime.now());
		post.setDescription("Ta ai Uma duvida em doidão");
		post.setTitle("Que duvida em");
		

		relationSchool.setUpdatedAt(LocalDateTime.now());
		relationSchool.setCreatedAt(LocalDateTime.now());
		
		people.setUser(user);
		role.setUser(user);
		post.setPeople(people);
		relationSchool.setPeople(people);
		relationSchool.setSchool(school);
		
		crudUserService.save(user);
		crudPeopleService.save(people);
		crudRoleService.save(role);
		crudSchoolService.save(school);
		crudPostService.save(post);
		crudRelationsSchoolService.save(relationSchool);
		
	}
	 	*/

}
