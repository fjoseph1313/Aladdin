<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>
<jsp:include page="header.jsp">
	<jsp:param value="a" name="a" />
</jsp:include>

<title>Aladdin - Registration</title>
</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<jsp:include page="menuAdmin.jsp">
			<jsp:param value="a" name="a" />
		</jsp:include>
	</nav>

	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<div class="col-md-3">
				<jsp:include page="leftMenuVendor.jsp">
					<jsp:param value="a" name="a" />
				</jsp:include>
			</div>



			<div class="col-md-9" style="min-height: 500px">

				<div class="row carousel-holder">

					<div class="col-md-12">
						<fieldset>
							<legend class="registrationLegend">								
									Welcome
									<c:out value="${userDetails.firstName}" />
									!!!
							</legend>

						</fieldset>

						Here vendor can do vendor related actions.
						<p class="bg-success"
							style="font-color: red; margin-top: 10px; ">${sucessmsg}<p>
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