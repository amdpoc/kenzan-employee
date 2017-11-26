package com.kenzan.employee.domain;

//import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Employee.findByStatus",
query = "select e from Employee e where e.status = 'ACTIVE'")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	
	private String firstName;
	private String middleInitial;
	private String lastName;
	private Date  dateOfBirth;	
	private Date dateOfEmployment;
	private String status; 
	
	public Employee(String firstName, String middleInitial, String lastName, Date dateOfBirth, Date dateOfEmployment, String status) {
		super();
		this.firstName = firstName;
		this.middleInitial = middleInitial;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.dateOfEmployment = dateOfEmployment;
		this.status = status;
	}
	
	//For testing purposes only
	public Employee(Long id, String firstName, String middleInitial, String lastName, Date dateOfBirth, Date dateOfEmployment, String status) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleInitial = middleInitial;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.dateOfEmployment = dateOfEmployment;
		this.status=status;
	}	
	
	//Not used. Required for the sake of JPA.
	protected Employee() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Date getDateOfEmployment() {
		return dateOfEmployment;
	}
	public void setDateOfEmployment(Date dateOfEmployment) {
		this.dateOfEmployment = dateOfEmployment;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}	

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", middleInitial=" + middleInitial + ", lastName="
				+ lastName + ", dateOfBirth=" + dateOfBirth + ", dateOfEmployment=" + dateOfEmployment + ", Status="
				+ status + "]";
	}	
	
}
