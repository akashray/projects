package com.app.service;

import java.util.List;

import com.app.pojos.Company;
import com.app.pojos.Desk;
import com.app.pojos.Employee;
import com.app.pojos.Request;

public interface CompanyService {
	int registerCompany(Company company);
	Company validateCompany(String username,String password);
	
	
	
	int addEmployee(Employee employee,Company company);
	Employee validate_employee(String username,String password);
	
	 public Request viewStatus(Employee employee);
	 public String checkReq(Employee employee);
	int addRequest(Request request,Employee employee,Company company);
	int addDesk(Desk desk,Company company);
	List<Desk> getAllDesk(Company company);
	List<Desk> getAllAvailableDesk(Company company);
	List<Request> getAllRequest(Company company);
	List<Employee> getAllEmp(Company company);
	void approveRequest(Request request);
	int deleteEmp(int id);
	Employee getEmp(int id);
	
	int deleteDesk(int id);

}
