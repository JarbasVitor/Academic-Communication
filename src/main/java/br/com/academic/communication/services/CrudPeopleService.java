package br.com.academic.communication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academic.communication.models.People;
import br.com.academic.communication.repositories.PeopleRepository;

@Service
public class CrudPeopleService {
	
	@Autowired
	private PeopleRepository peopleRepository;
	
	public CrudPeopleService(PeopleRepository peopleRepository) {
		this.peopleRepository = peopleRepository;
	}
	
	public void save(People people) {
		peopleRepository.save(people);
	}

	public List<People> findAllBySchool(Long idSchool) {
		return peopleRepository.findAllBySchool(idSchool);
	}
	

}
