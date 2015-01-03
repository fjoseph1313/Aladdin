<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
					<h3 style="margin-left: 16px">Search Results</h3>

<<<<<<< HEAD
					<c:if test="${fn:length(b64s)> 0}">
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
=======
					<c:forEach var="product" items="${searchProducts}">
						<div class="col-sm-4 col-lg-4 col-md-4">
							<div class="thumbnail">
								<img src="data:image/jpg;base64,${product.byteString}" alt="" height="50" width="50">
								<div class="caption">
									<h4 class="pull-right">$${product.price}</h4>
									<h4>
										<a href="#">${product.productName}</a>
									</h4>
									<h5>
										${product.productDescription}
									</h5>
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
>>>>>>> branch 'master' of https://github.com/fjoseph1313/Aladdin
								</div>
							</div>
						</c:forEach>
					</c:if>
					<c:if test="${empty b64s}">

						<p style="margin-left: 19px;">There is no result found</p>
					</c:if>



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
