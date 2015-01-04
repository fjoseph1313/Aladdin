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
		<jsp:include page="menu.jsp">
			<jsp:param value="a" name="a" />
		</jsp:include>
	</nav>

	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<div class="col-md-3">
				<jsp:include page="leftMenuAdmin.jsp">
					<jsp:param value="a" name="a" />
				</jsp:include>
			</div>



			<div class="col-md-9">

				<div class="row carousel-holder">

					<div class="col-md-12">
						<fieldset>
							<legend class="registrationLegend">Vendor Approval List</legend>

						</fieldset>
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
									<td><a href="vendor/edit/${vendor.id}">Activate</a></td>
								</tr>
							</c:forEach>
						</table>




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