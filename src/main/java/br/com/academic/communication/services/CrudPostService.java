package br.com.academic.communication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.academic.communication.dto.PostDTO;
import br.com.academic.communication.models.Post;
import br.com.academic.communication.repositories.PostRepository;

@Service
public class CrudPostService {
	
	@Autowired
	PostRepository postRepository;
	
	public CrudPostService(PostRepository PostRepository) {
		this.postRepository = PostRepository;
	}

	public void save(Post Post) {
		postRepository.save(Post);
	}
	
	public List<Post> findAllByPeopleId(Long id){
		return postRepository.findAllByPeopleId(id);
	}
	
}
