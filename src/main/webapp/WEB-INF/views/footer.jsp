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
		$("#datepicker").datepicker({
			dateFormat : 'yy-mm-dd',
			changeMonth : true,
			changeYear : true
		});

	});

	/****CUSTOM VALIDATION
	
		USE IT LIKE 
		
		<input value="" class="validate[required,funcCall[checkHELLO]]" type="text" id="lastname" name="lastname" />
	
	 ****/
	/* function checkHELLO(field, rules, i, options) {
		if (field.val() != "HELLO") {
			// this allows the use of i18 for the error msgs
			return options.allrules.validate2fields.alertText;
		}
	} */

	/****
	function for zip
	 ****/

	function checkZip(field, rules, i, options) {

		if (!(/^\d{5}([\-]?\d{4})?$/.test(field.val()))) {
			// this allows the use of i18 for the error msgs
			return "Please give a valid  zip";
		}
	}

	/****
	function for phone
	 ****/

	function checkPhone(field, rules, i, options) {

		if (!(/^(\([2-9]|[2-9])(\d{2}|\d{2}\))(-|.|\s)?\d{3}(-|.|\s)?\d{4}$/
				.test(field.val()))) {
			// this allows the use of i18 for the error msgs
			return "Please give a valid  Phonenumber";
		}
	}
	
	
	
	
	
	
	

	/****
	function for Age
	 ****/

	function checkAge(field, rules, i, options) {

		//alert(field.val());

		var dob = new Date(field.val());
		//console.log(dob);

		var today = new Date();
		console.log(today);

		//console.log(dob.getFullYear());

		console.log((dob.getFullYear() - today.getFullYear()));

		if ((today.getFullYear() - dob.getFullYear()) < 18) {
			// this allows the use of i18 for the error msgs
			//alert("here");
			return "Age should be 18 or more";
		}
	}

	jQuery(document).ready(function() {
		// binds form submission and fields to the validation engine

		jQuery("#customerRegistrationFormId").validationEngine({
			autoHidePrompt : true
		});

		jQuery("#vendorRegistrationFormId").validationEngine({
			autoHidePrompt : true
		});

		jQuery("#addProductRegistrationForm").validationEngine({
			autoHidePrompt : true
		});

		jQuery("#searchForm").validationEngine({
			autoHidePrompt : true
		});

		jQuery("#addCategoryForm").validationEngine({
			autoHidePrompt : true
		});

	});
</script>

<!-- Bootstrap Core JavaScript -->
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>



<script type="text/javascript">
	$(document).ready(function() {

		var emailok = false;
		var email = $("#inputEmail");
		var emailInfo = $("#username_availability_result"); 

		email.blur(function() {
			
			$.ajax({
				type : "GET",
				data : "email=" + $("#inputEmail").val(),
				url : "http://localhost:8080/Aladdin/availability",
				beforeSend : function() {
					emailInfo.html("<font style=\"color:red\">Checking Email....</font>"); //show checking or loading image
				},
				success : function(data) {
					
					
					
					if (data == "0") {
						emailok = false;
						emailInfo.html("<font style=\"color:red\">Email already exists.</font>");
						
					} else {
						emailok = true;
						emailInfo.html("<font style=\"color:green\">Email is Available.</font>");
					}
				}
			});
		});

	});
</script>

