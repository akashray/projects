package com.app.dao;


import java.util.List;

import com.app.pojos.Company;
import com.app.pojos.Employee;
import com.app.pojos.Request;

public interface EmployeeDao {

	int addRequest(Request request,Employee employee,Company company);
	int addEmployee(Employee employee,Company company);
	Employee validate_employee(String username,String password);
	List<Employee> getAllEmp(Company company);
	 public String checkReq(Employee employee);
	 public Request viewStatus(Employee employee);
	 
	 Employee getEmp(int id);

	
}
