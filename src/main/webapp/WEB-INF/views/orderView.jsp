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

<title>Aladdin - Order View</title>
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

				<h3 style="margin-left: 16px">Order Details</h3>

				<div class="row carousel-holder">

					<div class="col-md-12">
						<fieldset>
							<legend class="registrationLegend"></legend>
							<form:form class="form-horizontal registrationForm"
								id="customerRegistrationFormId" action="./payment/${product.id}" method="post">

								<div class="form-group">
									<label for="inputQuantity" class="col-sm-3 control-label">Product Quantity: </label>
									<div class="col-sm-9"><span>10</span></div>
								</div>
								<div class="form-group">
									<label for="inputQuantity" class="col-sm-3 control-label">Order Amount: </label>
									<div class="col-sm-9"><span>$100</span></div>
								</div>

								<div class="form-group">
									<div class="col-sm-offset-1 col-sm-11">
										<button type="submit" class="btn btn-primary signIn">Checkout</button>    <a href="<spring:url value="/" />">Continue Shopping</a> 
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
