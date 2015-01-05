<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<jsp:include page="header.jsp">
	<jsp:param value="a" name="a" />
</jsp:include>

<title>Aladdin - Vendor Registration</title>
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

				<div class="row carousel-holder">

					<div class="col-md-12">
						<fieldset>
							<legend class="registrationLegend">Vendor Registration</legend>
							<form:form class="form-horizontal registrationForm"
								id="vendorRegistrationFormId" action="../vendor-register/submit" method="post">

								<div class="form-group">
									<label for="inputBusinessName" class="col-sm-2 control-label">Business
										Name</label>
									<div class="col-sm-10">
										<input type="text"
											class="form-control validate[required] text-input" data-errormessage-value-missing="Business Name is required!" 
											id="inputBusinessName" placeholder="Business Name"
											style="width: 200px" name="businessName">
									</div>
								</div>
								
								<div class="form-group">
									<label for="inputFirstName" class="col-sm-2 control-label">First
										Name</label>
									<div class="col-sm-10">
										<input type="text"
											class="form-control validate[required] text-input" data-errormessage-value-missing="First Name is required!" 
											id="inputFirstName" placeholder="First Name"
											style="width: 200px" name="firstName">
									</div>
								</div>

								<div class="form-group">
									<label for="inputLastName" class="col-sm-2 control-label">Last
										Name</label>
									<div class="col-sm-10">
										<input type="text" class="form-control validate[required] text-input" id="inputLastName" data-errormessage-value-missing="Last Name is required!"
											placeholder="Last Name" style="width: 200px" name="lastName">
									</div>
								</div>

								<div class="form-group">
									<label for="datepicker" class="col-sm-2 control-label">Date
										Of Birth</label>
									<div class="col-sm-10">

										<input type="text" id="datepicker" class="form-control validate[required] text-input"
											style="width: 200px" name="dateOfBirth" placeholder="Date of Birth" data-errormessage-value-missing="Date of Birth is required!" >
									</div>
								</div>

								<div class="form-group">
									<label for="inputPhone" class="col-sm-2 control-label">Phone
										Number</label>
									<div class="col-sm-10">
										<input type="text" class="form-control validate[required] text-input" id="inputPhone"
											placeholder="Phone" style="width: 200px" name="phoneNumber" data-errormessage-value-missing="Phone Number is required!">
									</div>
								</div>
								<div class="form-group">
									<label for="inputEmail" class="col-sm-2 control-label">Email</label>
									<div class="col-sm-10">
										<input type="text" class="form-control validate[custom[email]] validate[required] text-input" id="inputEmail"
											placeholder="Email" style="width: 200px" name="emailAddress" data-errormessage-value-missing="Email is required!">
									</div>
								</div>
								<div class="form-group">
									<label for="inputPassword" class="col-sm-2 control-label">Password</label>
									<div class="col-sm-10">
										<input type="password" class="form-control validate[required] text-input" id="inputPassword"
											placeholder="Password" style="width: 200px" name="password" data-errormessage-value-missing="Password is required!">
									</div>
								</div>
								<div class="form-group">
									<label for="inputConfirmPassword" class="col-sm-2 control-label">Confirm Password</label>
									<div class="col-sm-10">
										<input type="password" class="form-control validate[required,equals[inputPassword]] text-input" id="inputConfirmPassword"
											placeholder="Confirm Password" style="width: 200px" name="confirmPassword" data-errormessage-value-missing="Confirm Password is required!">
									</div>
								</div>
								<div class="form-group">
									<label for="countryList" class="col-sm-2 control-label"
										style="margin-right: 14px;">Country</label> <select
										class="form-control input-lg validate[required]" id="countryList"
										style="width: 200px" name="address.country" data-errormessage-value-missing="Please select a country!">
										<option value="">Select a country</option>
										<option value="AF">Afghanistan</option>
										<option value="AL">Albania</option>
										<option value="DZ">Algeria</option>
										<option value="AS">American Samoa</option>
										<option value="AD">Andorra</option>
										<option value="AG">Angola</option>
										<option value="AI">Anguilla</option>
										<option value="AG">Antigua &amp; Barbuda</option>
										<option value="AR">Argentina</option>
										<option value="AA">Armenia</option>
										<option value="AW">Aruba</option>
										<option value="AU">Australia</option>
										<option value="AT">Austria</option>
										<option value="AZ">Azerbaijan</option>
										<option value="BS">Bahamas</option>
										<option value="BH">Bahrain</option>
										<option value="BD">Bangladesh</option>
										<option value="BB">Barbados</option>
										<option value="BY">Belarus</option>
										<option value="BE">Belgium</option>
										<option value="BZ">Belize</option>
										<option value="BJ">Benin</option>
										<option value="BM">Bermuda</option>
										<option value="BT">Bhutan</option>
										<option value="BO">Bolivia</option>
										<option value="BL">Bonaire</option>
										<option value="BA">Bosnia &amp; Herzegovina</option>
										<option value="BW">Botswana</option>
										<option value="BR">Brazil</option>
										<option value="BC">British Indian Ocean Ter</option>
										<option value="BN">Brunei</option>
										<option value="BG">Bulgaria</option>
										<option value="BF">Burkina Faso</option>
										<option value="BI">Burundi</option>
										<option value="KH">Cambodia</option>
										<option value="CM">Cameroon</option>
										<option value="CA">Canada</option>
										<option value="IC">Canary Islands</option>
										<option value="CV">Cape Verde</option>
										<option value="KY">Cayman Islands</option>
										<option value="CF">Central African Republic</option>
										<option value="TD">Chad</option>
										<option value="CD">Channel Islands</option>
										<option value="CL">Chile</option>
										<option value="CN">China</option>
										<option value="CI">Christmas Island</option>
										<option value="CS">Cocos Island</option>
										<option value="CO">Colombia</option>
										<option value="CC">Comoros</option>
										<option value="CG">Congo</option>
										<option value="CK">Cook Islands</option>
										<option value="CR">Costa Rica</option>
										<option value="CT">Cote D'Ivoire</option>
										<option value="HR">Croatia</option>
										<option value="CU">Cuba</option>
										<option value="CB">Curacao</option>
										<option value="CY">Cyprus</option>
										<option value="CZ">Czech Republic</option>
										<option value="DK">Denmark</option>
										<option value="DJ">Djibouti</option>
										<option value="DM">Dominica</option>
										<option value="DO">Dominican Republic</option>
										<option value="TM">East Timor</option>
										<option value="EC">Ecuador</option>
										<option value="EG">Egypt</option>
										<option value="SV">El Salvador</option>
										<option value="GQ">Equatorial Guinea</option>
										<option value="ER">Eritrea</option>
										<option value="EE">Estonia</option>
										<option value="ET">Ethiopia</option>
										<option value="FA">Falkland Islands</option>
										<option value="FO">Faroe Islands</option>
										<option value="FJ">Fiji</option>
										<option value="FI">Finland</option>
										<option value="FR">France</option>
										<option value="GF">French Guiana</option>
										<option value="PF">French Polynesia</option>
										<option value="FS">French Southern Ter</option>
										<option value="GA">Gabon</option>
										<option value="GM">Gambia</option>
										<option value="GE">Georgia</option>
										<option value="DE">Germany</option>
										<option value="GH">Ghana</option>
										<option value="GI">Gibraltar</option>
										<option value="GB">Great Britain</option>
										<option value="GR">Greece</option>
										<option value="GL">Greenland</option>
										<option value="GD">Grenada</option>
										<option value="GP">Guadeloupe</option>
										<option value="GU">Guam</option>
										<option value="GT">Guatemala</option>
										<option value="GN">Guinea</option>
										<option value="GY">Guyana</option>
										<option value="HT">Haiti</option>
										<option value="HW">Hawaii</option>
										<option value="HN">Honduras</option>
										<option value="HK">Hong Kong</option>
										<option value="HU">Hungary</option>
										<option value="IS">Iceland</option>
										<option value="IN">India</option>
										<option value="ID">Indonesia</option>
										<option value="IA">Iran</option>
										<option value="IQ">Iraq</option>
										<option value="IR">Ireland</option>
										<option value="IM">Isle of Man</option>
										<option value="IL">Israel</option>
										<option value="IT">Italy</option>
										<option value="JM">Jamaica</option>
										<option value="JP">Japan</option>
										<option value="JO">Jordan</option>
										<option value="KZ">Kazakhstan</option>
										<option value="KE">Kenya</option>
										<option value="KI">Kiribati</option>
										<option value="NK">Korea North</option>
										<option value="KS">Korea South</option>
										<option value="KW">Kuwait</option>
										<option value="KG">Kyrgyzstan</option>
										<option value="LA">Laos</option>
										<option value="LV">Latvia</option>
										<option value="LB">Lebanon</option>
										<option value="LS">Lesotho</option>
										<option value="LR">Liberia</option>
										<option value="LY">Libya</option>
										<option value="LI">Liechtenstein</option>
										<option value="LT">Lithuania</option>
										<option value="LU">Luxembourg</option>
										<option value="MO">Macau</option>
										<option value="MK">Macedonia</option>
										<option value="MG">Madagascar</option>
										<option value="MY">Malaysia</option>
										<option value="MW">Malawi</option>
										<option value="MV">Maldives</option>
										<option value="ML">Mali</option>
										<option value="MT">Malta</option>
										<option value="MH">Marshall Islands</option>
										<option value="MQ">Martinique</option>
										<option value="MR">Mauritania</option>
										<option value="MU">Mauritius</option>
										<option value="ME">Mayotte</option>
										<option value="MX">Mexico</option>
										<option value="MI">Midway Islands</option>
										<option value="MD">Moldova</option>
										<option value="MC">Monaco</option>
										<option value="MN">Mongolia</option>
										<option value="MS">Montserrat</option>
										<option value="MA">Morocco</option>
										<option value="MZ">Mozambique</option>
										<option value="MM">Myanmar</option>
										<option value="NA">Nambia</option>
										<option value="NU">Nauru</option>
										<option value="NP">Nepal</option>
										<option value="AN">Netherland Antilles</option>
										<option value="NL">Netherlands (Holland, Europe)</option>
										<option value="NV">Nevis</option>
										<option value="NC">New Caledonia</option>
										<option value="NZ">New Zealand</option>
										<option value="NI">Nicaragua</option>
										<option value="NE">Niger</option>
										<option value="NG">Nigeria</option>
										<option value="NW">Niue</option>
										<option value="NF">Norfolk Island</option>
										<option value="NO">Norway</option>
										<option value="OM">Oman</option>
										<option value="PK">Pakistan</option>
										<option value="PW">Palau Island</option>
										<option value="PS">Palestine</option>
										<option value="PA">Panama</option>
										<option value="PG">Papua New Guinea</option>
										<option value="PY">Paraguay</option>
										<option value="PE">Peru</option>
										<option value="PH">Philippines</option>
										<option value="PO">Pitcairn Island</option>
										<option value="PL">Poland</option>
										<option value="PT">Portugal</option>
										<option value="PR">Puerto Rico</option>
										<option value="QA">Qatar</option>
										<option value="ME">Republic of Montenegro</option>
										<option value="RS">Republic of Serbia</option>
										<option value="RE">Reunion</option>
										<option value="RO">Romania</option>
										<option value="RU">Russia</option>
										<option value="RW">Rwanda</option>
										<option value="NT">St Barthelemy</option>
										<option value="EU">St Eustatius</option>
										<option value="HE">St Helena</option>
										<option value="KN">St Kitts-Nevis</option>
										<option value="LC">St Lucia</option>
										<option value="MB">St Maarten</option>
										<option value="PM">St Pierre &amp; Miquelon</option>
										<option value="VC">St Vincent &amp; Grenadines</option>
										<option value="SP">Saipan</option>
										<option value="SO">Samoa</option>
										<option value="AS">Samoa American</option>
										<option value="SM">San Marino</option>
										<option value="ST">Sao Tome &amp; Principe</option>
										<option value="SA">Saudi Arabia</option>
										<option value="SN">Senegal</option>
										<option value="RS">Serbia</option>
										<option value="SC">Seychelles</option>
										<option value="SL">Sierra Leone</option>
										<option value="SG">Singapore</option>
										<option value="SK">Slovakia</option>
										<option value="SI">Slovenia</option>
										<option value="SB">Solomon Islands</option>
										<option value="OI">Somalia</option>
										<option value="ZA">South Africa</option>
										<option value="ES">Spain</option>
										<option value="LK">Sri Lanka</option>
										<option value="SD">Sudan</option>
										<option value="SR">Suriname</option>
										<option value="SZ">Swaziland</option>
										<option value="SE">Sweden</option>
										<option value="CH">Switzerland</option>
										<option value="SY">Syria</option>
										<option value="TA">Tahiti</option>
										<option value="TW">Taiwan</option>
										<option value="TJ">Tajikistan</option>
										<option value="TZ">Tanzania</option>
										<option value="TH">Thailand</option>
										<option value="TG">Togo</option>
										<option value="TK">Tokelau</option>
										<option value="TO">Tonga</option>
										<option value="TT">Trinidad &amp; Tobago</option>
										<option value="TN">Tunisia</option>
										<option value="TR">Turkey</option>
										<option value="TU">Turkmenistan</option>
										<option value="TC">Turks &amp; Caicos Is</option>
										<option value="TV">Tuvalu</option>
										<option value="UG">Uganda</option>
										<option value="UA">Ukraine</option>
										<option value="AE">United Arab Emirates</option>
										<option value="GB">United Kingdom</option>
										<option value="US">United States of America</option>
										<option value="UY">Uruguay</option>
										<option value="UZ">Uzbekistan</option>
										<option value="VU">Vanuatu</option>
										<option value="VS">Vatican City State</option>
										<option value="VE">Venezuela</option>
										<option value="VN">Vietnam</option>
										<option value="VB">Virgin Islands (Brit)</option>
										<option value="VA">Virgin Islands (USA)</option>
										<option value="WK">Wake Island</option>
										<option value="WF">Wallis &amp; Futana Is</option>
										<option value="YE">Yemen</option>
										<option value="ZR">Zaire</option>
										<option value="ZM">Zambia</option>
										<option value="ZW">Zimbabwe</option>
									</select>
								</div>
								<div class="form-group">
									<label for="inputState" class="col-sm-2 control-label">State</label>
									<div class="col-sm-10">
										<input type="text" class="form-control validate[required] text-input" id="inputState"
											placeholder="State" style="width: 200px" name="address.state" data-errormessage-value-missing="State is required!">
									</div>
								</div>
								<div class="form-group">
									<label for="inputCity" class="col-sm-2 control-label">City</label>
									<div class="col-sm-10">
										<input type="text" class="form-control validate[required] text-input" id="inputCity"
											placeholder="City" style="width: 200px" name="address.city" data-errormessage-value-missing="City is required!">
									</div>
								</div>
								<div class="form-group">
									<label for="inputStreet" class="col-sm-2 control-label">Street</label>
									<div class="col-sm-10">
										<textarea class="form-control validate[required] text-input" id="inputStreet"
											style="width: 200px" name="address.street" placeholder="Give Street Address" data-errormessage-value-missing="Street Adress is required!"></textarea>
									</div>
								</div>
								<div class="form-group">
									<label for="inputZip" class="col-sm-2 control-label">Zip</label>
									<div class="col-sm-10">
										<input type="text" class="form-control validate[required] text-input" id="inputZip"
											placeholder="Zip Code" style="width: 200px" name="address.zip" data-errormessage-value-missing="Zip is required!">
									</div>
								</div>
								<div class="form-group">
									<label for="inputProfitPercentage" class="col-sm-2 control-label">Profit Percentage</label>
									<div class="col-sm-10">
										<input type="text" class="form-control validate[required] text-input" id="inputProfitPercentage"
											placeholder="Profit Percentage" style="width: 200px" name="profitPercentage" data-errormessage-value-missing="Profit Percentage is required!">
									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-offset-2 col-sm-10">
										<button type="submit" class="btn btn-primary signIn">Sign
											in</button>
									</div>
								</div>
							</form:form>
						</fieldset>
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
