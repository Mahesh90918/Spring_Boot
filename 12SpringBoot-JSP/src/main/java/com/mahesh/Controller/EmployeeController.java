package com.mahesh.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mahesh.Service.EmployeeService;
import com.mahesh.model.Employee;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/getAll")
	public ModelAndView findAll() {

		return new ModelAndView("FindAllEmp", "empls", employeeService.findAll());
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("id") Integer id) {
		employeeService.deleteById(id);
		return "redirect:/getAll";

	}

	@PostMapping("/updateEmp")
	public String Update(Employee employee) {
		employeeService.update(employee);
		return "redirect:/getAll";

	}

	@GetMapping("/update")
	public String getByid(@RequestParam("id") Integer id, Model model) {

		Employee em = employeeService.findById(id);
		model.addAttribute("employee", em);

		return "updateEmployee";

	}

	@GetMapping("/saveEmp")
	public String saveEmp() {
		return "Save";

	}

	@PostMapping("/save")
	public String save(Employee employee) {
		employeeService.save(employee);
		return "redirect:/getAll";

	}

}
