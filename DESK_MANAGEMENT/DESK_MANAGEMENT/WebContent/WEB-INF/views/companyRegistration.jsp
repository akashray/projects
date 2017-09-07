<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta charset="utf-8">
	<title>DMS</title>
	 <link rel="stylesheet" href='<spring:url value="/css/animate.css"></spring:url>' type="text/css">
	 <link rel="stylesheet" href='<spring:url value="/css/style.css"></spring:url>' type="text/css">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
<body>

	<div class="container">
		<div class="top">
			<h1 id="title" class="hidden"><span id="logo"></span> <span>Desk Management System</span></h1>
		</div>
		<div class="login-box animated fadeInUp">
			<div class="box-header">
				<h2>Company Registration</h2>
				<h2>${requestScope.mesg }</h2>
			</div>
			<div>
<form:form method="post" modelAttribute="company" >
		<table class="table" style="width: 350px;">
			<tr>
				<td>Company Name</td>
				<td><form:input path="companyName" required="required"/></td>
				<td><form:errors path="companyName" />
			</tr>
			<tr>
				<td>Registration Id</td>
				<td><form:input path="registrationId" required="required"/></td>				
				<td><form:errors path="registrationId" />
			</tr>
			<tr>
				<td>UserName</td>
				<td><form:input path="userName" required="required"/></td>
				<td><form:errors path="userName" />
			</tr>			
			<tr>
				<td>Password</td>
				<td><form:password path="password" required="required" minlength="8"/></td>				
				<td><form:errors path="password" />
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" type="email"/></td>
				<td><form:errors path="email" />
			</tr>

			<tr>
				<td><input type="reset" value="Reset" /></td>
				<td><input type="submit" value="Register" /></td>
			</tr>
		</table>

	</form:form>
	</div>
<!-- 			<label for="username">Username</label> -->
<!-- 			<br/> -->
<!-- 			<input type="text" id="username"> -->
<!-- 			<br/> -->
<!-- 			<label for="password">Password</label> -->
<!-- 			<br/> -->
<!-- 			<input type="password" id="password"> -->
<!-- 			<br/> -->
<!-- 			<button type="submit">Sign In</button> -->
<!-- 			<br/> -->
			
			<a href='${pageContext.request.contextPath}'><p class="small">Company Login</p></a>
			
		</div>

	</div>

</body>

<!--  
<script>
	$(document).ready(function () {
    	$('#logo').addClass('animated fadeInDown');

    	$("input:text:visible:first").focus();
	});

	$('#username').focus(function() {

		$('label[for="username"]').addClass('selected');});

	$('#username').blur(function() {

		$('label[for="username"]').removeClass('selected');});

	$('#password').focus(function() {

		$('label[for="password"]').addClass('selected');});

	$('#password').blur(function() {

		$('label[for="password"]').removeClass('selected');
	});

</script>
-->

</html>