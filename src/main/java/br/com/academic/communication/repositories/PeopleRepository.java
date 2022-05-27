package br.com.academic.communication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.academic.communication.models.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long>{

}