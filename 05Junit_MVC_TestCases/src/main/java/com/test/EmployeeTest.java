package com.test;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Employee;
import com.controller.EmployeeController;

public abstract class EmployeeTest {

	public static void main(String[] args) {

		ApplicationContext ac = new ClassPathXmlApplicationContext("Spring.xml");
		EmployeeController ec = (EmployeeController) ac.getBean("employeeController");
		List<Employee> list = ec.findbyAll();
		for (Employee emp : list) {
			System.out.println(emp);
		}

	}

}
