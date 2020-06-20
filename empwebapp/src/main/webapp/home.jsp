<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <jsp:useBean id="bean" class="com.capgemini.empwebapp.dto.EmployeeBean" scope="session"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<a href='./changepassword.html'>Change Password</a>
<a href='./logout'Style='float: right'>Logout</a>
<h1>Welcome <%=bean.getName() %></h1>
<a href='./search'>Search</a>
</body>
</html>