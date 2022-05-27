package br.com.academic.communication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academic.communication.models.People;
import br.com.academic.communication.repositories.PeopleRepository;
import br.com.academic.communication.repositories.UserRepository;

@Service
public class CrudPeopleService {
	
	@Autowired
	private PeopleRepository informationRepository;
	@Autowired
	private UserRepository userRepository;
	
	public CrudPeopleService(PeopleRepository informationRepository) {
		this.informationRepository = informationRepository;
	}
	
	public void save(People info) {
		Long idUser = userRepository.findByUsername(info.getUser().getUsername());
		info.setIdUser(idUser);
		informationRepository.save(info);
	}
	
}
