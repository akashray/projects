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
<title>Employee</title>
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
            	<h3>DESK MANAGEMENT SYSTEM...</h3>
            	
       		 </div>
       		 
            <!-- /.navbar-collapse -->
  </div>
<!-- <h3>Welcome Admin, your are incharge here...</h3>
<h3><a href="allUsers">Participants</a></h3>
<h3><a href="addPlayer">Add Player</a></h3>
<h3><a href="allTransactions">Transfers of the Season</a></h3>
<h3><a href="allBids">All bids</a></h3>
<h3><a href="updatePlayerOrDelete">UpdateOrDelete Player </a></h3>
<h3><a href="showPlayers">Show Players</a></h3>
<h3><a href="addVenue">Add venue</a></h3>
<h3><a href="showAllVenues">Venues</a></h3>
<h3><a href="generate_schedule">Generate Match Schedule</a></h3>
<h3><a href="showMatchesSchedule">Matches Schedule</a></h3>
<h3><a href="startAuction">Start Auction</a></h3>
<h3><a href="logout">Logout</a></h3> -->
</body>
</html>