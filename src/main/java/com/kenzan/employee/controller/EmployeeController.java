package com.kenzan.employee.controller;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.RequestBody;

import com.kenzan.employee.domain.*;
	import java.util.List;
	
	import com.kenzan.employee.service.*;

	@RestController
	public class EmployeeController {

		@Autowired
		private EmployeeService employeeService;

		@RequestMapping("/employee/welcome")
		public String employeeWelcome() {
			return employeeService.retrieveEmployeeWelcomeMessage();
		}
	
		@RequestMapping("/employee/all")		
	    public List<Employee> findAllActiveEmployees() {	        
	        List<Employee> employees = (List<Employee>) employeeService.findAll();
	        return employees;
		}			
		
		@GetMapping("/employee/{employeeId}")		
	    public Employee findEmployeeById(@PathVariable Long employeeId) {	        
	        Employee employee = employeeService.findById(employeeId);
	        return employee;
		}
		
		@RequestMapping("/employee/delete/{employeeId}")		
	    public Employee deleteEmployees(@PathVariable Long employeeId) {	        
	        Employee employee = (Employee) employeeService.deleteEmployee(employeeId);
	        return employee;
		}
		
		@RequestMapping("/employee/activate/{employeeId}")		
	    public Employee activateEmployees(@PathVariable Long employeeId) {	        
	        Employee employee = (Employee) employeeService.activateEmployee(employeeId);
	        return employee;
		}
		
		@RequestMapping("/employee/update/{id}")		
	    public Employee updateEmployee(@PathVariable Long id,  @RequestBody Employee employeeBody) {
	        //Employee employee = (Employee) employeeService.activateEmployee(employeeParam);
	        Employee employee = (Employee) employeeService.updateEmployee(id, employeeBody);
	        return employee;
		}	
		@RequestMapping("/employee/create")		
	    public Employee createEmployee(@RequestBody Employee employeeBody) {
	        Employee employee = (Employee) employeeService.createEmployee(employeeBody);
	        return employee;
		}		
		
		
/* For testing purposes - using employeeList		
		@GetMapping("/employeeIdTest/{emlpoyeeId}")
		public String employeeWithIdTest(@PathVariable String emlpoyeeId) {
			return employeeService.retrieveEmployeeWithIdTest(emlpoyeeId);
		}		
		
		@GetMapping("/employeeId/{emlpoyeeId}")
		public String retrieveEmployeeById(@PathVariable String emlpoyeeId) {
			Employee employee = employeeService.retrieveEmployeeById(emlpoyeeId);
			return employee.toString();
			//return null;
		}
		
		
		// GET employee by its id
		@GetMapping("/employee/{employeeId}")
		public Employee retrieveEmployeeDetails(@PathVariable String employeeId) {
			return employeeService.retrieveEmployeeById(employeeId);
		}
*/		
	}	
	
