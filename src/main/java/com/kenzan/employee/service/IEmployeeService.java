package com.kenzan.employee.service;

import com.kenzan.employee.domain.*;
import java.util.List;

// Contract methods for all employees REST operations
public interface  IEmployeeService {

    public List<Employee> findAll();  	
    public Employee findById(Long id);
    public Employee findByIdInactive(Long id);    
    public Employee deleteEmployee(Long id);
    public Employee activateEmployee(Long id);
    public Employee updateEmployee(Long id, Employee employee); 
    public Employee createEmployee(Employee employee);
}
