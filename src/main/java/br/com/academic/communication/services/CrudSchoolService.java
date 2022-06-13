package br.com.academic.communication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academic.communication.models.School;
import br.com.academic.communication.repositories.SchoolRepository;

@Service
public class CrudSchoolService {
	
	@Autowired
	private final SchoolRepository SchoolRepository;
	
	public CrudSchoolService(SchoolRepository SchoolRepository) {
		this.SchoolRepository = SchoolRepository;
	}

	public void save(School School) {
		SchoolRepository.save(School);
	}

	public School findByName(String string) {
		
		return SchoolRepository.findByName(string);
	}
	
	public School findById(Long id) {
		return SchoolRepository.findSchoolById(id);
	}
}
