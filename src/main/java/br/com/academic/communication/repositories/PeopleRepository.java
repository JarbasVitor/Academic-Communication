package br.com.academic.communication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.academic.communication.models.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long>{

	@Query(value = "SELECT P.IDPEOPLE FROM PEOPLES P WHERE EMAIL = ?1", nativeQuery = true)
	public Long findByEmail(String email);

	@Query(value="SELECT PEO.ID, PEO.NAME, PEO.LAST_NAME, PEO.PROFESSION, PEO.USER_ID, PEO.CREATED_AT, PEO.UPDATED_AT "
			+ "FROM PEOPLES AS PEO "
			+ "INNER JOIN USERS AS U ON PEO.USER_ID = U.ID "
			+ "INNER JOIN RELATIONS_SCHOOLS AS RS ON RS.FOLLOWER_ID = PEO.ID "
			+ "WHERE FOLLOWING_ID = ?1", nativeQuery = true)
	public List<People> findAllBySchool(Long idSchool);

}
