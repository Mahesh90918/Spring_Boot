package com.mahesh.Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lowagie.text.DocumentException;
import com.mahesh.Service.EmployeeService;
import com.mahesh.model.Employee;
import com.mahesh.pdfService.EmpolyeePDFExporter;

@Controller
//@RequestMapping("/rest")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;


	@GetMapping("/getAll")
	public ModelAndView findAll() {

		return new ModelAndView("FindAllEmp", "empls", employeeService.findAll());
	}
	
//	@GetMapping
//	public ModelAndView findAll1() {
//		
//		return new ModelAndView("FindAllEmp", "empls", employeeService.findAll());
//	}

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
	
//	 once hit This URL Convert file to PDF Format 
	@GetMapping("/users/export/pdf")
	public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=Empolyee_" + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		List<Employee> listEmp = employeeService.findAll();

		EmpolyeePDFExporter exporter = new EmpolyeePDFExporter(listEmp);
		exporter.export(response);

	}


}
