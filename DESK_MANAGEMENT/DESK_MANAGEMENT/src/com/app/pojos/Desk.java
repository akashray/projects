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
@Table(name="Desk")
public class Desk {
	
	private int deskId;
	private String serialId;
	private Company owner;
	private Employee employee1;
	private String status="Available";
	private Request request;
	
	
	public Desk() {
		System.out.println("In Desk default ctor");
	}
	
		
	public Desk(String serialId) {
		super();
		this.serialId = serialId;
	}
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="RequestId")
	public Request getRequest() {
		return request;
	}
	public void setRequest(Request request) {
		this.request = request;
	}


	@OneToOne
	@JoinColumn(name="EmployeeId")
	public Employee getEmployee1() {
		return employee1;
	}


	public void setEmployee1(Employee employee) {
		this.employee1 = employee;
	}


	@Id
	@GeneratedValue
	public int getDeskId() {
		return deskId;
	}
	public void setDeskId(int deskId) {
		this.deskId = deskId;
	}
	
	public String getSerialId() {
		return serialId;
	}
	public void setSerialId(String serialId) {
		this.serialId = serialId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	@ManyToOne
	@JoinColumn(name="CompanyId")
	public Company getOwner() {
		return owner;
	}


	public void setOwner(Company owner) {
		this.owner = owner;
	}


	@Override
	public String toString() {
		return "Desk [serialId=" + serialId + ", status=" + status + "]";
	}


	


	


	
	
	

}
