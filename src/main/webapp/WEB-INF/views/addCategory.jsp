<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>
<jsp:include page="header.jsp">
	<jsp:param value="a" name="a" />
</jsp:include>

<title>Aladdin - AddProduct</title>
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
							<legend class="registrationLegend">Add New Category</legend>

							<form:form modelAttribute="newCategory" class="form-horizontal"
								enctype="multipart/form-data">
								<div class="col-lg-10">
									<div class="form-group">
										<label for="inputCategoryName" class="col-sm-2 control-label">Category
											Name</label>
										<div class="col-sm-10">
											<form:input id="inputCategoryName" path="categoryName"
												type="text"
												class="form-control validate[required] text-input"
												data-errormessage-value-missing="Name is required!"
												placeholder="Category Name" style="width: 200px" />
										</div>
									</div>
									<div class="form-group">
										<label for="inputCategoryDescription"
											class="col-sm-2 control-label">Category Description</label>
										<div class="col-sm-10">
											<form:textarea
												class="form-control validate[required] text-input"
												id="inputCategoryDescription" style="width: 200px"
												placeholder="Category Description"
												data-errormessage-value-missing="Product Description is required!"
												path="categoryDescription"></form:textarea>
										</div>
									</div>


									<div class="form-group">
										<div class="col-lg-offset-2 col-lg-10">
											<input type="submit" id="btnAdd" class="btn btn-primary"
												value="Add Category" />
										</div>
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
