package com.spring.employee.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.employee.model.Employee;
import com.spring.employee.repository.EmployeeRepository;


@RestController
public class EmployeeController {

	@Autowired
	Employee employeeservice;
	@Autowired
	EmployeeRepository employeerepository;

	@RequestMapping("/")
	public String  message() {
		return "hello";
	}
	@RequestMapping("/helloworld")
	public String  helloWorld() {
		return "hi";
	}
	@RequestMapping("/helloworld/{name}")
	public String  helloWorldName(@PathVariable String name) {
		return "hi  "  +name;
	}

	@RequestMapping("/helloworld/emp")
	public Employee getEmployee() {
				return  new Employee(1,"aaa",new Date());
		}
	
			
	@RequestMapping("/helloworld/db/emp")
	public List<Employee> getEmployeeDB() {
				return  employeerepository.findAll();
		}
	
	@GetMapping("/jpa/getemp)")
	public List<Employee> jpagetEmployee(){
	return employeerepository.findAll();
	
}
@GetMapping("/jpa/getemp/{id})")
public Optional<Employee> jpahetemployee(@PathVariable Integer id) throws Exception{
		Optional<Employee> emp=employeerepository.findById(id);
		if(emp.isPresent())
			throw new Exception("emp id"+id);
		return emp;
		
}
}


