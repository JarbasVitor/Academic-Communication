package br.com.academic.communication.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class FeedController {

	@GetMapping
	public String feed() {
		return "feed";
	}
}
