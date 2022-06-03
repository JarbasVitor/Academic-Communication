package br.com.academic.communication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.academic.communication.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query(value = "SELECT "
				+ "U.ID, U.USERNAME, U.EMAIL, U.ENABLED, U.PASSWORD, U.CREATED_AT, U.UPDATED_AT "
				+ "FROM USERS AS U "
				+ "WHERE U.USERNAME = ?1", nativeQuery = true)
	public User findByUsername(String username);
	
	@Query(value = "SELECT "
				+ "U.ID, U.EMAIL "
				+ "FROM USERS AS U "
				+ "WHERE U.EMAIL = ?1", nativeQuery = true)
	public User findByEmail(String email);
	

}
