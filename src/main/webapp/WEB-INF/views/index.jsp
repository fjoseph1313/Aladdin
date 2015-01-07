<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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

				<div class="row carousel-holder">

					<div class="col-md-12">
						<div id="carousel-example-generic" class="carousel slide"
							data-ride="carousel">
							<ol class="carousel-indicators">
								<li data-target="#carousel-example-generic" data-slide-to="0"
									class="active"></li>
								<li data-target="#carousel-example-generic" data-slide-to="1"></li>
								<li data-target="#carousel-example-generic" data-slide-to="2"></li>
							</ol>
							<div class="carousel-inner">
								<div class="item active">
									<img class="slide-image"
										src="<c:url value="/resources/images/slideImage1.jpg" />"
										style="height: 300px; width: 1000px">
								</div>
								<div class="item">
									<img class="slide-image"
										src="<c:url value="/resources/images/slideImage2.jpg" />"
										style="height: 300px; width: 1000px">
								</div>
								<div class="item">
									<img class="slide-image"
										src="<c:url value="/resources/images/slideImage3.png" />"
										style="height: 300px; width: 1000px">
								</div>
							</div>
							<a class="left carousel-control" href="#carousel-example-generic"
								data-slide="prev"> <span
								class="glyphicon glyphicon-chevron-left"></span>
							</a> <a class="right carousel-control"
								href="#carousel-example-generic" data-slide="next"> <span
								class="glyphicon glyphicon-chevron-right"></span>
							</a>
						</div>
					</div>

				</div>

				<div class="row">


					<c:forEach var="product" items="${randomProductList}">
						<div class="col-sm-4 col-lg-4 col-md-4">
							<div class="thumbnail">
								<img src="data:image/jpg;base64,${product.byteString}" alt=""
									style="height: 189px">
								<div class="caption">
									<h4 class="pull-right">$${product.price}</h4>
									<h4>
										<a href="#">${product.productName}</a>
									</h4>
									<h5>${product.productDescription}</h5>
									<a
										href="<spring:url value='/product/getProduct?id=${product.id}'/> "
										class="btn btn-primary"> <span
										class="glyphicon-info-sign glyphicon" /></span> Details
									</a>
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
