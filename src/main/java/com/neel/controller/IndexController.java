package com.neel.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neel.model.*;

@RestController
public class IndexController {
	
	static List<Employee> empList = new ArrayList<>();
	static {
		Employee e1 = new Employee(1L, "Neelesh", "Admin");
		empList.add(e1);
		
	}

	@RequestMapping("/")
	public String index() {
		return "Hello World!";
	}

	@RequestMapping("/employees/{id}")
	public Employee getEmployeeByID(@PathVariable("id") Long id) {
		Employee emp = new Employee();
		
		for (int i=0; i<empList.size(); i++) {
			if(empList.get(i).getId() == id) {
				emp = empList.get(i);
			}
		}
		empList.forEach(e -> {
			
		});
		
		return emp;
		
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return empList;
	}

	@PostMapping("/employees")
	public Employee newEmployee(@RequestBody Employee newEmployee) {
		empList.add(newEmployee);
		return newEmployee;
	}
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmployee(@RequestBody Long id) {
		
		empList.forEach(e -> {
			if (e.getId() == id) {
				empList.remove(e);
			}
		});
		return "Record deleted successfully";
	}
	
	

}
