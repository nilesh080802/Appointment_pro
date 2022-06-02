<!DOCTYPE html> 
<html lang="en">
	
<!-- doccure/register.jsp  30 Nov 2019 04:12:20 GMT -->
<head>
		<meta charset="utf-8">
		<title>Doccure</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
		
		<!-- Favicons -->
		<link href="assets/img/favicon.png" rel="icon">
		
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="assets/css/bootstrap.min.css">
		
		<!-- Fontawesome CSS -->
		<link rel="stylesheet" href="assets/plugins/fontawesome/css/fontawesome.min.css">
		<link rel="stylesheet" href="assets/plugins/fontawesome/css/all.min.css">
		
		<!-- Main CSS -->
		<link rel="stylesheet" href="assets/css/style.css">
		
		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
			<script src="assets/js/html5shiv.min.js"></script>
			<script src="assets/js/respond.min.js"></script>
		<![endif]-->
	
	</head>
	<body class="account-page">

		<!-- Main Wrapper -->
		<div class="main-wrapper">
		
			<!-- Header -->
			<jsp:include page="header.jsp"/>
			<!-- /Header -->
			
			<!-- Page Content -->
			<div class="content">
				<div class="container-fluid">
					
					<div class="row">
						<div class="col-md-8 offset-md-2">
								
							<!-- Register Content -->
							<div class="account-content">
								<div class="row align-items-center justify-content-center">
									<div class="col-md-7 col-lg-6 login-left">
										<img src="assets/img/login-banner.png" class="img-fluid" alt="Doccure Register">	
									</div>
									<div class="col-md-12 col-lg-6 login-right">
										<div class="login-header">
											<h3>Patient Register <a href="doctor-register.jsp">Are you a Doctor?</a></h3>
											<p style="color:red;">
											<%if(request.getAttribute("loginError")!=null){ %>
											
											<%= request.getAttribute("loginError") %>
											
											<%}%>
											</p>
										</div>
										
										<!-- Register Form -->
										<form action="${pageContext.request.contextPath }/PatientController" id="submit" method = "post">
											
											
											<div class="form-group form-focus">
												<div class="form-group">
													<input type="hidden" class="form-control" name="action" value="register">
												</div>
											</div>
											
											
											<div class="form-group form-focus">
												<input type="text" class="form-control floating " id="fname" name="fname" required>
												<label class="focus-label">First Name</label>
											</div>
											
											<div class="form-group form-focus">
												<input type="text" class="form-control floating " id="lname" name="lname" required>
												<label class="focus-label">Last Name</label>
											</div>
											
											<div class="form-group form-focus">
												<input type="text" class="form-control floating"  id="mobileNumber" name="mobileNumber" required>
												<label class="focus-label">Mobile Number</label>
											</div>
											<div class="form-group form-focus">
												<input type="password" class="form-control floating" id="password" name="password" required>
												<label class="focus-label">Create Password</label>
											</div>
											<div class="text-right">
												<a class="forgot-link" href="login.jsp">Already have an account?</a>
						           	<!-- for register patient go to the patient controller -->
											</div>
											<script>
											
												$(document).ready(function () {

											    $('#submit').validate({ // initialize the plugin
											        rules: {
											            name: {
											                required: true,
											                
											            },
											            mobileNumber: {
											                required: true,
											                
											            },
											            password:{
											            	required: true,
											            }
											        }
											    });

											});
											
											</script>
											
											<button class="btn btn-primary btn-block btn-lg login-btn" type="submit">Signup</button>
											
											<div class="login-or">
												<span class="or-line"></span>
												<span class="span-or">or</span>
											</div>
											<div class="row form-row social-login">
												<div class="col-6">
													<a href="#" class="btn btn-facebook btn-block"><i class="fab fa-facebook-f mr-1"></i> Login</a>
												</div>
												<div class="col-6">
													<a href="#" class="btn btn-google btn-block"><i class="fab fa-google mr-1"></i> Login</a>
												</div>
											</div>
										</form>
										<!-- /Register Form -->
										
									</div>
								</div>
							</div>
							<!-- /Register Content -->
								
						</div>
					</div>

				</div>

			</div>		
			<!-- /Page Content -->
   
			<!-- Footer -->
			<jsp:include page="footer.jsp"/>
			<!-- /Footer -->
		   
		</div>
		<!-- /Main Wrapper -->
	  
		<!-- jQuery -->
		<script src="assets/js/jquery.min.js"></script>
		
		<!-- Bootstrap Core JS -->
		<script src="assets/js/popper.min.js"></script>
		<script src="assets/js/bootstrap.min.js"></script>
		
		<!-- Custom JS -->
		<script src="assets/js/script.js"></script>
		
	</body>

<!-- doccure/register.jsp  30 Nov 2019 04:12:20 GMT -->
</html>