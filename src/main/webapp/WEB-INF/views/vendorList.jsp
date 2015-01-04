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
	<h1>Vendors List for Approval</h1>
	<table class="table table-striped">
	<tr>
		<td>Business Name</td>
		<td>Manager's First Name</td>
		<td>Manager's Last Name</td>
		<td>Action</td>
	 </tr>
	<c:forEach var="vendor" items="${lists}">
	<tr>
		<td>${vendor.businessName}</td>
		<td>${vendor.firstName}</td>
		<td>${vendor.lastName}</td>
		<td><a href ="vendor/edit/${vendor.id}">Activate</a></td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>