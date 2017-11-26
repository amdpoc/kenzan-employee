package com.kenzan.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;
import java.util.Date;

@SpringBootApplication
public class KenzanEmployeeApplication {

	  @PostConstruct
	  void started() {
		//Set the default timezone to UTC.
	    TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	    System.out.println("Spring boot application running in UTC timezone :"+new Date());   // It will print UTC timezone
	  }	
	
	public static void main(String[] args) {
		SpringApplication.run(KenzanEmployeeApplication.class, args);
	}
}
