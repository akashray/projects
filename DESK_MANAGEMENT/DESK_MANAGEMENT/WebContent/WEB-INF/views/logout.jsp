<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Bootstrap Core CSS -->
    <link href="<spring:url value='/css/bootstrap.min.css'></spring:url>" rel="stylesheet" type="text/css">

    <!-- Custom CSS -->
    <link href="<spring:url value='/css/sb-admin.css'></spring:url>"  rel="stylesheet" type="text/css">

    <!-- Morris Charts CSS -->
    <link href="<spring:url value='/css/morris.css'></spring:url>" rel="stylesheet" type="text/css">

    <!-- Custom Fonts -->
    <link href="<spring:url value='/css/font-awesome.min.css'></spring:url>" rel="stylesheet" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="1;url=${pageContext.request.contextPath}">

</head>
<body>
<h3>${requestScope.mesg } </h3>
<h3>You will be taken to home page shortly..</h3>
</body>
</html>