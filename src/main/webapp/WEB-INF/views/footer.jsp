<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<hr>

	<!-- Footer -->
	<footer>
		<div class="row">
			<div class="col-lg-12">
				<p>Copyright &copy; Aladdin</p>
			</div>
		</div>
	</footer>
</div>
<!-- /.container -->

<!-- jQuery -->
<script src="<c:url value="/resources/js/jquery.js" />"></script>
<script src="<c:url value="/resources/js/jquery-ui.js" />"></script>
<script src="<c:url value="/resources/js/jquery.validationEngine.js" />"></script>
<script
	src="<c:url value="/resources/js/jquery.validationEngine-en.js" />"></script>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});

	jQuery(document).ready(function() {
		// binds form submission and fields to the validation engine
		jQuery("#registrationFormId").validationEngine({
			autoHidePrompt : true
		});
		
		jQuery("#addProductRegistrationForm").validationEngine({
			autoHidePrompt : true
		});
		
		jQuery("#addCategoryForm").validationEngine({
			autoHidePrompt : true
		});
		
		
		
	});
</script>

<!-- Bootstrap Core JavaScript -->
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
