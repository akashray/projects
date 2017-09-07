<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Participants</title>
<!-- Bootstrap Core CSS -->
    <link href="<spring:url value='/css/bootstrap.min.css'></spring:url>" rel="stylesheet" type="text/css">

    <!-- Custom CSS -->
    <link href="<spring:url value='/css/sb-admin.css'></spring:url>"  rel="stylesheet" type="text/css">

    <!-- Morris Charts CSS -->
    <link href="<spring:url value='/css/morris.css'></spring:url>" rel="stylesheet" type="text/css">

    <!-- Custom Fonts -->
    <link href="<spring:url value='/css/font-awesome.min.css'></spring:url>" rel="stylesheet" type="text/css">
</head>
<body>

<div id="wrapper">
 <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
  <div class="navbar-header">
                <!-- <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button> -->
                <a class="navbar-brand" href="#"><span class="media-heading">${sessionScope.validUser.role }</span></a>
                
            </div>
  <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
            	<div style="color:white;text-align:right"><h2>Logged in as ${sessionScope.validCompany.companyName }</h2></div>
                <ul class="nav navbar-nav side-nav">
                     <li class="active">
                        <a href="allEmployee"> Employees</a>
                    </li>
                    <li>
                        <a href="addEmployee"> Add Employee</a>
                    </li>
                    <li>
                        <a href="allDesks"> All Desks</a>
                    </li>
                     <li>
                        <a href="addDesk">Add Desk</a>
                    </li>
                     <li>
                        <a href="allRequests"> Show All Requests</a>
                    </li>
                    
                     <li>
                        <a href="logout"> Logout</a>
                    </li> 
                    
                </ul>
            </div>
            </nav>
            <div id="page-wrapper" style="height: 600px">
            	<h3 style="text-align: center;">All Desks</h3>
				<h3 style="text-align: center;">${requestScope.mesg }</h3>
            	<table class="table table-hover">
				<thead>
				<tr style="font-weight: bold;">
				<td >Desk Id</td>
				<td>Serial Id</td>		
				<td>Status</td>
				<td>Employee Name</td>
				
				<td></td>
				
				</tr>
				</thead>
				<s:forEach var="user" items="${sessionScope.desks }">
				<tr>
				<td>${user.deskId }</td>
				<td>${user.serialId} </td>
				<td>${user.status }</td>
				<td>${user.employee1.empName }</td>
				<td>
				 <form:form action="deleteDesk" method="post">
				<input type="hidden" name="deskId" value="${user.deskId }">
				<input type="submit" value="DeallocateDesk">
				</form:form>
				</td>
				<%-- <td>
				<form:form action="updateUser">
				<input type="hidden" name="userId" value="${player.userId }">
				<input type="submit" value="Update">
				</form:form></td> --%>
				<td>
				<%-- <form:form action="deleteUser" method="post">
				<input type="hidden" name="userId" value="${user.userId }">
				<input type="submit" value="Delete">
				</form:form> --%>
				</td>
				</tr>
				</s:forEach>
				</table>
       		 </div>
       		 
            <!-- /.navbar-collapse -->
  </div>

</body>
</html>