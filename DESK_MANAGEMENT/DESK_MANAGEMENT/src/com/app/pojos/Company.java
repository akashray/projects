package com.app.pojos;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Comopany")
public class Company {
	
	
	private int companyId;
	private String companyName;	
	private String userName;
	private String password;
	private String email;
	private String registrationId;
	private List<Request> requests;
	private List<Employee> employees;
	private List<Desk> desks;
	
	public Company() {
		System.out.println("in default company ctor");
	}
	 	
	public Company(String companyName, String userName, String password, String email, String registrationId) {
		super();
		this.companyName = companyName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.registrationId = registrationId;
	}

	public String getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(String registrationId) {
		this.registrationId = registrationId;
	}

	
	
	@OneToMany(mappedBy="employer",cascade=CascadeType.ALL)
	public List<Employee> getEmployees() {
		return employees;
	}	
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	
	
	
	@OneToMany(mappedBy="owner",cascade=CascadeType.ALL)
	public List<Desk> getDesks() {
		return desks;
	}
	public void setDesks(List<Desk> desks) {
		this.desks = desks;
	}

	@Id
	@GeneratedValue
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(unique=true)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(unique=true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	
	
	@OneToMany(mappedBy="company",cascade=CascadeType.ALL)
	public List<Request> getRequests() {
		return requests;
	}
	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	
	
	//Helper Methods
	public void addEmployee(Employee employee)
	{
		this.employees.add(employee);
		employee.setEmployer(this);
	}	
	
	public void addDesk(Desk desk)
	{
		this.desks.add(desk);
		desk.setOwner(this);
	}
	
	public void addRequest(Request request)
	{
		this.requests.add(request);
		request.setCompany(this);
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "Company [companyName=" + companyName + ", userName=" + userName + ", password=" + password + ", email="
				+ email + ", registrationId=" + registrationId + "]";
	}



	


	
	
	
	

}
