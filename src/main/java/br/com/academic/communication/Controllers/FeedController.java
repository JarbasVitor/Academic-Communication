package br.com.academic.communication.Controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.academic.communication.dto.PostDTO;
import br.com.academic.communication.models.People;
import br.com.academic.communication.models.Post;
import br.com.academic.communication.models.School;
import br.com.academic.communication.repositories.PostRepository;
import br.com.academic.communication.repositories.RelationsSchoolRepository;
import br.com.academic.communication.repositories.UserRepository;
import br.com.academic.communication.services.CrudPeopleService;
import br.com.academic.communication.services.CrudPostService;
import br.com.academic.communication.services.CrudRelationsSchoolService;
import br.com.academic.communication.services.CrudSchoolService;
import br.com.academic.communication.services.CrudUserService;

@Controller
@RequestMapping("/feed")
public class FeedController {

	@Autowired
	CrudPostService crudPostService;
	@Autowired
	CrudUserService crudUserService;
	@Autowired
	CrudRelationsSchoolService crudRelationsSchoolService;
	@Autowired
	CrudPeopleService crudPeopleService;
	@Autowired
	CrudSchoolService crudSchoolService;
	
	@GetMapping
	public String feed(Model model, Principal principal) {
		
		//TEMOS AQUI O ID DA ESCOLA
		Long idSchool = crudRelationsSchoolService.FindIdSchoolByUsername(principal.getName());
		School school = crudSchoolService.findById(idSchool);
		
		//COM O ID DA ESCOLA TEMOS TODAS AS PESSOAS QUE SEGUEM A ESCOLA E PODEREMOS PEGAR TODOS
		//OS POSTS DESSAS PESSOAS E CARREGAR PARA O USUARIO PRINCIPAL
		List<People> peoples = crudPeopleService.findAllBySchool(school.getId());
		//
		//
		List<PostDTO> postDTO = new ArrayList<>();
		
		for (People people : peoples) {	
			Long peopleId = people.getId();
			List<Post> post = crudPostService.findAllByPeopleId(peopleId);
			for (Post tempPost : post) {
				
				PostDTO tempPostDTO = new PostDTO();
				tempPostDTO.toPostDTO(tempPost, people, school);
				
				postDTO.add(tempPostDTO);
			}
		}
		
		model.addAttribute("post", postDTO);
		return "feed";
	}
}
