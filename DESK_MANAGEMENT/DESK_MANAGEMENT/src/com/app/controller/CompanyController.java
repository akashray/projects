package com.app.controller;

import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.hibernate.exception.ConstraintViolationException;

import com.app.model.EmailSend;
import com.app.pojos.Company;
import com.app.pojos.Desk;
import com.app.pojos.Employee;
import com.app.pojos.Request;
import com.app.service.CompanyService;

@Controller
public class CompanyController {

	@Autowired
	private CompanyService service;
	
	
	
	
	
	@RequestMapping("/companyLogin")
	public String companyLogin(Company company)
	{
		System.out.println("In companyLogin ......");
		
		return "companyLogin";
	}
	
	@RequestMapping(value="/companyLogin",method=RequestMethod.POST)
	public String afterCompanyLogin(Model map,Company company,HttpSession session)
	{
		System.out.println("In afterCompanyLogin ......");
		
		Company validCompany=service.validateCompany(company.getUserName(), company.getPassword());
		if(validCompany==null)
		{
			map.addAttribute("mesg", " UserName or Password is Incorrect..!");
			return "companyLogin";
		}
		
		session.setAttribute("validCompany", validCompany);
		return "company";
	}
	
	
	
	
	
	
	@RequestMapping("/employeeLogin")
	public String employeeLogin(Employee employee)
	{
		System.out.println("In employeeLogin ......");
		
		return "EmployeeLogin";
	}
	
	@RequestMapping(value="/employeeLogin",method=RequestMethod.POST)
	public String afteremployeeLogin(Model map,Employee employee,HttpSession session)
	{
		System.out.println("In afteremployeeLogin ......");
		Employee validEmp=service.validate_employee(employee.getUserName(), employee.getPassword());
		if(validEmp==null)
		{
			map.addAttribute("mesg", " UserName or Password is Incorrect..!");
			return "EmployeeLogin";
		}
		System.out.println(validEmp+"ooooooooooooo");
		session.setAttribute("validEmp", validEmp);
		return "employee";
	}
	
	
	
	
	
	
	@RequestMapping("/companyRegistration")
	public String companyRegistration(Company company)
	{
		System.out.println("In companyRegistration ......");
		
		return "companyRegistration";
	}
	
	@RequestMapping(value="/companyRegistration",method=RequestMethod.POST)
	public String aftercompanyRegistration(Model map ,Company company)
	{
		System.out.println("In aftercompanyRegistration ......");
		int id=service.registerCompany(company);
		System.out.println(id);
		map.addAttribute("mesg", "Successfully Registered..!!!");
		return "companyRegistration";
	}
	
	
	@RequestMapping("/allEmployee")	
	public String allEmployee(HttpSession session)
	{
		if(session.getAttribute("validCompany") != null)
		{
			System.out.println("In allEmployee ......");
			Company company=(Company) session.getAttribute("validCompany");
			List<Employee> employees=service.getAllEmp(company);
			session.setAttribute("emps",employees);
			return "allEmps";
		}
		
		return "redirect:employeeLogin";
	}
	
	
	
	
	@RequestMapping("/allRequests")	
	public String allRequests(HttpSession session,Request request)
	{
		if(session.getAttribute("validCompany") != null)
		{
			System.out.println("In allRequests ......");
			Company company=(Company) session.getAttribute("validCompany");
			List<Request> requests=service.getAllRequest(company);
			session.setAttribute("reqsts",requests);
			List<Desk> desks=service.getAllAvailableDesk(company);
			session.setAttribute("desks",desks);
			return "allRequests";
		}
		return "redirect:employeeLogin";
	}
	
	
	@RequestMapping(value="/allRequests",method=RequestMethod.POST )
	public String approve(Request request,HttpSession session)
	{
		if(session.getAttribute("validCompany") != null)
		{
			System.out.println("in approve............");
			System.out.println(request+"uuuuuuuuuuuuooooooooopppppppppp");
			System.out.println(request.getRequestId()+"oooooooooppppppppppuuuuuuuuuuuu");
			System.out.println(request.getDesk()+"ooooooooopppppppppp");
			if(request.getReqStatus().equals("Pending") || request.getReqStatus().equals("Deallocated"))
			{
				Company company=(Company) session.getAttribute("validCompany");
				service.approveRequest(request);
				List<Request> requests=service.getAllRequest(company);
				session.setAttribute("reqsts",requests);
				List<Desk> desks=service.getAllAvailableDesk(company);
				session.setAttribute("desks",desks);
				return "allRequests";
			}
			return "allRequests";
		}
		return "redirect:employeeLogin";
	}
	
	
	
	@RequestMapping("/deleteUser")	
	public String deleteUser(HttpSession session,HttpServletRequest httpRequest)
	{
		System.out.println("In deleteUser ......");
		Company company=(Company) session.getAttribute("validCompany");
		int id=Integer.parseInt(httpRequest.getParameter("userId"));
		int empid=service.deleteEmp(id);
		System.out.println("Emp Deleted : empid "+empid);
		List<Employee> emps=service.getAllEmp(company);
		System.out.println(emps);
		session.setAttribute("emps",emps);
		
		return "allEmps";
	}
	
