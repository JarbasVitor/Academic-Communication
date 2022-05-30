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
	
	public CrudPeopleService(PeopleRepository informationRepository) {
		this.peopleRepository = informationRepository;
	}
	
	public void save(People info) {
		Long idUser = userRepository.findByUsername(info.getUser().getUsername());
		info.setIdUser(idUser);
		peopleRepository.save(info);
	}
	
	public String checkEmail(People people) {
			
			Long userEmail = peopleRepository.findByEmail(people.getEmail());
			
			if(userEmail != null ) {
				return "Email Já Cadastrado!";
			}
			return "Nenhum Email Encontrado!";
	}
}
