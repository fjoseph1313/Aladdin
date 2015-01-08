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
							<legend class="registrationLegend">Payment Information</legend>
							<p>${errormessage}
							<form:form class="form-horizontal" 
								action = "../payment" method = "post">
								<div class="col-lg-10">
									<div class="form-group">
										<label for="inputCard" class="col-sm-2 control-label">Card Number :</label>
										<div class="col-sm-10">
											<input id="inputCard" name="cardNumber"
												type="text"
												class="form-control validate[required] text-input"
												data-errormessage-value-missing="Card Number is required!"
												placeholder="16 Digits Number" style="width: 200px" />
										</div>
									</div>
									<div class="form-group">
										<label for="inputCVV"
											class="col-sm-2 control-label">CVV :</label>
										<div class="col-sm-10">
											<input type = "text"
												class="form-control validate[required] text-input"
												id="inputCVV" style="width: 200px"
												placeholder="cvv"
												data-errormessage-value-missing="Please provide CVV!"
												name="cvv"/>
										</div>
									</div>
									
									<div class="form-group">
										<label for="inputexpiredate"
											class="col-sm-2 control-label">Expiry Date : </label>
										<div class="col-sm-10">
											<input type = "text"
												class="form-control validate[required] text-input"
												id="inputexpiredate" style="width: 200px"
												placeholder="(MM/YY)"
												data-errormessage-value-missing="Expiry Date is required!"
												name="expireDt" />
										</div>
									</div>


									<div class="form-group">
										<div class="col-lg-offset-2 col-lg-10">
											<input type="submit" id="btnAdd" class="btn btn-primary"
												value="Make Payment" />
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
