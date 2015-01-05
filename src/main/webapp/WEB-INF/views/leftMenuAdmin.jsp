<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<p class="lead">Admin Menu</p>
<div class="list-group">
	<a href=" <spring:url value="/vendor/" />" class="list-group-item">Pending
		Approval Request </a> <a href=" 
		<spring:url value="/customer/" />"
		class="list-group-item">Deactivate Customer </a>

</div>

