<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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

				<div class="row">
					<h3 style="margin-left: 16px;padding:0px;margin:0px">${categoryName}</h3><hr>
				</div>
				<div class="row">
					<c:if test="${fn:length(productList)> 0}">
						<c:forEach var="product" items="${productList}">
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

					</c:if>

					<c:if test="${empty productList}">

						<p style="margin-left: 19px;">There is no product in this
							category</p>
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
