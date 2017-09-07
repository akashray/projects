<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Bootstrap Core CSS -->
    <link href="<spring:url value='/css/bootstrap.min.css'></spring:url>" rel="stylesheet" type="text/css">

    <!-- Custom CSS -->
    <link href="<spring:url value='/css/sb-admin.css'></spring:url>"  rel="stylesheet" type="text/css">

    <!-- Morris Charts CSS -->
    <link href="<spring:url value='/css/morris.css'></spring:url>" rel="stylesheet" type="text/css">

    <!-- Custom Fonts -->
    <link href="<spring:url value='/css/font-awesome.min.css'></spring:url>" rel="stylesheet" type="text/css">
    
    <style>
		table {
		    width:60%;
		}
		
		table, th, td {
		    border: 1px solid black;
		    border-collapse: collapse;
		}
		th, td {
		    padding: 5px;
		    text-align: left;
		}
		
		table#t01 tr:nth-child(even) {
		    background-color: #eee;
		}
		table#t01 tr:nth-child(odd) {
		   background-color:#fff;
		}
		table#t01 th {
		    background-color: black;
		    color: white;
		}
	</style>

<title>Admin</title>
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
            	<div style="color:white;text-align:right"><h2>Logged in as ${sessionScope.validEmp.empName }</h2></div>
                <ul class="nav navbar-nav side-nav">
                    <li class="active">
                        <a href="request"> Raise Request</a>
                    </li>
                    <li>
                        <a href="reqStatus"> View Request Status </a>
                    </li>
                    
                     <li>
                        <a href="logoutEmp"> Logout</a>
                    </li>                   
                    
                    
                </ul>
            </div>
            </nav>
            <div id="page-wrapper" style="height: 600px">
            	<h3></h3>
            	<table id="t01">
            		<thead>
	            		<th>Emp ID</th>
	            		<th>Req Date</th>
	            		<th>Status</th>
	            		<th>Approval Date</th>
	            		<th>Allocated Desk</th>
            		</thead>
            		<tr>
            			<td>${sessionScope.validEmp.userName}</td>
            			<td>${sessionScope.req.requestdate}</td>
            			<td>${sessionScope.req.reqStatus}</td>
            			<td>${sessionScope.req.approvalDate}</td>
            			<td>${sessionScope.req.desk.serialId}</td>
            		</tr>
            		
            	</table>
            	<div>
            	
            	</div>
            	
       		 </div>
       		 
           
  </div>

</body>
</html>