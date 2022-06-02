
<!DOCTYPE html> 
<html lang="en">

	
<!-- doccure/login.jsp  30 Nov 2019 04:12:20 GMT -->
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
	
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
.alert {
  padding: 20px;
  background-color: #f44336;
  color: white;
}

.closebtn {
  margin-left: 15px;
  color: white;
  font-weight: bold;
  float: right;
  font-size: 22px;
  line-height: 20px;
  cursor: pointer;
  transition: 0.3s;
}

.closebtn:hover {
  color: black;
}
</style>
		
	
	</head>
	<body class="account-page">

		<!-- Main Wrapper -->
		<div class="main-wrapper">
			
		    
		    
			<!-- Header -->
			<jsp:include page="header.jsp"/>
		    <!-- /Header -->
		     
		     <!------redirecting to the  pages  -->	    
	
			<!-- manage session -->
			 <%if(session.getAttribute("type") == "doctor"){ %>
			
			<% response.sendRedirect("doctor-dashboard.jsp");%>
			
			<%}else if(session.getAttribute("type") == "patient") {%>
			 
			 <% response.sendRedirect("patient-dashboard.jsp");%>
			
			<%}else if(session.getAttribute("type") == "admin") {%>
			 
			  <% response.sendRedirect("admin/index.jsp");%>
			
			<%}%>
		<!--Manage session end -->
    		
		
		    <!-- this is for logout setting, when user logout if they click on logout -->
			<!-- Page Content -->
			<div class="content">
			
				<div class="container-fluid">
					
					<div class="row">
						<div class="col-md-8 offset-md-2">
							
							<!-- Login Tab Content -->
							<div class="account-content">
								<div class="row align-items-center justify-content-center">
									<div class="col-md-7 col-lg-6 login-left">
										<img src="assets/img/login-banner.png" class="img-fluid" alt="Doccure Login">	
									</div>
									<div class="col-md-12 col-lg-6 login-right">
										<div class="login-header">
											<h3>Login <span>Doccure</span></h3>
											
											    <p style="color:red;">
											<%if(request.getAttribute("loginError")!=null){ %>
											
											<%= request.getAttribute("loginError") %>
											
											<%}else if(request.getAttribute("signup")!=null){%>
											
											 <p style="color:green;">
											<%=request.getAttribute("signup") %>
											 </p>
											
											<%} %>
											</p>
											<!-- 
											<div class="alert">
											  <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
											  <strong>Danger!</strong> 
											</div>
											 -->
											
										</div>
										<form action="${pageContext.request.contextPath}/LoginController?action=userLogin" id="submit" method ="post">
											<div class="form-group form-focus">
												<input type="text" class="form-control floating" id="mobileNumber" name="mobileNumber"  >
												<label	 class="focus-label">Mobile Number</label>
											</div>
											<div class="form-group form-focus">
												<input type="password" class="form-control floating" id="password" name="password" >
												<label class="focus-label">Password</label>
											</div>
											<div class="text-right">
												<a class="forgot-link" href="forgot-password.jsp">Forgot Password ?</a>
											</div>
											<div>
										<script>
											$(document).ready(function () {

											    $('#submit').validate({ // initialize the plugin
											        rules: {
											           
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
											</div>
											<button class="btn btn-primary btn-block btn-lg login-btn" type="submit">Login</button>
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
											<div class="text-center dont-have">Don't have an account? <a href="register.jsp">Register</a></div>
										</form>
									</div>
								</div>
							</div>
							<!-- /Login Tab Content -->
								
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

<!-- doccure/login.jsp  30 Nov 2019 04:12:20 GMT -->
</html>