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
				<jsp:include page="leftMenu.jsp">
					<jsp:param value="a" name="a" />
				</jsp:include>
			</div>



			<div class="col-md-9">

				<div class="row carousel-holder">

					<div class="col-md-12">
						<fieldset>
							<legend class="registrationLegend">Product</legend>

						</fieldset>


						<form name="f" action="<c:url value='j_spring_security_check'/>"
							method="POST">
							<table>
								<tr>
									<td>Username:</td>
									<td><input type='text' name='j_username' /></td>
								</tr>
								<tr>
									<td>Password:</td>
									<td><input type='password' name='j_password'></td>
								</tr>
								<tr>
									<td colspan="2">&nbsp;</td>
								</tr>
								<tr>
									<td colspan='2'><input name="submit" type="submit">&nbsp;<input
										name="reset" type="reset"></td>
								</tr>
							</table>
						</form>


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