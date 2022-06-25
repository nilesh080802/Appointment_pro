<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html lang="en">
	
<!-- doccure/profile-settings.jsp  30 Nov 2019 04:12:18 GMT -->
<head>
		 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Doccure</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
		
		<!-- Favicons -->
		<link href="assets/img/favicon.png" rel="icon">
		
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="assets/css/bootstrap.min.css">
		
		<!-- Fontawesome CSS -->
		<link rel="stylesheet" href="assets/plugins/fontawesome/css/fontawesome.min.css">
		<link rel="stylesheet" href="assets/plugins/fontawesome/css/all.min.css">
		
		<!-- Datetimepicker CSS -->
		<link rel="stylesheet" href="assets/css/bootstrap-datetimepicker.min.css">
		
		<!-- Select2 CSS -->
		<link rel="stylesheet" href="assets/plugins/select2/css/select2.min.css">
		
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
									<li class="breadcrumb-item active" aria-current="page">Profile Settings</li>
								</ol>
							</nav>
							<h2 class="breadcrumb-title">Profile Settings</h2>
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
											
											<img src="${patient.getImagePath()}" alt="User Image">
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
											<li>
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
											<li class="active">
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
							<div class="card">
								<div class="card-body">
								<!-- Profile Settings Form image-->
					             	<form id="myform" method="post" action="UploadServlet" enctype="multipart/form-data">
								
										
										<div class="row form-row">
										
											<div class="col-12 col-md-12">
												<div class="form-group">
													<div class="change-avatar">
														<div class="profile-img">
														
														<img src= "${patient.getImagePath()}" alt="User Image" ">
													<
														</div>
														
														<div class="upload-img">
															<div class="change-photo-btn">
																<span><i class="fa fa-upload"></i> Upload Photo</span>
																
																<input type="file" class="upload" name="image" >
															
															</div>
															<small class="form-text text-muted">Allowed JPG, GIF or PNG. Max size of 2MB</small>
														
														</div>
													</div>
												</div>
										    </div>
									  </div>
									 		
					    	   </form>
					 <!-- /Profile Settings Form image-->
					
					<!-- Profile Settings Form data -->
							<form  action="${pageContext.request.contextPath}/PatientController?action=profileSettingInsData&mobile=${patient.getMobile()}" id="submit" method ="POST"  >
									
								  <div class="row form-row">
										
										
										
											<div class="col-12 col-md-6">
										    <p style="color:red;">
											<%if(request.getAttribute("msg")!=null){ %>
											
											<%= request.getAttribute("msg") %>
											
											<%}%>
											</p>
											 <p style="color:green;">
											<%if(request.getAttribute("msg1")!=null){ %>
											
											<%= request.getAttribute("msg1") %>
											
											<%}%>
											</p>
												
											</div>		
											<div class="col-12 col-md-6">
												<div class="form-group">
													<label>First Name</label>
													<input type="text" class="form-control" name="firstName" value="${patient.getFirstName()}" required>
												</div>
											</div>
											<div class="col-12 col-md-6">
												<div class="form-group">
													<label>Last Name</label>
													<input type="text" class="form-control" name="lastName" value="${patient.getLastName()}" required>
												</div>
											</div>
											<div class="col-12 col-md-6">
												<div class="form-group">
													<label>Date of Birth</label>
													<div class="cal-icon">
														<input type="text" class="form-control datetimepicker" name="dateOfBirth" value="${patient.getDateOfBirth()}" required>
													</div>
												</div>
											</div>
											<%--<div class="col-12 col-md-6">
												<div class="form-group">
													<label>Age</label>
													<div class="cal-icon">
														<input type="text"  name="Age" value="${patient.getAge()}" required>
													</div>
												</div>
											</div> --%>
											
											
											<div class="col-12 col-md-6">
												<div class="form-group">
													<label>Blood Group</label>
													<select class="form-control select" name="bloodGroup" required>
														<option>${patient.getBloodGroup()}</option>
														<option>A-</option>
														<option>A+</option>
														<option>B-</option>
														<option>B+</option>
														<option>AB-</option>
														<option>AB+</option>
														<option>O-</option>
														<option>O+</option>
													</select>
												</div>
											</div>
											<div class="col-12 col-md-6">
												<div class="form-group">
													<label>Email ID</label>
													<input type="email" class="form-control" name="emailId" value="${patient.getEmailId()}" required>
												</div>
											</div>
											<div class="col-12 col-md-6">
												<div class="form-group">
													<label>Mobile</label>
													<input type="readonly"  name="mobile" class="form-control" value="${patient.getMobile()}" readonly required>
												</div>
											</div>
											<div class="col-12">
												<div class="form-group">
												<label>Address</label>
													<input type="text" class="form-control" name="address" value="${patient.getAddress()}" required>
												</div>
											</div>
											<div class="col-12 col-md-6">
												<div class="form-group">
													<label>City</label>
													<input type="text" class="form-control" name="city" value="${patient.getCity()}" required>
												</div>
											</div>
											<div class="col-12 col-md-6">
												<div class="form-group">
													<label>State</label>
													<input type="text" class="form-control" name="state" value="${patient.getState()}" required>
												</div>
											</div>
											<div class="col-12 col-md-6">
												<div class="form-group">
													<label>Zip Code</label>
													<input type="text" class="form-control" name="zipCode" value="${patient.getZipCode()}" required>
												</div>
											</div>
											<div class="col-12 col-md-6">
												<div class="form-group">
													<label>Country</label>
													<input type="text" class="form-control" name="country" value="${patient.getCountry()}" required>
												</div>
											</div>
										</div>
										<div class="submit-section">
										    <input type="hidden" name="image"  id="imgPath">
											<button type="submit" class="btn btn-primary submit-btn">Save Changes</button>
										</div>
									
									</form>
									<!-- /Profile Settings Form data -->
									
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
		
		<!-- Select2 JS -->
		<script src="assets/plugins/select2/js/select2.min.js"></script>
		
		<!-- Datetimepicker JS -->
		<script src="assets/js/moment.min.js"></script>
		<script src="assets/js/bootstrap-datetimepicker.min.js"></script>
		
		<!-- Sticky Sidebar JS -->
        <script src="assets/plugins/theia-sticky-sidebar/ResizeSensor.js"></script>
        <script src="assets/plugins/theia-sticky-sidebar/theia-sticky-sidebar.js"></script>
		
		<!-- Custom JS -->
		<script src="assets/js/script.js"></script>
		
	</body>

<!-- doccure/profile-settings.jsp  30 Nov 2019 04:12:18 GMT -->
</html>
<script>
$( "form" ).on( "change", function( event ) {
	alert("upload servlet");
	  event.preventDefault();
	  var form = $('#myform')[0];
      var data = new FormData(form);
      
	$.ajax({
	   
		url: "UploadServlet",
	    type: "POST",
	    username:"patientPhoto",
	    data: data,
	    processData: false,
	    contentType: false,
	    success: function (res) {
	    	console.log(res); 
	    	$("#imgPath").attr("value",res);
	    	$("#newImg").attr("src",res);
	    	$("#img").attr("src",res);
	    }
	  });
});
</script>