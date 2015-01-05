<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
				<div class="row carousel-holder">

					<div class="col-md-12">
						<fieldset>
							<legend class="registrationLegend"></legend>
							<form:form class="form-horizontal registrationForm"
								id="customerRegistrationFormId" action="./order/${product.id}" method="post">

								<div class="form-group">
									<label for="inputQuantity" class="col-sm-3 control-label">Product Quantity</label>
									<div class="col-sm-9">
										<input type="text"
											class="form-control validate[required] text-input" data-errormessage-value-missing="Product Quantity is required!" 
											id="inputQuantity" placeholder="Product Quantity"
											style="width: 200px" name="quantity">
									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-offset-3 col-sm-9">
										<button type="submit" class="btn btn-primary signIn">Add to Cart</button>
									</div>
								</div>
							</form:form>
						</fieldset>
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
