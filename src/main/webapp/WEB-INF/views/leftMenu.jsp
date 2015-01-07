<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<p class="lead">Categories</p>
<div class="list-group">
	<c:forEach var="listValue" items="${productcategoryList}">
		<a href="<c:url value="/product/showAll/${listValue.id}&&${listValue.categoryName}"/>"  class="list-group-item">${listValue}</a>
	</c:forEach>


</div>

<div class="col-sm-12" id="searchProduct">
	<p class="lead">Search By</p>
	<form class="form-horizontal" id="searchForm" action="search"
		method="post">
		<p>Keyword</p>
		<p>
			<input type="text"
				class="form-control form-control validate[required] text-input"
				name="pKey"
				data-errormessage-value-missing="Please provide a keyword is required!" />
		</p>
		<p>Category</p>
		<p>


			<select name="pCat" class="form-control">
				<c:forEach var="listValue" items="${productcategoryList}">
					<option value="${listValue}">${listValue}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			<input type="submit" class="btn btn-default" value="search" />

		</p>
	</form>

</div>