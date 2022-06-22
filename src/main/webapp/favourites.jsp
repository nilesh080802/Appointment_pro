<!DOCTYPE html> 
<html lang="en">
	
<!-- doccure/favourites.jsp  30 Nov 2019 04:12:16 GMT -->
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
	<body>


		<!-- manage session -->
			 <%if(session.getAttribute("type") == "doctor"){ %>
			
			<% response.sendRedirect("doctor-dashboard.jsp");%>
			
			<%}else if(session.getAttribute("type") == "patient") {%>
			 
			 <%-- <% response.sendRedirect("patient-dashboard.jsp");%>--%>
			 	<!--when patient is login continue....  -->
			<%}else if(session.getAttribute("type") == "admin") {%>
			 
			  <% response.sendRedirect("admin/index.jsp");%>
			
			<%}%>
		<!--Manage session end -->
    		
		<!-- Main Wrapper -->
		<div class="main-wrapper">
		
			<!-- Header -->
			<jsp:include page="header.jsp"/>
			<!-- /Header -->
			
			<!-- Breadcrumb -->
			<div class="breadcrumb-bar">
				<div class="container-fluid">
					<div class="row align-items-center">
						<div class="col-md-12 col-12">
							<nav aria-label="breadcrumb" class="page-breadcrumb">
								<ol class="breadcrumb">
									<li class="breadcrumb-item"><a href="index-2.jsp">Home</a></li>
									<li class="breadcrumb-item active" aria-current="page">Favourites</li>
								</ol>
							</nav>
							<h2 class="breadcrumb-title">Favourites</h2>
						</div>
					</div>
				</div>
			</div>
			<!-- /Breadcrumb -->
			
			<!-- Page Content -->
			<div class="content">
				<div class="container-fluid">
					<div class="row">
					
					<!-- Profile Sidebar -->
						<div class="col-md-5 col-lg-4 col-xl-3 theiaStickySidebar">
							<div class="profile-sidebar">
								<div class="widget-profile pro-widget-content">
									<div class="profile-info-widget">
										<a href="#" class="booking-doc-img">
											
											<img src="${patient.getImagePath()}" onerror="assets/img/patients/patient.jpg" alt="User Image">
										</a>
										<div class="profile-det-info">
											<h3>${patient.getFirstName()}  ${patient.getLastName()}</h3>
											<div class="patient-details">
												<h5><i class="fas fa-birthday-cake"></i>${patient.getDateOfBirth()}, 38 years</h5>
												<h5 class="mb-0"><i class="fas fa-map-marker-alt"></i>${patient.getCountry()}, ${patient.getState()}, ${patient.getCity()}</h5>
												<h5 class="mb-0">${patient.getAddress()}, ${patient.getZipCode()}</h5>
											</div>
										</div>
									</div>
								</div>
								<div class="dashboard-widget">
									<nav class="dashboard-menu">
										<ul>
											<li >
												<a href="${pageContext.request.contextPath}/PatientController?action=PatientDashboardShowData&mobile=${mobileNumber}">
													<i class="fas fa-columns"></i>
													<span>Dashboard</span>
												</a>
											</li>
											<li class="active">
												<a href="${pageContext.request.contextPath}/PatientController?action=PatientFavouritesShowData&mobile=${mobileNumber}">
													<i class="fas fa-bookmark"></i>
													<span>Favourites</span>
												</a>
											</li>
											<li>
												<a href="chat.jsp">
													<i class="fas fa-comments"></i>
													<span>Message</span>
													<small class="unread-msg">23</small>
												</a>
											</li>
											<li>
												<a href="${pageContext.request.contextPath}/PatientController?action=profileSettingShowData&mobile=${mobileNumber}">
													<i class="fas fa-user-cog"></i>
													<span>Profile Settings</span>
												</a>
											</li>
											<li>
												<a href="${pageContext.request.contextPath}/PatientController?action=PatientChangePasswordShowData&mobile=${mobileNumber}">
													<i class="fas fa-lock"></i>
													<span>Change Password</span>
												</a>
											</li>
											<li>
												<a href="${pageContext.request.contextPath}/LoginController?action=logout">
													<i class="fas fa-sign-out-alt"></i>
													<span>Logout</span>
												</a>
											</li>
										</ul>
									</nav>
								</div>

							</div>
						</div>
						<!-- / Profile Sidebar -->

						<div class="col-md-7 col-lg-8 col-xl-9">
							<div class="row row-grid">
								<div class="col-md-6 col-lg-4 col-xl-3">
									<div class="profile-widget">
										<div class="doc-img">
											<a href="doctor-profile.jsp">
												<img class="img-fluid" alt="User Image" src="assets/img/doctors/doctor-01.jpg">
											</a>
											<a href="javascript:void(0)" class="fav-btn">
												<i class="far fa-bookmark"></i>
											</a>
										</div>
										<div class="pro-content">
											<h3 class="title">
												<a href="doctor-profile.jsp">Ruby Perrin</a> 
												<i class="fas fa-check-circle verified"></i>
											</h3>
											<p class="speciality">MDS - Periodontology and Oral Implantology, BDS</p>
											<div class="rating">
												<i class="fas fa-star filled"></i>
												<i class="fas fa-star filled"></i>
												<i class="fas fa-star filled"></i>
												<i class="fas fa-star filled"></i>
												<i class="fas fa-star filled"></i>
												<span class="d-inline-block average-rating">(17)</span>
											</div>
											<ul class="available-info">
												<li>
													<i class="fas fa-map-marker-alt"></i> Florida, USA
												</li>
												<li>
													<i class="far fa-clock"></i> Available on Fri, 22 Mar
												</li>
												<li>
													<i class="far fa-money-bill-alt"></i> $300 - $1000 <i class="fas fa-info-circle" data-toggle="tooltip" title="Lorem Ipsum"></i>
												</li>
											</ul>
											<div class="row row-sm">
												<div class="col-6">
													<a href="doctor-profile.jsp" class="btn view-btn">View Profile</a>
												</div>
												<div class="col-6">
													<a href="booking.jsp" class="btn book-btn">Book Now</a>
												</div>
											</div>
										</div>
									</div>
								</div>
								
								<div class="col-md-6 col-lg-4 col-xl-3">
									<div class="profile-widget">
										<div class="doc-img">
											<a href="doctor-profile.jsp">
												<img class="img-fluid" alt="User Image" src="assets/img/doctors/doctor-02.jpg">
											</a>
											<a href="javascript:void(0)" class="fav-btn">
												<i class="far fa-bookmark"></i>
											</a>
										</div>
										<div class="pro-content">
											<h3 class="title">
												<a href="doctor-profile.jsp">Darren Elder</a> 
												<i class="fas fa-check-circle verified"></i>
											</h3>
											<p class="speciality">BDS, MDS - Oral & Maxillofacial Surgery</p>
											<div class="rating">
												<i class="fas fa-star filled"></i>
												<i class="fas fa-star filled"></i>
												<i class="fas fa-star filled"></i>
												<i class="fas fa-star filled"></i>
												<i class="fas fa-star"></i>
												<span class="d-inline-block average-rating">(35)</span>
											</div>
											<ul class="available-info">
												<li>
													<i class="fas fa-map-marker-alt"></i> Newyork, USA
												</li>
												<li>
													<i class="far fa-clock"></i> Available on Fri, 22 Mar
												</li>
												<li>
													<i class="far fa-money-bill-alt"></i> $50 - $300 <i class="fas fa-info-circle" data-toggle="tooltip" title="Lorem Ipsum"></i>
												</li>
											</ul>
											<div class="row row-sm">
												<div class="col-6">
													<a href="doctor-profile.jsp" class="btn view-btn">View Profile</a>
												</div>
												<div class="col-6">
													<a href="booking.jsp" class="btn book-btn">Book Now</a>
												</div>
											</div>
										</div>
									</div>
								</div>
								
								<div class="col-md-6 col-lg-4 col-xl-3">
									<div class="profile-widget">
										<div class="doc-img">
											<a href="doctor-profile.jsp">
												<img class="img-fluid" alt="User Image" src="assets/img/doctors/doctor-03.jpg">
											</a>
											<a href="javascript:void(0)" class="fav-btn">
												<i class="far fa-bookmark"></i>
											</a>
										</div>
										<div class="pro-content">
											<h3 class="title">
												<a href="doctor-profile.jsp">Deborah Angel</a> 
												<i class="fas fa-check-circle verified"></i>
											</h3>
											<p class="speciality">MBBS, MD - General Medicine, DNB - Cardiology</p>
											<div class="rating">
												<i class="fas fa-star filled"></i>
												<i class="fas fa-star filled"></i>
												<i class="fas fa-star filled"></i>
												<i class="fas fa-star filled"></i>
												<i class="fas fa-star"></i>
												<span class="d-inline-block average-rating">(27)</span>
											</div>
											<ul class="available-info">
												<li>
													<i class="fas fa-map-marker-alt"></i> Georgia, USA
												</li>
												<li>
													<i class="far fa-clock"></i> Available on Fri, 22 Mar
												</li>
												<li>
													<i class="far fa-money-bill-alt"></i> $100 - $400 <i class="fas fa-info-circle" data-toggle="tooltip" title="Lorem Ipsum"></i>
												</li>
											</ul>
											<div class="row row-sm">
												<div class="col-6">
													<a href="doctor-profile.jsp" class="btn view-btn">View Profile</a>
												</div>
												<div class="col-6">
													<a href="booking.jsp" class="btn book-btn">Book Now</a>
												</div>
											</div>
										</div>
									</div>
								</div>
								
								<div class="col-md-6 col-lg-4 col-xl-3">
									<div class="profile-widget">
										<div class="doc-img">
											<a href="doctor-profile.jsp">
												<img class="img-fluid" alt="User Image" src="assets/img/doctors/doctor-04.jpg">
											</a>
											<a href="javascript:void(0)" class="fav-btn">
												<i class="far fa-bookmark"></i>
											</a>
										</div>
										<div class="pro-content">
											<h3 class="title">
												<a href="doctor-profile.jsp">Sofia Brient</a> 
												<i class="fas fa-check-circle verified"></i>
											</h3>
											<p class="speciality">MBBS, MS - General Surgery, MCh - Urology</p>
											<div class="rating">
												<i class="fas fa-star filled"></i>
												<i class="fas fa-star filled"></i>
												<i class="fas fa-star filled"></i>
												<i class="fas fa-star filled"></i>
												<i class="fas fa-star"></i>
												<span class="d-inline-block average-rating">(4)</span>
											</div>
											<ul class="available-info">
												<li>
													<i class="fas fa-map-marker-alt"></i> Louisiana, USA
												</li>
												<li>
													<i class="far fa-clock"></i> Available on Fri, 22 Mar
												</li>
												<li>
													<i class="far fa-money-bill-alt"></i> $150 - $250 <i class="fas fa-info-circle" data-toggle="tooltip" title="Lorem Ipsum"></i>
												</li>
											</ul>
											<div class="row row-sm">
												<div class="col-6">
													<a href="doctor-profile.jsp" class="btn view-btn">View Profile</a>
												</div>
												<div class="col-6">
													<a href="booking.jsp" class="btn book-btn">Book Now</a>
												</div>
											</div>
										</div>
									</div>
								</div>
								
							</div>
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
		
		<!-- Sticky Sidebar JS -->
        <script src="assets/plugins/theia-sticky-sidebar/ResizeSensor.js"></script>
        <script src="assets/plugins/theia-sticky-sidebar/theia-sticky-sidebar.js"></script>
		
		<!-- Custom JS -->
		<script src="assets/js/script.js"></script>
		
	</body>

<!-- doccure/favourites.jsp  30 Nov 2019 04:12:17 GMT -->
</html>