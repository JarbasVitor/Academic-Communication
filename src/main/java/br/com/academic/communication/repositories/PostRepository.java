package br.com.academic.communication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.academic.communication.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

	@Query(value="SELECT P.* FROM POSTS AS P INNER JOIN PEOPLES AS PEO ON P.PEOPLE_ID = PEO.ID WHERE PEO.ID = ?1", nativeQuery = true)
	List<Post> findAllByPeopleId(Long id);


}
