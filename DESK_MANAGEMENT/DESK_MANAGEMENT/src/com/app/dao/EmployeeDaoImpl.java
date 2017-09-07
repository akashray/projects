package com.app.dao;

import java.util.Date;
import java.util.List;

import javax.mail.Session;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Company;
import com.app.pojos.Employee;
import com.app.pojos.Request;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private SessionFactory sf;
	

	@Override
	public int addEmployee(Employee employee,Company company) {
		company.addEmployee(employee);
		sf.getCurrentSession().save(employee);
		return employee.getEmpId();
	}

	@Override
	public Employee validate_employee(String username, String password) {
		Employee employee=(Employee) sf.getCurrentSession().createQuery("select e from Employee e where userName=:u and password=:p").setParameter("u",username).setParameter("p", password).uniqueResult();
		
		if(employee!=null)
		{
			employee.getEmployer().getRequests().size();
			return employee;
		}
			return null;
		
	}

	@Override
	public List<Employee> getAllEmp(Company company) {
		@SuppressWarnings("unchecked")
		List<Employee> emps=sf.getCurrentSession().createQuery("select e from Employee e where CompanyId=:cid").setParameter("cid", company.getCompanyId()).list();
		return emps;
	}

	@Override
	public int addRequest(Request request, Employee employee, Company company) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	public EmployeeDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override 
    public String checkReq(Employee employee) 
    { 
		System.out.println(employee);
		
           //Request req=(Request) sf.getCurrentSession().createQuery("select r from Request r where EmployeeId=:eid").setParameter("eid", employee.getEmpId()).uniqueResult();
		Request req=employee.getRequest();  
		/* org.hibernate.Session session=sf.getCurrentSession();
            String q="select * from Request  where EmployeeId='"+employee.getEmpId()+"'";
            SQLQuery query= session.createSQLQuery(q);
            Request req=(Request) query.uniqueResult();*/
            
           /* Criteria criteria=session.createCriteria(Request.class);
            criteria.add(Restrictions.eq("employee", employee.getEmpId()));
            Request req=(Request)criteria.uniqueResult();*/
           System.out.println(req);
            if(req == null ) 
            { 
                    Request r=new Request(); 
                    
                    r.setEmployee(employee);                     
                    r.setCompany(employee.getEmployer());                     
                    r.setRequestdate(new Date().toString());
                    r.setRequesttype("DeskAllocation");
                    
                    
                    
                    employee.setRequest(r); 
                    
                    Company company=employee.getEmployer();
                    System.out.println(company + "tttttttttttt");
                    
                    company.getRequests().size();
                    /*
                    //reqs.size();
                    company.setRequests();
                    reqs.size();*/
                    company.getRequests().add(r);
                    
                  System.out.println("reqgggg"+company.getRequests());
                    sf.getCurrentSession().save(r); 
                    return "Your request is been sent...!!!!!!"; 
            } 
            else if (req.getReqStatus().equals("Deallocated")) {
            	
            	 System.out.println("in else if.........");
            	req.setApprovalDate(null);
                req.setRequestdate(new Date().toString());
                req.setRequesttype("DeskAllocation");
                req.setReqStatus("Pending");
                sf.getCurrentSession().update(req);
			}
            
                     String msg="Request is already sent....!!!!!!!"; 
                     System.out.println(msg); 
                     return msg; 
           
            
    }


	
	
	 public Request viewStatus(Employee employee)

     {

             Request r=employee.getRequest();
             return r;

     }

	@Override
	public Employee getEmp(int id) {
		// TODO Auto-generated method stub
		return (Employee) sf.getCurrentSession().get(Employee.class, id);
	}


	
	
	
	
	
	
}
