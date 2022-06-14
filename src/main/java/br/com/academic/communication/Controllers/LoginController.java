package br.com.academic.communication.Controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import br.com.academic.communication.dto.RegisterUser;
import br.com.academic.communication.models.People;
import br.com.academic.communication.models.RelationsSchool;
import br.com.academic.communication.models.Role;
import br.com.academic.communication.models.School;
import br.com.academic.communication.models.User;
import br.com.academic.communication.services.CrudPeopleService;
import br.com.academic.communication.services.CrudRelationsSchoolService;
import br.com.academic.communication.services.CrudRoleService;
import br.com.academic.communication.services.CrudSchoolService;
import br.com.academic.communication.services.CrudUserService;

@Controller
public class LoginController {

	@Autowired
	CrudUserService crudUserService;
	@Autowired
	CrudRoleService crudRoleService;
	@Autowired
	CrudPeopleService crudPeopleService;
	@Autowired
	CrudSchoolService crudSchoolService;
	@Autowired
	CrudRelationsSchoolService crudRelationsService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/registration")
	public String registration(WebRequest request, Model model) {
		RegisterUser registerUser = new RegisterUser();
		
		model.addAttribute("registerUser", registerUser);
		return "registration";
	}

	@Transactional
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("registerUser") RegisterUser registerUser,
			BindingResult bindingResult) {

		User user = registerUser.toUser();

		People people = registerUser.toPeople(user);
		Role role = registerUser.toRole(user);
		School school = crudSchoolService.findByName(registerUser.getSchool());
		RelationsSchool reSchool = registerUser.toReSchool(people, school);

		if (!(crudUserService.checkUsername(user) == "No one user find!")) {
			bindingResult.rejectValue("username", "error.username", "User Already Registered!");
		} else if (!(crudUserService.checkEmail(user) == "No one email find!")) {
			bindingResult.rejectValue("email", "error.email", "Email Already Registered!");
		} else if (school == null) {
			bindingResult.rejectValue("school", "error.school","School Not Found!");
		}

		if (bindingResult.hasErrors()) {
			return "registration";
		}

		try {
			crudUserService.save(user);
			crudPeopleService.save(people);
			crudRoleService.save(role);
			crudRelationsService.save(reSchool);

			return "login";

		} catch (RuntimeException e) {
			e.printStackTrace();
			return "registration";
		}
	}
}