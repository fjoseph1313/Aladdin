<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header" >
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#bs-example-navbar-collapse-1">
			<span class="sr-only">Toggle navigation</span> <span
				class="icon-bar"></span> <span class="icon-bar"></span> <span
				class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="#"><img
			src="<c:url value="/resources/images/AladdinLOGO.png" />"
			style="display: block; width: 150px; height: 30px" alt="" /></a>
	</div>
	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse"
		id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">
			<li><a href="#">Home</a></li>
			<li><a href="#">About</a></li>
			<li><a href="#">Services</a></li>
			<li><a href="#">My Account</a></li>
			<li><a href="#">Contact</a></li>
			<li><a href="#" style="color: white;"><img src="<c:url value="/resources/images/shoppingCart.png" />" class="cart_img" style="display:inline"/> (10)</a></li>
		</ul>
	</div>
	<!-- /.navbar-collapse -->
</div>
<!-- /.container -->