<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p class="lead">Categories</p>
<div class="list-group">
	<a href="#" class="list-group-item">Category 1</a> <a href="#"
		class="list-group-item">Category 2</a> <a href="#"
		class="list-group-item">Category 3</a>
</div>

<div class="col-sm-12" id="searchProduct">
	<p class="lead">Search By</p>
	<form>
		<p>Keyword</p>
		<p>
			<input type="text" class="form-control" />
		</p>
		<p>Category</p>
		<p>
			<select class="form-control">
				<option>Electronics</option>
				<option>Computer</option>
			</select>
		</p>
		<p>
			<input type="button" class="btn btn-default" value="search" />
		</p>
	</form>

</div>