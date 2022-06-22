<!DOCTYPE html> 
<%@page import="java.util.ArrayList"%>
<%@page import="com.dollop.appointment.dao.DoctorDAOImp"%>
<%@page import="com.dollop.appointment.model.DoctorSettingData"%>
<html lang="en">
	
<!-- doccure/doctor-profile-settings.jsp  30 Nov 2019 04:12:14 GMT -->
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
		
		<!-- Select2 CSS -->
		<link rel="stylesheet" href="assets/plugins/select2/css/select2.min.css">
		
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="assets/plugins/bootstrap-tagsinput/css/bootstrap-tagsinput.css">
		
		<link rel="stylesheet" href="assets/plugins/dropzone/dropzone.min.css">
		
		<!-- Main CSS -->
		<link rel="stylesheet" href="assets/css/style.css">
		
		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
			<script src="assets/js/html5shiv.min.js"></script>
			<script src="assets/js/respond.min.js"></script>
		<![endif]-->
	
	</head>
	<body>

	<!-- Main Wrapper -->
		<div class="main-wrapper">
		
		<!-- Header -->
			<jsp:include page="header.jsp"/>
		<!-- /Header -->

<%-- 						
		<!-- managing session -->
			 <%if(session.getAttribute("type") == "doctor"){ %>			
					<%  response.sendRedirect("doctor-dashboard.jsp");%>			
			<%}else if(session.getAttribute("type") == "patient") {%>			 
			 <% response.sendRedirect("patient-dashboard.jsp");%>			
			<%}else{%>
			<% response.sendRedirect("login.jsp");%>
			<%} %>
		<!-- /managing session -->
			
 --%>			
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
				<form action=" ${pageContext.request.contextPath}/DoctorController?action=profileSettingInsData&mobile=${patient.getMobile()}" id="submit" method="post" >
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-5 col-lg-4 col-xl-3 theiaStickySidebar">
						
						<!-- Profile Sidebar -->
							<div class="profile-sidebar">
								<div class="widget-profile pro-widget-content">
									<div class="profile-info-widget">
										<a href="#" class="booking-doc-img">
											<img src="assets/img/doctors/doctor-thumb-02.jpg" alt="User Image">
										</a>
										<div class="profile-det-info">
											<h3>${doctor.getFirstName()} ${doctor.getLastName() }</h3>											
											<div class="patient-details">
												<h5 class="mb-0">BDS, MDS - Oral & Maxillofacial Surgery</h5>
											</div>
										</div>
									</div>
								</div>
								<div class="dashboard-widget">
									<nav class="dashboard-menu">
										<ul>
											<li>
												<a href="doctor-dashboard.jsp">
													<i class="fas fa-columns"></i>
													<span>Dashboard</span>
												</a>
											</li>
											<li>
												<a href="appointments.jsp">
													<i class="fas fa-calendar-check"></i>
													<span>Appointments</span>
												</a>
											</li>
											<li>
												<a href="my-patients.jsp">
													<i class="fas fa-user-injured"></i>
													<span>My Patients</span>
												</a>
											</li>
											<li>
												<a href="schedule-timings.jsp">
													<i class="fas fa-hourglass-start"></i>
													<span>Schedule Timings</span>
												</a>
											</li>
											<li>
												<a href="${pageContext.request.contextPath}/DoctorController?action=getAllInvoiceDetails">
													<i class="fas fa-file-invoice"></i>
													<span>Invoices</span>
												</a>
											</li>
											<li>
												<a href="reviews.jsp">
													<i class="fas fa-star"></i>
													<span>Reviews</span>
												</a>
											</li>
											<li>
												<a href="chat-doctor.jsp">
													<i class="fas fa-comments"></i>
													<span>Message</span>
													<small class="unread-msg">23</small>
												</a>
											</li>
											<li class="active">
												<%-- <a href="${pageContext.request.contextPath}/DoctorController?action=getDoctorDetails&mobile=${mobileNumber}&doctorId=${doctorId}"> --%>
												<a href="${pageContext.request.contextPath}/DoctorController?action=getDoctorDetails">
													<i class="fas fa-user-cog"></i>
													<span>Profile Settings</span>
												</a>
											</li>
											<li>
												<a href="social-media.jsp">
													<i class="fas fa-share-alt"></i>
													<span>Social Media</span>
												</a>
											</li>
											<li>
												<a href="doctor-change-password.jsp">
													<i class="fas fa-lock"></i>
													<span>Change Password</span>
												</a>
											</li>
											<li>
												<a href="index-2.jsp">
													<i class="fas fa-sign-out-alt"></i>
													<span>Logout</span>
												</a>
											</li>
										</ul>
									</nav>
								</div>
							</div>
						<!-- /Profile Sidebar -->							
						</div>
					
					<%String mobileNumber =(String)session.getAttribute("mobileNumber");%>	
					<%DoctorDAOImp udi = new DoctorDAOImp();%>
					<%int doctorId = (Integer)session.getAttribute("doctorId"); %>
					<%DoctorSettingData doctor = udi.getDoctor(mobileNumber,doctorId);%>
					
					
											
						<div class="col-md-7 col-lg-8 col-xl-9">
						<%if(request.getAttribute("failedMsg") != null){%>
						<div id="alert" class="alert alert-danger" role="alert">
  							<%=request.getAttribute("failedMsg") %>													
						</div>
					<%}else if(request.getAttribute("successMessage")!=null){%>
						<div id="alert" class="alert alert-success" role="alert">
  							<%=request.getAttribute("successMessage") %>												
						</div>
					<%}%>
						
						<!-- Basic Information -->
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">Basic Information</h4>									
										<div class="row form-row">
											<div class="col-md-12">
												<div class="form-group">
													<div class="change-avatar">
														<div class="profile-img">
															<img src="${doctor.getImagePath()}" alt="User Image"> 	<!-- assets/img/doctors/doctor-thumb-02.jpg -->
														</div>
														<div class="upload-img">
															<div class="change-photo-btn">
																<span><i class="fa fa-upload"></i> Upload Photo</span>
																<input type="file" class="upload" name="image">
															</div>
															<small class="form-text text-muted">Allowed JPG, GIF or PNG. Max size of 2MB</small>
														</div>
													</div>
												</div>
											</div>																													
											<div class="col-md-6">
												<div class="form-group">
													<label>First Name <span class="text-danger" >*</span></label>
													<input type="text" class="form-control" name="firstName" value="${doctor.getFirstName()}">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label>Last Name <span class="text-danger" ">*</span></label>
													<input type="text" class="form-control" name="lastName" value="${doctor.getLastName()}">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label>Phone Number </label>
													<input type="text" class="form-control" name="mobileNumber" value="${doctor.getMobileNumber() }">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label>Gender</label>
													<select class="form-control select" name="gender" value="${doctor.getGender()}">
														<option>Select</option>
														<option>Male</option>
														<option>Female</option>
													</select>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label>Date of Birth</label>
													<div class="cal-icon">
														<input type="date" class="form-control datetimepicker" name="dateOfBirth" value="${doctor.getDateOfBirth()}">
												   </div>
												</div>
											</div>
										</div>	
									</div>
								</div>								
							<!-- /Basic Information -->
							
							<!-- About Me -->
								<div class="card">
									<div class="card-body">
										<h4 class="card-title">About Me</h4>
										<div class="form-group mb-0"> 
											<label>Biography</label>
											<textarea class="form-control" rows="5" name="biography">${doctor.getBiography() }</textarea>
										</div>
									</div>
								</div>
							<!-- /About Me -->
							
							<!-- Clinic Info -->
								<div class="card">
									<div class="card-body">
										<h4 class="card-title">Clinic Info</h4>
										<div class="row form-row">
											<div class="col-md-6">
												<div class="form-group">
													<label>Clinic Name</label>
													<input type="text" class="form-control" name="clinicName" value="${doctor.getClinicName()}">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label>Clinic Address</label>
													<input type="text" class="form-control" name="clinicAddress" value="${doctor.getClinicAddress()}">
												</div>
											</div>
											<div class="col-md-12">
												<div class="form-group">
													<label>Clinic Images</label>
													<form action="#" class="dropzone"></form>
												</div>
												<div class="upload-wrap">
													<div class="upload-images">
														<img src="assets/img/features/feature-01.jpg" alt="Upload Image">
														<a href="javascript:void(0);" class="btn btn-icon btn-danger btn-sm"><i class="far fa-trash-alt"></i></a>
													</div>
													<div class="upload-images">
														<img src="assets/img/features/feature-02.jpg" alt="Upload Image">
														<a href="javascript:void(0);" class="btn btn-icon btn-danger btn-sm"><i class="far fa-trash-alt"></i></a>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							<!-- /Clinic Info -->

							<!-- Contact Details -->
								<div class="card contact-card">
									<div class="card-body">
										<h4 class="card-title">Contact Details</h4>
										<div class="row form-row">
											<div class="col-md-6">
												<div class="form-group">
													<label>Address Line 1</label>
													<input type="text" class="form-control" name="addressLine1" value="${doctor.getAddressLine1()}">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="control-label">Address Line 2</label>
													<input type="text" class="form-control" name="addressLine2" value="${doctor.getAddressLine2()}">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="control-label">City</label>
													<input type="text" class="form-control" name="city" value="${doctor.getCity()}" >
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="control-label">State / Province</label>
													<input type="text" class="form-control" name="state" value="${doctor.getState()}">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="control-label">Country</label>
													<input type="text" class="form-control" name="country" value="${doctor.getCountry()}">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="control-label">Postal Code</label>
													<input type="text" class="form-control" name="postalCode" value="${doctor.getPostalCode()}">
												</div>
											</div>
										</div>
									</div>
								</div>
							<!-- /Contact Details -->
							
							<!-- Pricing -->
								<div class="card">
									<div class="card-body">
										<h4 class="card-title">Pricing</h4>									
										<div class="form-group mb-0">
											<div id="pricing_select">
												<div class="custom-control custom-radio custom-control-inline">
													<input type="radio" id="price_free" name="rating_option" class="custom-control-input" value="price_free" checked>
													<label class="custom-control-label" for="price_free">Free</label>
												</div>
												<div class="custom-control custom-radio custom-control-inline">
													<input type="radio" id="price_custom" name="rating_option" value="custom_price" class="custom-control-input">
													<label class="custom-control-label" for="price_custom">Custom Price (per hour)</label>
												</div>
											</div>
										</div>									
										<div class="row custom_price_cont" id="custom_price_cont" style="display: none;">
											<div class="col-md-4">
												<input type="text" class="form-control" id="custom_rating_input" name="pricing" value="${doctor.getPricing() }" placeholder="20">
												<small class="form-text text-muted">Custom price you can add</small>
											</div>
										</div>									
									</div>
								</div>
							<!-- /Pricing -->
							
							<!-- Services and Specialization -->
								<div class="card services-card">
									<div class="card-body">
										<h4 class="card-title">Services and Specialization</h4>
										<div class="form-group">
											<label>Services</label>
											<input type="text" data-role="tagsinput" class="input-tags form-control" placeholder="Enter Services" name="services" value="${doctor.getServices() }" id="services">
											<small class="form-text text-muted">Note : Type and Press Enter to add new Services</small>
										</div> 
										<div class="form-group mb-0">
											<label>Specialization </label>
											<input class="input-tags form-control" type="text" data-role="tagsinput" placeholder="Enter Specialization" name="specialist" value="${doctor.getSpecialist() }" id="specialist">
											<small class="form-text text-muted"> Note : Type and Press  Enter to add new Specialization</small>
										</div> 
									</div>              
								</div>
							<!-- /Services and Specialization -->
						 
							<!-- Education -->
								<div class="card">
									<div class="card-body">
									<h4 class="card-title">Education</h4>
										<div class="education-info">
											<div class="row form-row education-cont">
												<div class="col-12 col-md-10 col-lg-11">
													<div class="row form-row">
														
														<%ArrayList<Integer> degreeId = doctor.getDegreeId(); %>
														<%ArrayList<String> degree = doctor.getDegree(); %>
														<%ArrayList<String> college = doctor.getCollege(); %>
														<%ArrayList<String> yearCompletion = doctor.getYearCompletetion(); %>	
														<%if(degreeId.size() != 0){ %>
															<!-- <p>Inside Education If</p> -->
														<%for(int i=0;i<degreeId.size();i++){ %>
										
														<div class="col-12 col-md-6 col-lg-4">								
															<div class="form-group">
																<label>Degree</label>
																<input type="text" class="form-control" name="degree" value="<%=degree.get(i)%>">
																<input type="hidden" name="degreeId" value="<%=degreeId.get(i) %>">															
															</div> 
														</div>
														<div class="col-12 col-md-6 col-lg-4">
															<div class="form-group">
																<label>College/Institute</label>
																<input type="text" class="form-control" name="college" value="<%=college.get(i)%>">
															</div> 
														</div>
														<div class="col-12 col-md-6 col-lg-4">
															<div class="form-group">
																<label>Year of Completion</label>
																<input type="text" class="form-control" name="yearCompletetion" value="<%=yearCompletion.get(i)%>">
															</div> 
														</div>
														<%} }else{%>
														<div class="col-12 col-md-6 col-lg-4">								
															<div class="form-group">
																<label>Degree</label>
																<input type="text" class="form-control" name="degree" value="">
																<input type="hidden" name="degreeId">															
															</div> 
														</div>
														<div class="col-12 col-md-6 col-lg-4">
															<div class="form-group">
																<label>College/Institute</label>
																<input type="text" class="form-control" name="college" value="">
															</div> 
														</div>
														<div class="col-12 col-md-6 col-lg-4">
															<div class="form-group">
																<label>Year of Completion</label>
																<input type="text" class="form-control" name="yearCompletetion" value="">
															</div> 
														</div>
														<%} %>
													</div>
												</div>
											</div>
										</div>
										<div class="add-more">
											<a href="javascript:void(0);" class="add-education"><i class="fa fa-plus-circle"></i> Add More</a>
										</div>
									</div>
								</div>
							<!-- /Education -->
						
							<!-- Experience -->
								<div class="card">
									<div class="card-body">
										<h4 class="card-title">Experience</h4>
										<div class="experience-info">
											<div class="row form-row experience-cont">
												<div class="col-12 col-md-10 col-lg-11">
													
													
													<%ArrayList<Integer> hospitalId = doctor.getHospitalId();%>
													<%ArrayList<String> hospitalName = doctor.getHospitalName(); %>
													<%ArrayList<String> fromYear = doctor.getFrom(); %>
													<%ArrayList<String> toYear = doctor.getTo(); %>
													<%ArrayList<String> designation = doctor.getDesignation(); %>
													<%if(hospitalId.size() != 0){ %>
													<%for(int i=0;i<hospitalId.size();i++){ %>
													<div class="row form-row">
														<div class="col-12 col-md-6 col-lg-4">
															<div class="form-group">
																<label>Hospital Name</label>
																<input type="text" class="form-control" name="hospitalName" value="<%=hospitalName.get(i)%>">
																<input type="hidden" name="hospitalId" value="<%=hospitalId.get(i)%>">
															</div> 
														</div>
														<div class="col-12 col-md-6 col-lg-4">
															<div class="form-group">
																<label>From</label>
																<input type="text" class="form-control" name="from" value="<%=fromYear.get(i)%>">
															</div> 
														</div>
														<div class="col-12 col-md-6 col-lg-4">
															<div class="form-group">
																<label>To</label>
																<input type="text" class="form-control" name="to" value="<%=toYear.get(i)%>">
															</div> 
														</div>
														<div class="col-12 col-md-6 col-lg-4">
															<div class="form-group">
																<label>Designation</label>
																<input type="text" class="form-control" name="Designation" value="<%=designation.get(i)%>">
															</div> 
														</div>
													</div>	
													<%}}else{ %>
													<div class="row form-row">	
														<div class="col-12 col-md-6 col-lg-4">
															<div class="form-group">
																<label>Hospital Name</label>
																<input type="text" class="form-control" name="hospitalName" value="">
																<input type="hidden" name="hospitalId" value="">
															</div> 
														</div>
														<div class="col-12 col-md-6 col-lg-4">
															<div class="form-group">
																<label>From</label>
																<input type="text" class="form-control" name="from" value="">
															</div> 
														</div>
														<div class="col-12 col-md-6 col-lg-4">
															<div class="form-group">
																<label>To</label>
																<input type="text" class="form-control" name="to" value="">
															</div> 
														</div>
														<div class="col-12 col-md-6 col-lg-4">
															<div class="form-group">
																<label>Designation</label>
																<input type="text" class="form-control" name="Designation" value="">
															</div> 
														</div>
													</div>
													<%} %>													
												</div>
											</div>
										</div>
										<div class="add-more">
											<a href="javascript:void(0);" class="add-experience"><i class="fa fa-plus-circle"></i> Add More</a>
										</div>
									</div>
								</div>
							<!-- /Experience -->
							
								<%ArrayList<Integer> awardId = doctor.getAwardId(); %>
								<%ArrayList<String> awardName = doctor.getAward(); %>
								<%ArrayList<String> awardYear = doctor.getAwardYear(); %>
							
							<!-- Awards -->
								<div class="card">
									<div class="card-body">
										<h4 class="card-title">Awards</h4>
										<div class="awards-info">
											<div class="row form-row awards-cont">
												<%if(awardId.size() != 0){%>
												<%for(int i=0;i<awardId.size();i++){ %> 
												<div class="col-12 col-md-5">
													<div class="form-group">
														<label>Awards</label>
														<input type="text" class="form-control" name="award" value="<%=awardName.get(i) %>">
														<input type="hidden" name="awardId" value="<%=awardId.get(i)%>">
													</div> 
												</div>
												<div class="col-12 col-md-5">
													<div class="form-group">
														<label>Year</label>
														<input type="text" class="form-control" name="awardYear" value="<%=awardYear.get(i)%>">
													</div> 
												</div>
												<%}}else{%>
												<div class="col-12 col-md-5">
													<div class="form-group">
														<label>Awards</label>
														<input type="text" class="form-control" name="award" value="">
														<input type="hidden" name="awardId" value="">
													</div> 
												</div>
												<div class="col-12 col-md-5">
													<div class="form-group">
														<label>Year</label>
														<input type="text" class="form-control" name="awardYear" value="">
													</div> 
												</div>	
												<%} %>
											</div>
										</div> 					
										<div class="add-more">
											<a href="javascript:void(0);" class="add-award"><i class="fa fa-plus-circle"></i> Add More</a>
										</div>
									</div>	
								</div>
							<!-- /Awards -->
							
							<!-- Memberships -->
								<div class="card">
									<div class="card-body">
									<h4 class="card-title">Memberships</h4>
										<div class="membership-info">
											<%ArrayList<Integer> membershipId = doctor.getMembershipId(); %>
											<%ArrayList<String> membership = doctor.getMemberships(); %>
											<%if(membershipId.size() != 0){ %>
											<%for(int i=0;i<membershipId.size();i++){ %>																					
											
											<div class="col-12 col-md-10 col-lg-5">
												<div class="form-group">
													<label>Memberships</label>
													<input type="text" class="form-control" name="memberships" value="<%=membership.get(i)%>">
													<input type="hidden" name="membershipId" value="<%=membershipId.get(i)%>">
												</div> 
											</div>									
											<%}}else{ %>
											<div class="row form-row membership-cont">											
												<div class="col-12 col-md-10 col-lg-5">
													<div class="form-group">
														<label>Memberships</label>
														<input type="text" class="form-control" name="memberships" value="">
														<input type="hidden" name="membershipId" value="">
													</div> 
												</div>
											</div>
											<%} %>
										</div>										
										<div class="add-more">
											<a href="javascript:void(0);" class="add-membership"><i class="fa fa-plus-circle"></i> Add More</a>
										</div>
									</div>
								</div>
							<!-- /Memberships -->
							
							<!-- Registrations -->
								<div class="card">
									<div class="card-body">
										<h4 class="card-title">Registrations</h4>
										<div class="registrations-info">
											<div class="row form-row reg-cont">
										
											<%ArrayList<Integer> registrationId = doctor.getRegistartionId(); %>
											<%ArrayList<String> registration = doctor.getRegistration(); %>
											<%ArrayList<String> registrationYear = doctor.getRegistrationYear(); %>	
											<%if(registrationId.size() != 0){ %>
											<%for(int i=0;i<registrationId.size();i++){ %>											
												<div class="col-12 col-md-5">
													<div class="form-group">
														<label>Registrations</label>
														<input type="text" class="form-control" name="registration" value="<%=registration.get(i)%>">
														<input type="hidden" name="registrationId" value="<%=registrationId.get(i)%>">
													</div> 
												</div>
												<div class="col-12 col-md-5">
													<div class="form-group">
														<label>Year</label>
														<input type="text" class="form-control" name="registrationYear" value="<%=registrationYear.get(i)%>">
													</div> 
												</div>
											<%}}else{%>
												
												<div class="col-12 col-md-5">
													<div class="form-group">
														<label>Registrations</label>
														<input type="text" class="form-control" name="registration" value="">
													</div> 
												</div>
												<div class="col-12 col-md-5">
													<div class="form-group">
														<label>Year</label>
														<input type="text" class="form-control" name="registrationYear" value="">
													</div> 
												</div>
											<%} %>
											</div>
										</div>
										<div class="add-more">
											<a href="javascript:void(0);" class="add-reg"><i class="fa fa-plus-circle"></i> Add More</a>
										</div>
									</div>
								</div>
							<!-- /Registrations -->
							
								<div class="submit-section submit-btn-bottom">
									<button type="submit" class="btn btn-primary submit-btn">Save Changes</button>
								</div>						
							</div>									
						</div>						
					</div>	
				</form>
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
		
		<!-- Select2 JS -->
		<script src="assets/plugins/select2/js/select2.min.js"></script>
		
		<!-- Dropzone JS -->
		<script src="assets/plugins/dropzone/dropzone.min.js"></script>
		
		<!-- Bootstrap Tagsinput JS -->
		<script src="assets/plugins/bootstrap-tagsinput/js/bootstrap-tagsinput.js"></script>
		
		<!-- Profile Settings JS -->
		<script src="assets/js/profile-settings.js"></script>
		
		<!-- Custom JS -->
		<script src="assets/js/script.js"></script>
			
	</body>

<!-- doccure/doctor-profile-settings.jsp  30 Nov 2019 04:12:15 GMT -->
</html>
<!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script> -->
<script type="text/javascript">
		
setTimeout(function () 
		{
			<%request.removeAttribute("successMsg"); %>
			<%request.removeAttribute("failedMsg");%>
        	// Closing the alert
        	$('#alert').alert('close');
    	}, 10000);
		
		$("form").on("change",function(event){
			event.preventDefault();
			var form = $("#myform")[0];
			var data = new FormData(form);
			
			$.ajax({
				url : "UploadServlet",
				type : "POST",
				data : data,
				processData : false,
				contentType: false,
				success: function(res)
				{
					console.log(res);
					$("#imgPath").attr("value",res);
					$("#newImg").attr("src",res);
					$("#img").attr("src",res);
				}
			});
		});
</script>