	@RequestMapping("/deleteDesk")	
	public String deleteDesk(HttpSession session,HttpServletRequest httpRequest)
	{
		System.out.println("In deleteDesk ......");
		Company company=(Company) session.getAttribute("validCompany");
		int id=Integer.parseInt(httpRequest.getParameter("deskId"));
		
		int deskid=service.deleteDesk(id);
		
		System.out.println("Desk Deleted : empid "+deskid);
		List<Desk> desks=service.getAllDesk(company);
		System.out.println(desks);
		session.setAttribute("desks",desks);
		
		return "allDesks";
	}
	
	@RequestMapping("/allDesks")	
	public String alldESKs(HttpSession session)
	{
		if(session.getAttribute("validCompany") != null)
		{
			System.out.println("In alldESKs ......");
			Company company=(Company) session.getAttribute("validCompany");
			List<Desk> desks=service.getAllDesk(company);
			System.out.println(desks);
			session.setAttribute("desks",desks);
			
			return "allDesks";
		}
		return "redirect:employeeLogin";
	}
	
	
	
	
	
	
	
	
	
	
	
	@ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@RequestMapping("/error")
	public String constraintsVoilation(HttpServletRequest request)
	{
		String r1="";
		 String referer = request.getHeader("Referer");
		 System.out.println("  PREVIOUS PAGE : "+ referer);
		 StringTokenizer st2 = new StringTokenizer(referer, "/");
		 while (st2.hasMoreElements()) {
				System.out.println(st2.nextElement());
				r1=(String)st2.nextElement();
				
		 		}
		 System.out.println("LAST ELEMENT  : "+r1);
		return "redirect:"+r1;
	}
	
	
	
	@ExceptionHandler(NullPointerException.class)
   // @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	//@RequestMapping("/error")
	public String nullPointerVoilation()
	{
		
		return "redirect:employeeLogin";
	}
	
	@RequestMapping("/addEmployee")
	public String addEmployee(Employee employee,HttpSession session)
	{
		System.out.println("session : "+session);
		if(session.getAttribute("validCompany") != null)
		{
			System.out.println("in addEmployee");
			
			return "addEmployee";
		}
		return "redirect:employeeLogin";
	}
	
	@RequestMapping(value="/addEmployee",method=RequestMethod.POST)
	public String afteraddEmployee(Employee employee,Model map,HttpSession session)
	{
		
			System.out.println("in afteraddEmployee");
			Company company=(Company) session.getAttribute("validCompany");
			service.addEmployee(employee, company);
			map.addAttribute("mesg", "Employee added successfully with id " + employee.getEmpId());
			session.setAttribute("validCompany", company);
			
			String email = employee.getEmail();
			System.out.println("sending"+email);
			System.out.println(employee.getEmpName() + email + employee.getPassword() + employee.getUserName() );
			
			//Fetch data From data base
			EmailSend e = new EmailSend();
				e.sendMail(employee.getEmpName(),email,employee.getPassword(),employee.getUserName());
			
			return "addEmployee";
		
		
	}
	
	
	@RequestMapping("/addDesk")
	public String addDesk(Desk desk,HttpSession session)
	{
		if(session.getAttribute("validCompany") != null)
		{
			System.out.println("in addDesk");
			return "addDesk";
		}
		return "redirect:employeeLogin";
	}
	
	@RequestMapping(value="/addDesk",method=RequestMethod.POST)
	public String afterAddDesk(Desk desk,Model map,HttpSession session)
	{
		
			System.out.println("in afterAddDesk");
			Company company=(Company) session.getAttribute("validCompany");
			service.addDesk(desk, company);
			map.addAttribute("mesg", "Desk added successfully with id " + desk.getDeskId());
			session.setAttribute("validCompany", company);
			return "addDesk";
		
	}
	
	
	
	
	@RequestMapping(value="/logout")
	public String logout(HttpSession session,Model model)
	{
		System.out.println("in logout");
		session.setAttribute("validCompany", null);
		session.invalidate();
		model.addAttribute("mesg", "seccessfully logged out...!!!!");
		return "logout";
	}
	
	
	
	@RequestMapping(value="/logoutEmp")
	public String logoutemp(HttpSession session,Model model)
	{
		System.out.println("in logout");
		session.setAttribute("validEmp", null);
		session.invalidate();
		model.addAttribute("mesg", "seccessfully logged out...!!!!");
		return "logout";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	@RequestMapping("showStatus")
	public String showStatus(HttpSession session)
	{
		System.out.println("in showStatus");
		return "showStatus";
	}*/
	
	
	
	
	@RequestMapping("/request")	
	public String request(HttpSession session)
	{
		System.out.println("in request");
		return "raiseReq";
	}
	
	@RequestMapping(value="/request",method=RequestMethod.POST)	
	public String afterRequest(HttpSession session,Model map)
	{
		System.out.println("in afterRequest");
		Employee e=(Employee)session.getAttribute("validEmp");
		System.out.println(e + "ffffffffffff");
		String msg=service.checkReq(e);
		map.addAttribute("msg", msg);
		session.setAttribute("validEmp", e);
		return "raiseReq";
	}
	
	
	
	
	
	
	
	@RequestMapping(value="/reqStatus")	
	public String afterreqStatus(HttpSession session)
	{
		System.out.println("in afterreqStatus");
		Employee employee=(Employee)session.getAttribute("validEmp");
		
		Employee e=service.getEmp(employee.getEmpId());
		System.out.println(service.viewStatus(e)+"llllllllllllllllllllllllllll");
		
		session.setAttribute("req", e.getRequest());
		session.setAttribute("validEmp", e);
		return "ViewStatus";
	}
	
}
	





