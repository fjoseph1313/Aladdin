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



				<h3 style="margin-left: 16px">Purchase Details</h3>

				<div class="row carousel-holder">

					<div class="col-md-12">
						<fieldset>
							<b>Products</b>
						</fieldset>
						
							<table class="table  table-hover" style="margin-top: 10px">
								<tr>
									<th>Product Name</th>
									<th>Product Quality</th>
									<th>SubTotal</th>
								</tr>
								
							
									<c:forEach var="item" items="${purchasedItem}">
										<tr>
											<td>${item.product.productName}</td>
											<td>${item.quantity}</td>
											<td>$${item.product.price * item.quantity}</td>
										</tr>
									</c:forEach>
							
								
							
							</table>
							<div class="row">
								<div class="col-md-6" style="text-align: right">
									<b>Total Quantity : ${paidOrder.orderAmount }</b>
								</div>
								<div class="col-md-6" style="text-align: right">
									<b>Total Order Amount:$${paidOrder.quantity  }</b>
								</div>
							</div>
							<div class="form-group">
								Your products will be shipped to this address:
								
								<p>
									 Name :${paidOrder.customer.firstName } ${paidOrder.customer.firstName }<br/>
									${paidOrder.customer.address.street } <br/>
									${paidOrder.customer.address.city },${paidOrder.customer.address.state }  <br/>
									USA
								<p> 
							</div>
						
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
