package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;


@Controller
@RequestMapping(value = "/users")
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public String getAllUsers(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "users/users";
	}

	@GetMapping("/new")
	public String newUser (@ModelAttribute ("user") User user) {
		return "users/new";
	}

	@PostMapping()
	public String create (@ModelAttribute ("user") User user) {
		userService.addUser (user);
		return "redirect:/users";
	}

	@RequestMapping(value = "/delete/{id}",method=RequestMethod.DELETE)
	public String deleteUserFrom(@PathVariable ("id") int id) {
		userService.removeUser(id);
		return "redirect:/users";
	}

	@GetMapping("/edit/{id}")
	public String updateUserForm(Model model, @PathVariable ("id") int id) {
		model.addAttribute("user", userService.getUserById(id));
		return "users/edit";
	}

	@PatchMapping("/{id}")
	public String updateUserFrom(@ModelAttribute ("user") User user, @PathVariable("id") int id){
		userService.updateUser(id, user);
		return "redirect:/users";
	}
}

