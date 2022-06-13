package br.com.academic.communication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.academic.communication.models.School;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long>{

	@Query(value ="SELECT S.ID, S.SCHOOL, S.USER_ID, S.CREATED_AT, S.UPDATED_AT FROM SCHOOLS AS S WHERE S.SCHOOL = ?1", nativeQuery = true)
	public School findByName(String string);
	
	@Query(value = "SELECT S.ID, S.SCHOOL, S.USER_ID, S.CREATED_AT, S.UPDATED_AT FROM SCHOOLS AS S WHERE S.ID = ?1", nativeQuery = true)
	public School findSchoolById(Long id);

}
