package br.com.academic.communication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academic.communication.models.People;
import br.com.academic.communication.repositories.PeopleRepository;
import br.com.academic.communication.repositories.UserRepository;

@Service
public class CrudPeopleService {
	
	@Autowired
	private PeopleRepository peopleRepository;

	@Autowired
	private UserRepository userRepository;
	
	public CrudPeopleService(PeopleRepository peopleRepository) {
		this.peopleRepository = peopleRepository;
	}
	
	public void save(People people) {
		Long idUser = userRepository.findByUsername(people.getUser().getUsername());
		people.setIdUser(idUser);
		peopleRepository.save(people);
	}
	
	public String checkEmail(People people) {
			
			Long userEmail = peopleRepository.findByEmail(people.getEmail());
			
			if(userEmail != null ) {
				return "Email already in database!";
			}
			return "No one email find!";
	}
}
