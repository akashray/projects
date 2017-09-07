package com.app.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Request")
public class Request {

	private int requestId;
	private String requesttype;
	private String reqStatus="Pending";
	private String requestdate;
	private String approvalDate;
	private Company company;
	private Employee employee;
	private Desk desk;
	
	
	
	
	public Request() {
		System.out.println("in default Request ctor");
	}

	
	
	public Request(String requesttype, String requestdate) {
		super();
		this.requesttype = requesttype;
		this.requestdate = requestdate;
	}

	

	@OneToOne(mappedBy="request",cascade=CascadeType.ALL)
	public Desk getDesk() {
		return desk;
	}
	public void setDesk(Desk desk) {
		this.desk = desk;
	}



	public String getRequesttype() {
		return requesttype;
	}



	public void setRequesttype(String requesttype) {
		this.requesttype = requesttype;
	}



	public String getRequestdate() {
		return requestdate;
	}



	public void setRequestdate(String requestdate) {
		this.requestdate = requestdate;
	}



	public String getApprovalDate() {
		return approvalDate;
	}



	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}



	@Id
	@GeneratedValue
	public int getRequestId() {
		return requestId;
	}


	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}


	


	public String getReqStatus() {
		return reqStatus;
	}



	public void setReqStatus(String reqStatus) {
		this.reqStatus = reqStatus;
	}



	@ManyToOne
	@JoinColumn(name="CompanyId")
	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}

	@OneToOne
	@JoinColumn(name="EmployeeId")
	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}



	@Override
	public String toString() {
		return "Request [requesttype=" + requesttype + ", reqStatus=" + reqStatus + ", requestdate=" + requestdate
				+ ", approvalDate=" + approvalDate + "]";
	}


	
	
	
	
}
