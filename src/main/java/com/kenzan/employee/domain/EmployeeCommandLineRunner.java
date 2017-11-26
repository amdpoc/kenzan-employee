package com.kenzan.employee.domain;

//import java.time.LocalDate;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.io.IOException;
import java.io.InputStream;
import com.fasterxml.jackson.core.type.*;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class EmployeeCommandLineRunner implements CommandLineRunner { 	

	private static final Logger log = LoggerFactory
			.getLogger(EmployeeCommandLineRunner.class);

	@Autowired
	private EmployeeRepository repository;

	@Override
	public void run(String... args) throws Exception {


		//Reading the employees from a json file
		ObjectMapper mapper = new ObjectMapper();	    
		TypeReference<List<Employee>> mapType = new TypeReference<List<Employee>>() {};
		InputStream is = TypeReference.class.getResourceAsStream("/json/kenzamEmployeeData.json");
		try {
			List<Employee> empList = mapper.readValue(is, mapType);
			repository.save(empList);			
			log.info("All employees saved successfully");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}	
		
        //Print all employees to the log
		log.info("");
		log.info("Employees loaded into the in-memroy repository:");
		log.info("_______________________________________________");		
        for (Employee employee : repository.findAll()) { 
            log.info(employee.toString()); 
        }			
		
		//Adding additional employee here; if needed, for testing purposes
		/* Date dateOfBirth = new Date();
		Date dateOfEmployment = new Date();
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		String strDateOfBirth = "17/4/1975";
		String strDateOfEmployment = "13/1/2011";
        try {
        	dateOfBirth =  dateformat.parse(strDateOfBirth);
        	dateOfEmployment =  dateformat.parse(strDateOfEmployment);
            System.out.println(strDateOfBirth);
        } catch (ParseException e) {
            e.printStackTrace();
        } */
		
        /* Use it for testing purposes
		repository.save(new Employee("Rafi", "R", "Lotem", dateOfBirth,dateOfEmployment, "User"));
		repository.save(new Employee("RafiAdmin", "R", "Lotem", dateOfBirth, dateOfEmployment, "Admin"));
		*/
		
        /* Additional methods for testing purposes
		log.info("");
		log.info("The employees by first name are:");
		log.info("________________________________");
		for (Employee employee : repository.findByFirstName("Rafi")) {
			log.info(employee.toString());
		}
		
		log.info("");
		log.info("Employee with id 1:");
		log.info("________________________________");		
		Employee employee1 = repository.findOne(1L);
		log.info(employee1.toString());									
		
		log.info("");
        log.info("Admin users are....."); 
        log.info("____________________"); 
        for (Employee employee : repository.findByRole("Admin")) { 
            log.info(employee.toString()); 
        }		
		*/

	}	
	
}
