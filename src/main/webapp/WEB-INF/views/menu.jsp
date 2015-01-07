<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div class="container">
	<!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#bs-example-navbar-collapse-1">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="<spring:url value="/" />"><img
			src="<c:url value="/resources/images/AladdinLOGO.png" />"
			style="display: block; width: 150px; height: 30px" alt="" /></a>
	</div>
	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">
			<li><a href="<spring:url value="/" />">Home</a></li>
			<li><a href="#">About</a></li>
			<li><a href="#">Services</a></li>




			<li><a href="#">Contact</a></li>

			<li><a href="cart" style="color: white;"><img
					src="<c:url value="/resources/images/shoppingCart.png" />"
					class="cart_img" style="display: inline" /> ${userCart.size()}</a></li>







			<c:choose>
				<c:when test="${userType eq 'Admin'}">
					<li><a href=" <spring:url value="/admin/dashboard" />">Go
							to DashBoard</a></li>
				</c:when>
				<c:when test="${userType eq 'Vendor'}">
					<li><a href=" <spring:url value="/vendor/dashboard" />">Go
							to DashBoard</a></li>
				</c:when>
				<c:otherwise>

				</c:otherwise>
			</c:choose>



			<c:choose>
				<c:when test="${userDetails != null}">
					<c:url value="/j_spring_security_logout" var="logoutUrl" />
					<li><a href="${logoutUrl}">Log Out</a></li>
				</c:when>
				<c:otherwise>
					<li><a href=" <spring:url value="/clogin" />">My Account </a></li>
				</c:otherwise>
			</c:choose>




		</ul>



	</div>
	<!-- /.navbar-collapse -->
</div>
<!-- /.container -->