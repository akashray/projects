package com.app.dao;

import java.util.List;

import com.app.pojos.Company;
import com.app.pojos.Desk;
import com.app.pojos.Request;

public interface CompanyDao {

	int registerCompany(Company company);
	Company validateCompany(String username,String password);
	
	
	int addDesk(Desk desk,Company company);
	List<Desk> getAllDesk(Company company);
	List<Desk> getAllAvailableDesk(Company company);
	List<Request> getAllRequest(Company company);
	int deleteEmp(int id);
	int deleteDesk(int id);
	
	
	void approveRequest(Request request);
}
