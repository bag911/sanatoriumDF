package com.bag.Kursach;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Controller
public class MainController implements WebMvcConfigurer{

	@Autowired
	private UserRepos userRepos;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/results").setViewName("results");
	}

	@GetMapping("/form")
	public String showForm(PersonForm personForm) {

		return "form";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<PersonForm> getAllUsers() {
		// This returns a JSON or XML with the users
		return userRepos.findAll();
	}
	@PostMapping("/form")
	public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "form";
		}
		PersonForm person= new PersonForm(personForm.getName(),personForm.getLastName(),personForm.getPhone(),personForm.getService(),personForm.getSTime(),personForm.getWishText());
		userRepos.save(person);
		System.out.println(personForm.getName());
		return "redirect:/results";
	}




	@GetMapping("/")
	public String index(Model model){
		return "index";
	}
	@GetMapping("/services")
	public String services(Model model){
		return "service";
	}


	@GetMapping("/about")
	public String about(Model model){
		return "about";
	}
	// @GetMapping("/about")
	// public String about(Model model){
	// 	model.addAttribute("title", "Главная страница");
	// 	return "service.html";
	// }






	// @GetMapping("/greeting")
	// public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
	// 	model.addAttribute("name", name);
	// 	return "greeting";
	// }

}