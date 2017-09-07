<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add player</title>
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
                <a class="navbar-brand" href="index.html"><span class="media-heading">${sessionScope.validUser.role }</span></a>
                
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
            <h3 align="center">Add New Desk</h3>
            	<h3 align="center">${requestScope.mesg}</h3>
            	<form:form method="post" modelAttribute="desk">
		<table class="table">
			<tr>
				<td>Serial Id</td>
				<td><form:input path="serialId" required="required"/></td>				
			</tr>
			
			<tr>
				<td><input type="reset" value="Reset" /></td>
				<td><input type="submit" value="Add" /></td>
			</tr>
		</table>

	</form:form>
       		 </div>
       		 
            <!-- /.navbar-collapse -->
  </div>

	
	
</body>
</html>