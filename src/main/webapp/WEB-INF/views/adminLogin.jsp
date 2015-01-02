<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
				<p class="lead">Categories</p>
				<div class="list-group">
					<a href="#" class="list-group-item">Category 1</a> <a href="#"
						class="list-group-item">Category 2</a> <a href="#"
						class="list-group-item">Category 3</a>
				</div>

				<div class="col-sm-12" id="searchProduct">
					<p class="lead">Search By</p>
					<form>
						<p>Keyword</p>
						<p>
							<input type="text" class="form-control" />
						</p>
						<p>Category</p>
						<p>
							<select class="form-control">
								<option>Electronics</option>
								<option>Computer</option>
							</select>
						</p>
						<p>
							<input type="button" class="btn btn-default" value="search" />
						</p>
					</form>

				</div>
			</div>



			<div class="col-md-9">

				<div class="row carousel-holder">

					<div class="col-md-12">
						<fieldset>
							<legend class="registrationLegend">Registration</legend>
							<form:form modelAttribute="loginAdmin" class="form-horizontal loginAdmin"
								id="loginAdmin">

								<div class="form-group">
									<label for="inputFirstName" class="col-sm-2 control-label">First
										Name</label>
									<div class="col-sm-10">
										<input type="text"
											class="form-control validate[required] text-input" data-errormessage-value-missing="First Name is required!" 
											id="inputFirstName" placeholder="First Name"
											style="width: 200px">
									</div>
								</div>


								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<button type="submit" class="btn btn-primary signIn">Sign
											in</button>
									</div>
								</div>
							</form:form>
						</fieldset>
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
