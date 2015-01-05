<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="readcsv" enctype="multipart/form-data">
		File Directory: <input type="text" name="csvFileName" id="csvFileName" value="C:/Users/FAlegre/Desktop/file.csv" />
		<br> <input value="upload csv" type="submit" />
	</form>
</body>
</html>