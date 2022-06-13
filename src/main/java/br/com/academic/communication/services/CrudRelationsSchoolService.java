package br.com.academic.communication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academic.communication.models.RelationsSchool;
import br.com.academic.communication.repositories.RelationsSchoolRepository;

@Service
public class CrudRelationsSchoolService {
	
	@Autowired
	RelationsSchoolRepository relationsSchoolRepository;
	
	public CrudRelationsSchoolService(RelationsSchoolRepository RelationsSchoolRepository) {
		this.relationsSchoolRepository = RelationsSchoolRepository;
	}

	public void save(RelationsSchool RelationsSchool) {
		relationsSchoolRepository.save(RelationsSchool);
	}
	
	public Long FindIdSchoolByUsername(String username) {
		return relationsSchoolRepository.FindIdSchoolByUsername(username);
	}
	
}
