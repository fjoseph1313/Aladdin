<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>
<jsp:include page="header.jsp">
	<jsp:param value="a" name="a" />
</jsp:include>

<title>Aladdin-User List</title>
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
							<legend class="registrationLegend">User List</legend>

						</fieldset>
						<table class="table table-striped">
							<tr>
								<td>First Name</td>
								<td>Last Name</td>
								<td>Email Address</td>
								<td>Action</td>
							</tr>
							<c:forEach var="person" items="${lists}">
								<tr>
									<td>${person.firstName}</td>
									<td>${person.lastName}</td>
									<td>${person.emailAddress}</td>
									<td><c:if test="${person.enable eq false}">
											<a href="user/status/${person.id}&&true">Activate</a>

										</c:if> <c:if test="${person.enable eq true}">
											<a href="user/status/${person.id}&&true"
												style="pointer-events: none; cursor: default; color: Grey; text-decoration: none">Activate</a>
										</c:if> <c:if test="${person.enable eq false}">
											<a href="user/status/${person.id}&&false"
												style="pointer-events: none; cursor: default; color: Grey; text-decoration: none">DeActivate</a>
										</c:if> <c:if test="${person.enable eq true}">
											<a href="user/status/${person.id}&&false">DeActivate</a>
										</c:if></td>
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