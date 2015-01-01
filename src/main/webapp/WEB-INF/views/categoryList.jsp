<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cars currently in the shop</title>
</head>
<body>
	<h1>Categories in Aladdin</h1>
	<table>
	<c:forEach var="category" items="${categories}">
	<tr>
		<td>${category.categoryName}</td>
		<td>${category.categoryDescription}</td>
		
		<td><a href="categories/${category.id}">edit</a></td>
		<td><a href="categories/delete/${category.id}">delete</a></td>
	</tr>
	</c:forEach>
	</table>
	
	<a href="addCategory.jsp"> Add a Category</a>
</body>
</html>