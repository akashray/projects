package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CompanyDao;
import com.app.dao.EmployeeDao;
import com.app.pojos.Company;
import com.app.pojos.Desk;
import com.app.pojos.Employee;
import com.app.pojos.Request;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyDao cdao;
	
	@Autowired
	private EmployeeDao edao;
	
	
	@Override
	public int registerCompany(Company company) {
		
		return cdao.registerCompany(company);
	}

	@Override
	public Company validateCompany(String username, String password) {
		
		return cdao.validateCompany(username, password);
	}



	@Override
	public Employee validate_employee(String username, String password) {
		
		return edao.validate_employee(username, password);
	}

	

	@Override
	public List<Desk> getAllDesk(Company company) {
		// TODO Auto-generated method stub
		return cdao.getAllDesk(company);
	}

	@Override
	public List<Request> getAllRequest(Company company) {
		// TODO Auto-generated method stub
		return cdao.getAllRequest(company);
	}

	@Override
	public List<Employee> getAllEmp(Company company) {
		// TODO Auto-generated method stub
		return edao.getAllEmp(company);
	}

	@Override
	public int addEmployee(Employee employee, Company company) {
		
		return edao.addEmployee(employee, company);
	}

	@Override
	public int addDesk(Desk desk, Company company) {
		
		return cdao.addDesk(desk, company);
	}

	@Override
	public int addRequest(Request request, Employee employee, Company company) {
		// TODO Auto-generated method stub
		return edao.addRequest(request, employee, company);
	}

	@Override
	public String checkReq(Employee employee) {
		
		return edao.checkReq(employee);
	}

	@Override
	public Request viewStatus(Employee employee) {
		// TODO Auto-generated method stub
		return edao.viewStatus(employee);
	}

	@Override
	public void approveRequest(Request request) {
		// TODO Auto-generated method stub
		cdao.approveRequest(request);
	}

	@Override
	public List<Desk> getAllAvailableDesk(Company company) {
		// TODO Auto-generated method stub
		return cdao.getAllAvailableDesk(company);
	}

	@Override
	public int deleteEmp(int id) {
		
		return cdao.deleteEmp(id);
	}

	@Override
	public Employee getEmp(int id) {
		// TODO Auto-generated method stub
		return edao.getEmp(id);
	}

	@Override
	public int deleteDesk(int id) {
		// TODO Auto-generated method stub
		return cdao.deleteDesk(id);
	}

}
