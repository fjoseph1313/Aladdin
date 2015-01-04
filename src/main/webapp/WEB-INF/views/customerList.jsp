<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<jsp:include page="header.jsp">
	<jsp:param value="a" name="a" />
</jsp:include>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Vendors List</title>
</head>
<body>
	<h1>Customer List </h1>
	<table class="table table-striped">
	<tr>
		<td>First Name</td>
		<td>Last Name</td>
		<td>Email Address</td>
		<td>Action</td>
	 </tr>
	<c:forEach var="customer" items="${lists}">
	<tr>
		<td>${customer.firstName}</td>
		<td>${customer.lastName}</td>
		<td>${customer.emailAddress}</td>
		<td><a href ="customer/edit/${customer.id}">DeActivate</a></td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>