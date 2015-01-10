<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>
<jsp:include page="header.jsp">
	<jsp:param value="a" name="a" />
</jsp:include>

<title>Aladdin - Order View</title>
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

				<!-- <div class="col-md-9">

				<h3 style="margin-left: 16px">Order Details</h3>

				<div class="row carousel-holder">

					<div class="col-md-12">
						<fieldset>
							<b>Products</b>
						</fieldset>
						<form:form class="form-horizontal registrationForm"
							id="customerRegistrationFormId"
							action="./payment/${currentOrder.id}" method="post">
							<table class="table  table-hover" style="margin-top: 10px">
								<tr>
									<th>Product Name</th>
									<th>Product Quality</th>
									<th>SubTotal</th>
								</tr>
								
								<c:if test="${empty currentOrderNew}">
									<c:forEach var="item" items="${currentOrder.cart}">
										<tr>
											<td>${item.product.productName}</td>
											<td>${item.quantity}</td>
											<td>$${item.quantity * item.product.price}</td>
										</tr>
									</c:forEach>
								</c:if>
								
								<c:if test="${not empty currentOrderNew}">
									<tr>
										<td>${currentOrderNew.product.productName}</td>
										<td>${currentOrderNew.quantity}</td>
										<td>$${currentOrderNew.quantity * currentOrderNew.product.price}</td>
									</tr>
								</c:if>
							</table>
							<div class="row">
								<div class="col-md-6" style="text-align: right">
									<b>Total Quantity : ${currentOrder.quantity }</b>
								</div>
								<div class="col-md-6" style="text-align: right">
									<b>Total Order Amount:$${currentOrder.orderAmount }</b>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-1 col-sm-11">
									<a href="<spring:url value="/order/cancel/${currentOrder.id}" />">Cancel Order </a> |
									<a href="<spring:url value="/payment/${currentOrder.id}" />"> Checkout </a> |
									<a href="<spring:url value="/" />"> Continue Shopping</a>
								</div>
							</div>
						</form:form>
					</div>

				</div>
			</div>-->



				<h3 style="margin-left: 16px">Shopping Cart Details</h3>

				<div class="row carousel-holder">

					<div class="col-md-12">
						<fieldset>
							<b>Products</b>
						</fieldset>
						<form:form class="form-horizontal registrationForm"
							id="customerRegistrationFormId"
							action="./payment/${currentOrder.id}" method="post">
							<table class="table  table-hover" style="margin-top: 10px">
								<tr>
									<th>Product Name</th>
									<th>Product Quality</th>
									<th>SubTotal</th>
									<th>Remove</th>
								</tr>
								
								<!--<c:if test="${empty currentOrderNew}">-->
									<c:forEach var="item" items="${thisCart}">
										<tr>
											<td>${item.product.productName}</td>
											<td>${item.quantity}</td>
											<td>$${item.product.price * item.quantity}</td>
											<td><a href = "removeItem/${item.id}">remove</a></td>
										</tr>
									</c:forEach>
								<!--</c:if>-->
								
								<!--<c:if test="${not empty currentOrderNew}">
									<tr>
										<td>${currentOrderNew.product.productName}</td>
										<td>${currentOrderNew.quantity}</td>
										<td>$${currentOrderNew.quantity * currentOrderNew.product.price}</td>
									</tr>
								</c:if>-->
							</table>
							<div class="row">
								<div class="col-md-6" style="text-align: right">
									<b>Total Quantity : ${orderQuantity }</b>
								</div>
								<div class="col-md-6" style="text-align: right">
									<b>Total Order Amount:$${orderAmount }</b>
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-1 col-sm-11">
									<a href="<spring:url value="/order/cancel" />">Cancel Order </a> |
									
			<c:choose>
				<c:when test="${userDetails != null}">
					<c:url value="/j_spring_security_logout" var="logoutUrl" />
					<a href="<spring:url value="/payment" />"> Checkout </a> |
				</c:when>
				<c:otherwise>
					<a href="<spring:url value="/guestCheckout" />"> Checkout as Guest </a> |
				</c:otherwise>
			</c:choose>
									
									
									 
									 
									<a href="<spring:url value="/" />"> Continue Shopping</a>
								</div>
							</div>
						</form:form>
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
