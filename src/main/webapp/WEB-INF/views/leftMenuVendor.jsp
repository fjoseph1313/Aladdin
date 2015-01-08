<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<p class="lead">Vendor Menu</p>
<div class="list-group">
	<a href=" <spring:url value="/vendor/dashboard" />" class="list-group-item">DashBoard</a> 
	<a href=" <spring:url value="/product/add" />" class="list-group-item">Add Product </a> 
	<a href=" <spring:url value="/getReportVendorPage" />"class="list-group-item">Vendor Report </a> 
		

</div>

