package br.com.academic.communication.Controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.academic.communication.models.User;

@Controller
@RequestMapping("/feed")
public class FeedController {

	
	
	@GetMapping
	public String feed(Model model, Principal principal) {
		
		return "feed";
	}
}
