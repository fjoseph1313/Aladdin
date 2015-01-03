<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<jsp:include page="header.jsp">
	<jsp:param value="a" name="a" />
</jsp:include>

<title>Aladdin - Home</title>
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

				<div class="row">

					<c:forEach var="listValue" items="${b64s}">

						<div class="col-sm-4 col-lg-4 col-md-4">
							<div class="thumbnail">
								<img src="data:image/jpg;base64,${listValue}" alt="">
								<div class="caption">
									<h4 class="pull-right">$24.99</h4>
									<h4>
										<a href="#">First Product</a>
									</h4>
									<p>
										See more snippets like this online store item at <a
											target="_blank" href="http://www.bootsnipp.com">Bootsnipp
											- http://bootsnipp.com</a>.
									</p>
								</div>
								<div class="ratings">
									<p class="pull-right">15 reviews</p>
									<p>
										<span class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span> <span
											class="glyphicon glyphicon-star"></span>
									</p>
								</div>
							</div>
						</div>
					</c:forEach>



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
