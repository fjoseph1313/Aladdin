<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Aladdin Online Shopping</title>
</head>
<body>
<h2>Edit Product Category</h2>
	<form action="../categories/${category.id}" method="post">
		<table>
			<tr>
				<td>Product Category :</td>
				<td><input type="text" name="categoryName" value = "${category.categoryName}"/></td>
			</tr>
			<tr>
				<td>Category Description:</td>
				<td><input type="text" name="categoryDescription" value = "${category.categoryDescription}"/></td>
			</tr>

		</table>
		<input type="submit" value="Edit Category" />

	</form>
</body>
</html>