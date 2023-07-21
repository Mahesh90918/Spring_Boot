package com.mahesh.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mahesh.model.Role;
import com.mahesh.service.RoleServiceImpl;
@RestController
public class RoleController {
	
	@Autowired
	RoleServiceImpl serv;
	
	@GetMapping("/addRole")
	public String addRole() {
		return "Addrole";
	}
	@PostMapping("/saveRole")
	public String saveRole(@RequestBody Role role) {
		
		serv.save(role);
		return "redirect:/getAllroles";
	}
	
	@GetMapping("/getAllroles")
	public ModelAndView getRoles() {
		return new ModelAndView("getRoles", "roles", serv.getAllRoles());
	}
	
	
	@GetMapping("/update")
	public String updateRole(@RequestParam("id") Integer id,Model model) {
		Role rol=serv.getByRoleID(id);
		model.addAttribute("role", rol);
		return "UpdateRole";
		
	}
	
	@PostMapping("/update")
	public String update (Role role) {
		serv.save(role);
		return  "redirect:/getAllroles";
	}
	
	
	@GetMapping("/delete")
	public String deleteRole(@RequestParam("id") Integer id) {
		serv.delete(id);
		return "redirect:/getAllroles";
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
