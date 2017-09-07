package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {
	
	private int empId;
	private String empName;
	private String userName;
	private String password;
	private String email;
	private Request request;
	private Company employer;
	private Desk desk;
	
	
	public Employee() {
		System.out.println("In Employee default ctor");
	}
	
	public Employee(String empName, String dasId, String userName, String password, String email) {
		super();
		this.empName = empName;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	
	
	@ManyToOne
	@JoinColumn(name="CompanyId")
	public Company getEmployer() {
		return employer;
	}

	public void setEmployer(Company employer) {
		this.employer = employer;
	}
	
	
	
	
	
	
	
	@OneToOne(mappedBy="employee1",cascade=CascadeType.MERGE)
	public Desk getDesk() {
		return desk;
	}

	public void setDesk(Desk desk) {
		this.desk = desk;
	}

	@Id
	@GeneratedValue
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	@Column(unique=true)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(unique=true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@OneToOne(mappedBy="employee",cascade=CascadeType.ALL)
	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	@Override
	public String toString() {
		return "Employee [empName=" + empName +  ", userName=" + userName + ", password=" + password
				+ ", email=" + email + "]";
	}
	
	
	
	
	

}
