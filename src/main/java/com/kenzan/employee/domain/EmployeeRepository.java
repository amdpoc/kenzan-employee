package com.kenzan.employee.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;


@RepositoryRestResource(path = "employee") // if used the path in EmployeeRESTRepository will not work
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
    @Query(value = "FROM Employee WHERE status = 'ACTIVE'")
    List<Employee> findAll();		
	    
    @Query(value = "FROM Employee WHERE id = ?1 and status = ?2")    
	Employee findOne(Long id, String status);
    
	//List<Employee> findByFirstName(String firstName);	
}