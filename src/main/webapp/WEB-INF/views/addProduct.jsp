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
							<legend class="registrationLegend">Add New Product</legend>

							<form:form modelAttribute="newProduct" class="form-horizontal"
								enctype="multipart/form-data">
								<div class="col-lg-10">
									<div class="form-group">
										<label for="inputProductName" class="col-sm-2 control-label">Product
											Name</label>
										<div class="col-sm-10">
											<form:input id="inputProductName" path="productName"
												type="text"
												class="form-control validate[required] text-input"
												data-errormessage-value-missing="Name is required!"
												placeholder="Product Name" style="width: 200px" />
										</div>
									</div>
									<div class="form-group">
										<label for="inputProductDescription"
											class="col-sm-2 control-label">Product Description</label>
										<div class="col-sm-10">
											<form:textarea
												class="form-control validate[required] text-input"
												id="inputProductDescription" style="width: 200px"
												placeholder="Product Description"
												data-errormessage-value-missing="Product Description is required!"
												path="productDescription"></form:textarea>
										</div>
									</div>
									<div class="form-group">
										<label for="inputProductPrice" class="col-sm-2 control-label">Price</label>
										<div class="col-sm-10">
											<form:input type="text"
												class="form-control validate[required] text-input"
												data-errormessage-value-missing="Price is required!"
												id="inputProductPrice" placeholder="Product Price"
												style="width: 200px" path="price" />
										</div>
									</div>
									<div class="form-group">
										<label for="inputProductQuantity"
											class="col-sm-2 control-label">Product Quantity</label>
										<div class="col-sm-10">
											<form:input type="text"
												class="form-control validate[required] text-input"
												data-errormessage-value-missing="Price is required!"
												id="inputProductQuantity" placeholder="Product Quantity"
												style="width: 200px" path="productQuantity" />
										</div>
									</div>
									<div class="form-group">
										<label for="inputProductAvailability"
											class="col-sm-2 control-label">Available</label>
										<div class="col-sm-10">
											<form:checkbox path="activeState"
												class="form-control validate[required]"
												data-errormessage-value-missing="Please give the state"
												id="inputProductAvailability" style="width: 30px" />
										</div>
									</div>
									<div class="form-group">
										<label for="inputProductImage" class="col-sm-2 control-label">Product
											Image</label>
										<div class="col-sm-10">
											<form:input type="file" id="inputProductImage"
												class="form-control validate[required] text-input"
												style="width: 250px" path="multiPartToByte" name="file" />
										</div>
									</div>
									<div class="form-group">
										<label for="productCategory" class="col-sm-2 control-label">Product
											Category</label>
										<div class="col-sm-10">
										<form:select path="productCategory">
    										<form:options items="${productcategoryList}" />
										</form:select>
										
										</div>
									</div>

									<div class="form-group">
										<div class="col-lg-offset-2 col-lg-10">
											<input type="submit" id="btnAdd" class="btn btn-primary"
												value="Add Product" />
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
