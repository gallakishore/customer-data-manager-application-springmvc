<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../css/table.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="text-align: center;">Customer Form</h1>
	<form:form method="post" modelAttribute="customer"
		action="saveCustomer">
		<form:hidden path="cid" />
		<table id="customers">
			<tr>
				<th>FirstName</th>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<th>LastName</th>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<th>Email</th>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<th></th>
				<td><a><input type="submit" value="save" class="button"/></a></td>
			</tr>
		</table>
	</form:form>
	<h1 style="text-align: center;">
		<a href="${pageContext.request.contextPath }/api/customer/list">Customers List</a>
	</h1>

</body>
</html>