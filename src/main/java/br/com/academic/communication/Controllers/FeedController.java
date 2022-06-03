package br.com.academic.communication.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/feed")
public class FeedController {

	@GetMapping
	public String feed() {
		
		//Ver escola do usuario
		//Ver todos os post relacionados a escola
		//Carregar no feed
		
		return "feed";
	}
}
