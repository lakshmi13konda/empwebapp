<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import ="java.util.List" %>
	<%@page import="com.capgemini.empwebapp.dto.EmployeeBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Page</title>
</head>
<body>
	<a href='./home'>Home</a>
	<a href='./logout' style='float: right;'>Logout</a>
	<form action="./search">
		Search: <input type="text" name="name"
			placeholder="Enter name to search"> 
			<input type="submit" value="Search">
	</form>
	
	<%List<EmployeeBean> beans=(List)request.getAttribute("beans");
	String name=(String)request.getAttribute("name");
	if(name!=null){
	%>
	<%if(beans!=null && !beans.isEmpty()){%>
	<table>
		<tr>
			<td>Name</td>
			<td>Email</td>
		</tr>
<%for(EmployeeBean bean:beans){ %>
		<tr>
			<td><%=bean.getName()%></td>
			<td><%=bean.getEmail()%></td>
		</tr>
		<%} %>
	</table>
	<%}else{ %>
	<h1>No Data found for name<%=name %></h1>
	<%}
	}%>
	
</body>
</html>