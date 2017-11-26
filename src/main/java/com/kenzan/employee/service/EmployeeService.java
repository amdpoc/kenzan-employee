package com.kenzan.employee.service;

import java.util.List;
import org.springframework.stereotype.Component; 
import com.kenzan.employee.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;

@Component
public class EmployeeService implements IEmployeeService {

	private static final Logger log = LoggerFactory
			.getLogger(EmployeeCommandLineRunner.class);
	
	@Autowired
	private EmployeeRepository repository;	
	
	public String retrieveEmployeeWelcomeMessage() {
		return "Welcome from Kenzan employee REST services";
	}
	
	
	//REST Example: http://localhost:8080/employee
    @Override
    public List<Employee> findAll() {
        List<Employee> employees = (List<Employee>) repository.findAll();        
        return employees;
    }	
    
	//REST Example: http://localhost:8080/employee/2
    @Override
    public Employee findById(Long id) {
        Employee employee = repository.findOne(id, "ACTIVE");
		if(employee == null){
			log.info("Employee #" + Long.toString(id) + " is INACTIVE or does not exist!");          
		}
        return employee;
    }	    
	
	//REST Example: http://localhost:8080/employee/delete/2
    @Override
    public Employee deleteEmployee(Long id) {
    	try {
    		Employee employee = this.findById(id);
    		employee.setStatus("INACTIVE");
    		repository.save(employee);   
    		return employee;
    	} catch(NullPointerException e) {
    		System.out.println("Employee does not exist or is INACTIVE!");
    		return null;
    	}    		
    }	    
          
	//REST Example: http://localhost:8080/employee/activate/2
    @Override
    public Employee activateEmployee(Long id) {
    	try {
    		Employee employee = this.findByIdInactive(id);
    		employee.setStatus("ACTIVE");
    		repository.save(employee);   
    		return employee;
    	} catch(NullPointerException e) {
    		System.out.println("Employee does not exist or is INACTIVE!");
    		return null;
    	}
    }	    
    
	//Find INACTIVE employee for activation
    @Override
    public Employee findByIdInactive(Long id) {
        Employee employee = repository.findOne(id, "INACTIVE");        
        return employee;
    }	
    
	//REST Example: http://localhost:8080/employee/update/2
    @Override
    public Employee updateEmployee(Long id, Employee employeeParam) {
    	try {    		
    		Employee employee = repository.findOne(id, "ACTIVE"); 
    		if (employeeParam.getFirstName() != null && !employeeParam.getFirstName().equals("")) {
    			employee.setFirstName(employeeParam.getFirstName());	
    		};
    		if (employeeParam.getMiddleInitial() != null && !employeeParam.getMiddleInitial().equals("")) {
    			employee.setLastName(employeeParam.getLastName());	
    		};   		
    		if (employeeParam.getMiddleInitial() != null && !employeeParam.getMiddleInitial().equals("")) {
    			employee.setMiddleInitial(employeeParam.getMiddleInitial());	
    		}; 
    		if (employeeParam.getDateOfBirth() != null) {
    			employee.setDateOfBirth(employeeParam.getDateOfBirth());	
    		}; 
    		if (employeeParam.getDateOfEmployment() != null) {
    			employee.setDateOfEmployment(employeeParam.getDateOfEmployment());	
    		}; 
    		
    		repository.save(employee); 
    		return employee;
    	} catch(NullPointerException e) {
    		System.out.println("Employee does not exist or is INACTIVE!");
    		return null;
    	}    		
    }	
    
	//REST Example: http://localhost:8080/employee/create
    @Override
    public Employee createEmployee(Employee newEmploye) {
    	try {    		
    		newEmploye.setStatus("ACTIVE");
    		Employee employee = repository.save(newEmploye); 
    		return employee;
    	} catch(NullPointerException e) {
    		System.out.println("Create employee was not successcul!");
    		return null;
    	}    		
    }    
        
	/* For testing purposes
	private static List<Employee> employeeList = new ArrayList<>();
	static {
		// Initialize Data
		LocalDate rafiDate = LocalDate.of(1971,12,12);
		Employee employee1 = new Employee(Long.valueOf("1"), "Rafi", "R", "Lotem", rafiDate,rafiDate, "User");
		Employee employee2 = new Employee(Long.valueOf("2"), "RafiAdmin", "R", "LotemAdmin", rafiDate,rafiDate, "User");
		employeeList.add(employee1);
		employeeList.add(employee2);
	}	
    
    //For testing purposes using an array instead of DB
	public Employee retrieveEmployeeById(String employeeId) {
		for (Employee employee : employeeList) {
			if (Long.toString(employee.getId()).equals(employeeId)) {
				return employee;
			}
		}
		return null;
	} */		

}
