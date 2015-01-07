<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" import="javax.servlet.jsp.PageContext"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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


					<c:if test="${not empty error}">
						<div class="error">
							Your login attempt was not successful, try again.<br /> Reason:
							${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
						</div>
					</c:if>

					<div class="col-md-12">
						<fieldset>
							<legend class="registrationLegend">Login</legend>
						</fieldset>


						<form name="f" action="<c:url value='j_spring_security_check'/>"
							method="POST">




							<table>
								<tr>
									<td>Username:</td>
									<td><input type='text' name='j_username'
										class="form-control" /></td>
								</tr>
								<tr></tr>
								<tr>
									<td>Password:</td>
									<td><input type='password' name='j_password'
										class="form-control"></td>
								</tr>
								<tr>
									<td colspan="2">&nbsp;</td>
								</tr>
								<tr>
									<td colspan='2'><input name="submit" type="submit"
										class="btn btn-primary">&nbsp;<input name="reset"
										type="reset" class="btn btn-primary"></td>
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