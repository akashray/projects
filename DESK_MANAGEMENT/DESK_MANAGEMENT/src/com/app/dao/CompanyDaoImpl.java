package com.app.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Company;
import com.app.pojos.Desk;
import com.app.pojos.Employee;
import com.app.pojos.Request;

@Repository
public class CompanyDaoImpl implements CompanyDao {

	@Autowired
	private SessionFactory sf;
	
	
	@Override
	public int registerCompany(Company company) {
		sf.getCurrentSession().save(company);
		return company.getCompanyId();
	}

	@Override
	public Company validateCompany(String username,String password) {
		Company company=(Company) sf.getCurrentSession().createQuery("select c from Company c where userName=:u and password=:p").setParameter("u",username).setParameter("p", password).uniqueResult();
		if(company!= null)
		{
			company.getDesks().size();
			company.getEmployees().size();
			company.getRequests().size();
			return company;
		}
		return null;
	}

	

	@Override
	public List<Desk> getAllDesk(Company company) {
		@SuppressWarnings("unchecked")
		List<Desk> desks=sf.getCurrentSession().createQuery("select e from Desk e where CompanyId=:cid").setParameter("cid", company.getCompanyId()).list();
		return desks;
	}
	
	@Override
	public List<Desk> getAllAvailableDesk(Company company) {
		@SuppressWarnings("unchecked")
		List<Desk> desks=sf.getCurrentSession().createQuery("select e from Desk e where status=:s and CompanyId=:cid").setParameter("s", "Available").setParameter("cid", company.getCompanyId()).list();
		return desks;
	}

	@Override
	public List<Request> getAllRequest(Company company) {
		@SuppressWarnings("unchecked")
		List<Request> reqs=sf.getCurrentSession().createQuery("select r from Request r where CompanyId=:cid").setParameter("cid", company.getCompanyId()).list();
		return reqs;
	}

	@Override
	public int addDesk(Desk desk, Company company) {
		
		company.addDesk(desk);
		return (int) sf.getCurrentSession().save(desk);
	}

	@Override
	public void approveRequest(Request request) {
		
		Request r=(Request) sf.getCurrentSession().get(Request.class, request.getRequestId());
		System.out.println("REQQQQQQQQQQQQQQQ"+r);
		r.setReqStatus("Allocated");
		r.setApprovalDate(new Date().toString());
		
		
		Employee e=r.getEmployee();
		
		int id=request.getDesk().getDeskId();
		Desk d=(Desk) sf.getCurrentSession().get(Desk.class, id);
		
		System.out.println("DESSSKKKKKKhhhhhhhhhhh"+d);
		d.setStatus("Occupied");
		
		e.setDesk(d);
		d.setEmployee1(e);
		
		d.setRequest(r);
		r.setDesk(d);
		
		sf.getCurrentSession().saveOrUpdate(d);
		sf.getCurrentSession().saveOrUpdate(r);
		
	}

	@Override
	public int deleteEmp(int id) {
		Employee e=(Employee)sf.getCurrentSession().get(Employee.class,id);
		if(e.getDesk()!=null)			
			e.getDesk().setStatus("Available");
		
		sf.getCurrentSession().delete(e);
		return e.getEmpId();
	}

	@Override
	public int deleteDesk(int id) {
		Desk d=(Desk)sf.getCurrentSession().get(Desk.class,id);
		if(d.getStatus().equals("Occupied"))
		{
		d.setEmployee1(null);
		d.setStatus("Available");
		d.getRequest().setReqStatus("Deallocated");
		d.setRequest(null);
		//d.getRequest().getDesk().setSerialId(null);
		}
		
		
		sf.getCurrentSession().update(d);
		return d.getDeskId();
	}

}
