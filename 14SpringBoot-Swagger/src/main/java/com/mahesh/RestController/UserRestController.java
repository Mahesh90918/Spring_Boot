package com.mahesh.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mahesh.model.Role;
import com.mahesh.model.UserInfo;
import com.mahesh.service.Roles;
import com.mahesh.service.UserService;

@RestController
public class UserRestController {
	@Autowired
	UserService serv;
	@Autowired
	Roles rolerepo;

	@GetMapping({ "/", "home" })
	public String Home() {
		return "Home";
	}

	@GetMapping("/addUser")
	public String addUser(Model model) {
		model.addAttribute("role", rolerepo.getAllRoles());
		System.out.println(rolerepo.getAllRoles());
		return "AddUser";

	}

	@PostMapping("/saveUser")
	public String saveUser(@RequestBody UserInfo user) {
		List<Role> roles = new ArrayList<Role>();
		for (Role role : user.getRoles()) {

			roles.add(rolerepo.getByRoleID(role.getRoleId()));

		}
		user.setRoles(roles);

		System.out.println(user);
		serv.addUser(user);
		return "redirect:/";

	}

	@GetMapping("/getAllUsers")
	public ModelAndView getAllUsers(Model model) {
		System.out.println(serv.getAllUsers());

		model.addAttribute("getroles", rolerepo.getAllRoles());
		return new ModelAndView("getUsers", "users", serv.getAllUsers());

	}

}