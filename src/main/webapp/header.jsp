<!DOCTYPE html> 
<html lang="en">
	
<!-- doccure/blank-page.jsp  30 Nov 2019 04:12:20 GMT -->
<head>
		<meta charset="utf-8">
		<title>Doccure</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
		
		<!-- Favicons -->
		<link href="assets/img/favicon.png" rel="icon">
		
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="assets/css/bootstrap.min.css">
		
		<!-- Fontawesome CSS -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/fontawesome/css/fontawesome.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/fontawesome/css/all.min.css">
		
		<!-- Main CSS -->
		<link rel="stylesheet" href="assets/css/style.css">
		
		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
			<script src="assets/js/html5shiv.min.js"></script>
			<script src="assets/js/respond.min.js"></script>
		<![endif]-->
	
	</head>
	<body>

	
		
			<!-- Header -->
	
			<header class="header">
			
		
			
			
			
				<nav class="navbar navbar-expand-lg header-nav">
					<div class="navbar-header">
						<a id="mobile_btn" href="javascript:void(0);">
							<span class="bar-icon">
								<span></span>
								<span></span>
								<span></span>
							</span>
						</a>
						<a href="index-2.jsp" class="navbar-brand logo">
							<img src="assets/img/logo.png" class="img-fluid" alt="Logo">
						</a>
					</div>
					<div class="main-menu-wrapper">
						<div class="menu-header">
							<a href="index-2.jsp" class="menu-logo">
								<img src="assets/img/logo.png" class="img-fluid" alt="Logo">
							</a>
							<a id="menu_close" class="menu-close" href="javascript:void(0);">
								<i class="fas fa-times"></i>
							</a>
						</div>
						<ul class="main-nav">
							<li>
								<a href="index-2.jsp">Home</a>
							</li>
							<li class="has-submenu">
								<a href="#">Doctors <i class="fas fa-chevron-down"></i></a>
								<ul class="submenu">
									<li><a href="doctor-dashboard.jsp">Doctor Dashboard</a></li>
									<li><a href="appointments.jsp">Appointments</a></li>
									<li><a href="schedule-timings.jsp">Schedule Timing</a></li>
									<li><a href="my-patients.jsp">Patients List</a></li>
									<li><a href="patient-profile.jsp">Patients Profile</a></li>
									<li><a href="chat-doctor.jsp">Chat</a></li>
									<li><a href="invoices.jsp">Invoices</a></li>
									<li><a href="doctor-profile-settings.jsp">Profile Settings</a></li>
									<li><a href="reviews.jsp">Reviews</a></li>
									<li><a href="doctor-register.jsp">Doctor Register</a></li>
								</ul>
							</li>	
							<li class="has-submenu">
								<a href="#">Patients <i class="fas fa-chevron-down"></i></a>
								<ul class="submenu">
									<li><a href="search.jsp">Search Doctor</a></li>
									<li><a href="doctor-profile.jsp">Doctor Profile</a></li>
									<li><a href="booking.jsp">Booking</a></li>
									<li><a href="checkout.jsp">Checkout</a></li>
									<li><a href="booking-success.jsp">Booking Success</a></li>
									<li><a href="patient-dashboard.jsp?&mobile=${mobileNumber}">Patient Dashboard</a></li>
									<li><a href="favourites.jsp">Favourites</a></li>
									<li><a href="chat.jsp">Chat</a></li>
									<li><a href="${pageContext.request.contextPath}/PatientController?action=profileSettingShowData&mobile=${mobileNumber}">Profile Settings</a></li>
									<li><a href="change-password.jsp">Change Password</a></li>
								</ul>
							</li>	
							<li class="has-submenu active">
								<a href="#">Pages <i class="fas fa-chevron-down"></i></a>
								<ul class="submenu">
									<li><a href="voice-call.jsp">Voice Call</a></li>
									<li><a href="video-call.jsp">Video Call</a></li>
									<li><a href="search.jsp">Search Doctors</a></li>
									<li><a href="calendar.jsp">Calendar</a></li>
									<li><a href="components.jsp">Components</a></li>
									<li class="has-submenu">
										<a href="invoices.jsp">Invoices</a>
										<ul class="submenu">
											<li><a href="invoices.jsp">Invoices</a></li>
											<li><a href="invoice-view.jsp">Invoice View</a></li>
										</ul>
									</li>
									<li class="active"><a href="blank-page.jsp">Starter Page</a></li>
									<li><a href="login.jsp">Login</a></li>
									<li><a href="register.jsp">Register</a></li>
									<li><a href="forgot-password.jsp">Forgot Password</a></li>
								</ul>
							</li>
							<li>
								<a href="admin/login.jsp" target="_blank">Admin</a>
							</li>
							<li class="login-link">
							
								<a href="login.jsp">Login / Signup</a>
							
							</li>
							
						</ul>
					</div>		 
					<ul class="nav header-navbar-rht">
						<li class="nav-item contact-item">
							<div class="header-contact-img">
								<i class="far fa-hospital"></i>							
							</div>
							<div class="header-contact-detail">
								<p class="contact-header">Contact</p>
								<p class="contact-info-header"> +91-9098116177</p>
							</div>
						</li>
						<%if(session.getAttribute("mobileNumber")==null) {%>
							
						<li class="nav-item">
								<a class="nav-link header-login" href="login.jsp">login / Signup </a>
								
						</li>
						<%}else{ %>
						
						<li class="nav-item">
								
								<form action="${pageContext.request.contextPath}/LoginController" method="post">
								
								<input type="hidden" name="action" value="logout">
								
								<button class="btn btn-primary" >Logout</button>
								</form>
						</li>
						<%}%>
					</ul>
				</nav>
				
			
				
			</header>
			<!-- /Header -->
			
			
			<!-- /Breadcrumb -->
			<script src="assets/js/jquery.min.js"></script>
		
		<!-- Bootstrap Core JS -->
		<script src="assets/js/popper.min.js"></script>
		<script src="assets/js/bootstrap.min.js"></script>
		
		<!-- Custom JS -->
		<script src="assets/js/script.js"></script>
			
			
			<!-- Page Content -->
					
	</body>

<!-- doccure/blank-page.jsp  30 Nov 2019 04:12:20 GMT -->
</html>