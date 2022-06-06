package br.com.academic.communication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.academic.communication.models.RelationsSchool;

@Repository
public interface RelationsSchoolRepository extends JpaRepository<RelationsSchool, Long>{

}
