<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="../../css/table.css">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body >
		<h1 style="text-align: center;">Customers List</h1>
		<h1 style="text-align: center;"><input type="button" value="Add Customer" class="button" onclick="window.location.href='${pageContext.request.contextPath}/api/customer/showForm'; return false;">
		</h1>
		<table id="customers">
			 <tr>
			 	<th>Customer Id</th>
			 	<th>Customer FirstName</th>
			 	<th>Customer LastName</th>
			 	<th>Customer Email</th>
			 	<th>Action</th>
			 </tr>
			 <c:forEach items="${customersList }" var="customers">
			 <tr>
			   <td>${customers.cid }</td>
			   <td>${customers.firstName }</td>
			   <td>${customers.lastName }</td>
			   <td>${customers.email }</td>
			   <td><a href="${pageContext.request.contextPath}/api/customer/showFromUpdate?customerId=${customers.cid }"><input type="submit" value="update" class="updateButton"></a>
			   <a href="${pageContext.request.contextPath}/api/customer/deleteCustomer?customerId=${customers.cid }"><input type="submit" value="delete" class="deleteButton"></a></td>
			  
			   
			 </tr>
			 </c:forEach>
		</table>
</body>
</html>