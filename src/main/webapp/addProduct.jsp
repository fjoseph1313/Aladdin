<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Aladdin Online Shopping</title>
</head>
<body>
	<h2>Add New Product</h2>
	<form action="/products" method = "post"> 
		<table>
			<tr>
				<td>Product Name : </td>
				<td><input type= "text" name = "productName" /> </td>
			</tr>
			<tr>
				<td>Product Description :</td>
				<td><input type = "text" name = "productDescription" /></td>
			</tr>
			<tr>
				<td>Price : </td>
				<td><input type = "text" name = "price" /><</td>
			</tr>
			<tr>
				<td>Product Category :</td>
				<td>
					<select name = "category_id">
						<c:forEach var = "cat" items = "" >
							<option value = ""><c:out value=""/></option>
						</c:forEach>
					</select>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>