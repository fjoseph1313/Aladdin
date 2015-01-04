<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html lang="en">

<head>
<jsp:include page="header.jsp">
	<jsp:param value="a" name="a" />
</jsp:include>

<title>Aladdin - Home</title>
</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<jsp:include page="menu.jsp">
			<jsp:param value="a" name="a" />
		</jsp:include>
	</nav>

	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<div class="col-md-3">
				<jsp:include page="leftMenu.jsp">
					<jsp:param value="a" name="a" />
				</jsp:include>
			</div>



			<div class="col-md-9">

				<h3 style="margin-left: 16px">Product Deatils</h3>
				<hr style="padding: 0px; margin: 0px;">

				<div class="row" style="margin-top: 21px;">

					<div class="col-md-6"
						style="width: 210px; padding: 0px; margin: 0px 0 0 16px;">
						<img src="data:image/jpg;base64,${imageInfo}" alt="" height="200"
							width="200" class="img-thumbnail">
					</div>

					<div class="col-md-6" style="width: 100px;padding: 0px; margin: 0px 0 0 10px;">
						<p style="width:padding: 0px; margin: 0px;"><b>Name:</b></p><hr style="padding: 0px; margin: 0px 0 5px 0;border-color: black">
						<p style="width:padding: 0px; margin: 0px;">${product.productName}</p>
						<p style="width:padding: 0px; margin: 5px 0 0 0;"><b>Description:</b></p><hr style="padding: 0px; margin: 0px 0 5px 0;border-color: black">
						<p style="width:padding: 0px; margin: 0px;">${product.productDescription}</p>
						<p style="width:padding: 0px; margin: 5px 0 0 0;"><b>Price:</b></p><hr style="padding: 0px; margin: 0px 0 5px 0;border-color: black">
						<p style="width:padding: 0px; margin: 0px;">$${product.price}</p>
					</div>

				</div>





			</div>

		</div>

	</div>

	</div>
	<!-- /.container -->

	<jsp:include page="footer.jsp">
		<jsp:param value="a" name="a" />
	</jsp:include>

</body>

</html>
