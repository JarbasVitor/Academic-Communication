package br.com.academic.communication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academic.communication.models.Role;
import br.com.academic.communication.repositories.RoleRepository;

@Service
public class CrudRoleService {
	
	@Autowired
	private final RoleRepository roleRepository;
	
	public CrudRoleService(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}
	
	public void save(Role role) {
		roleRepository.save(role);
	}
}
