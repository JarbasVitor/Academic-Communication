package br.com.academic.communication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.academic.communication.models.RelationsSchool;

@Repository
public interface RelationsSchoolRepository extends JpaRepository<RelationsSchool, Long>{

	@Query(value="SELECT RS.FOLLOWING_ID AS ID FROM RELATIONS_SCHOOLS AS RS "
			+ "INNER JOIN PEOPLES AS PEO ON RS.FOLLOWER_ID = PEO.ID "
			+ "INNER JOIN USERS AS U ON PEO.USER_ID = U.ID "
			+ "INNER JOIN SCHOOLS AS S ON RS.FOLLOWING_ID = S.ID "
			+ "WHERE U.USERNAME = ?1 ",nativeQuery = true)
	public Long FindIdSchoolByUsername(String username);

	@Query(value = "SELECT RS.FOLLOWER_ID FROM RELATIONS_SCHOOLS AS RS WHERE FOLLOWING_ID = ?1",nativeQuery = true)
	public long findAllBySchool(Long id);
}
