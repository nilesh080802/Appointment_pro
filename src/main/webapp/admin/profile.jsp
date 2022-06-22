<!DOCTYPE html>
<html lang="en">
    
<!-- Mirrored from dreamguys.co.in/demo/doccure/admin/profile.jsp by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 30 Nov 2019 04:12:46 GMT -->
<head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
        <title>Doccure - Profile</title>
		
		<!-- Favicon -->
        <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.png">
		
		<!-- Bootstrap CSS -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
		
		<!-- Fontawesome CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/assets/css/font-awesome.min.css">
		
		<!-- Feathericon CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/assets/css/feathericon.min.css">
       
		
		<!-- Main CSS -->
        <link rel="stylesheet" href="assets/css/style.css">
		
		<!--[if lt IE 9]>
			<script src="assets/js/html5shiv.min.js"></script>
			<script src="assets/js/respond.min.js"></script>
		<![endif]-->
		
		<style type="text/css">
		
		.sizeSmall{
		
		  height: 0px;
		  width: 0px;
		
		}
		
		
		</style>
    </head>
    <body>
    
    <!--Manage session -->
		  <%if(session.getAttribute("type") == "doctor"){ %>
			
			<% response.sendRedirect("doctor-dashboard.jsp");%>
			
			<%}else if(session.getAttribute("type") == "patient") {%>
			 
			 <% response.sendRedirect("patient-dashboard.jsp");%>
			
			<%}else if(session.getAttribute("type") == "admin") {%>
			 
		
			
			<%}%>
		<!--Manage session end -->
	<!-- Sidebar -->
            <jsp:include page="adminSideBar.jsp"/> 
			<!-- /Sidebar -->
		<!-- Main Wrapper -->
        <div class="main-wrapper">
		
			<!-- Header -->
           	
				<jsp:include page="adminHeader.jsp"/>
			<!-- /Header -->
			
					<!-- Page Wrapper -->
            <div class="page-wrapper">
                <div class="content container-fluid">
					
					<!-- Page Header -->
					<div class="page-header">
						<div class="row">
							<div class="col">
								<h3 class="page-title">Profile</h3>
								<ul class="breadcrumb">
									<li class="breadcrumb-item"><a href="index.jsp">Dashboard</a></li>
									<li class="breadcrumb-item active">Profile</li>
								</ul>
							</div>
						</div>
					</div>
					<!-- /Page Header -->
					
					<div class="row">
						<div class="col-md-12">
							<div class="profile-header">
								<div class="row align-items-center">
									<div class="col-auto profile-image">
										<!-- <a href=" " style="text-decoration:none"> -->
										
										<input type="file" name="image" id="img" class="sizeSmall">
											<img class="rounded-circle" alt="User Image" src="${pageContext.request.contextPath}/admin/assets/img/profiles/avatar-01.jpg">
											<i class="fe fe-edit" onclick="openImg();" style=" 
											    position: absolute;
											    bottom: 30px;
											    right: 30px;
											    color: white;
											    background: green;
											    border-radius: 22%;
											    width: 30px;
											    height: 30px;
											    display: flex;
											    align-items: center;
											    justify-content: center;
											"></i>
										</a>
									</div>
									<div class="col ml-md-n2 profile-user-info">
										<h4 class="user-name mb-0">${adminData.getFirstName()} ${adminData.getLastName()} </h4>
										<h6 class="text-muted">${adminData.getEmail()}</h6>
										<div class="user-Location"><i class="fa fa-map-marker"></i> ${adminData.getCountry()} ${adminData.getState()}</div>
										<div class="about-text"> ${adminData.getAddress()} ${adminData.getCity()} ${adminData.getState()} ${adminData.getCountry()} ${adminData.getZipCode()}</div>
									</div>
									<div class="col-auto profile-btn">
										
										
									</div>
								</div>
							</div>
							<div class="profile-menu">
								<ul class="nav nav-tabs nav-tabs-solid">
									<li class="nav-item">
										<a class="nav-link active" data-toggle="tab" href="#per_details_tab">About</a>
									</li>
									<li class="nav-item">
										<a class="nav-link" data-toggle="tab" href="#password_tab">Password</a>
									</li>
								</ul>
							</div>	
							<div class="tab-content profile-tab-cont">
								
								<!-- Personal Details Tab -->
								<div class="tab-pane fade show active" id="per_details_tab">
								
									<!-- Personal Details -->
									<div class="row">
										<div class="col-lg-12">
											<div class="card">
												<div class="card-body">
													<h5 class="card-title d-flex justify-content-between">
														<span>Personal Details</span> 
														<a class="edit-link" data-toggle="modal" href="#edit_personal_details"><i class="fa fa-edit mr-1"></i>Edit</a>
													</h5>
													<div class="row">
														<p class="col-sm-2 text-muted text-sm-right mb-0 mb-sm-3">Name</p>
														<p class="col-sm-10">${adminData.getFirstName()} ${adminData.getLastName()}</p>
													</div>
													<div class="row">
														<p class="col-sm-2 text-muted text-sm-right mb-0 mb-sm-3">Date of Birth</p>
														<p class="col-sm-10">${adminData.getDateOfBirth()}</p>
													</div>
													<div class="row">
														<p class="col-sm-2 text-muted text-sm-right mb-0 mb-sm-3">Email ID</p>
														<p class="col-sm-10">${adminData.getEmail()}</p>
													</div>
													<div class="row">
														<p class="col-sm-2 text-muted text-sm-right mb-0 mb-sm-3">Mobile</p>
														<p class="col-sm-10">${adminData.getMobileNumber()}</p>
													</div>
													<div class="row">
														<p class="col-sm-2 text-muted text-sm-right mb-0">Address</p>
														<p class="col-sm-10 mb-0"> ${adminData.getAddress()}   <br>
														${adminData.getCity()} ,  ${adminData.getState()}<br>
														${adminData.getCountry()}<br>
														${adminData.getZipCode()} .</p>
													</div>
												</div>
											</div>
											
											<!-- Edit Details Modal -->
											<div class="modal fade" id="edit_personal_details" aria-hidden="true" role="dialog">
												<div class="modal-dialog modal-dialog-centered" role="document" >
													<div class="modal-content">
														<div class="modal-header">
															<h5 class="modal-title">Personal Details</h5>
															<button type="button" class="close" data-dismiss="modal" aria-label="Close">
																<span aria-hidden="true">&times;</span>
															</button>
														</div>
														<div class="modal-body">
															<form action="${pageContext.request.contextPath }/AdminController?action=editAdminData&mobile=${mobileNumber}" id="submit" method = "post">
																<div class="row form-row">
																	<div class="col-12 col-sm-6">
																		<div class="form-group">
																			<label>First Name</label>
																			<input type="text"  name="firstName" class="form-control" value=${adminData.getFirstName() }>
																		</div>
																	</div>
																	<div class="col-12 col-sm-6">
																		<div class="form-group">
																			<label>Last Name</label>
																			<input type="text"  name="lastName" class="form-control" value="${adminData.getLastName()}">
																		</div>
																	</div>
																	<div class="col-12">
																		<div class="form-group">
																			<label>Date of Birth</label>
																			<div class="cal-icon">
																				<input type="date"  name="dateOfBirth"class="form-control" value="${adminData.getDateOfBirth()}">
																			</div>
																		</div>
																	</div>
																	<div class="col-12 col-sm-6">
																		<div class="form-group">
																			<label>Email ID</label>
																			<input type="email" name="email" class="form-control" value="${adminData.getEmail()}">
																		</div>
																	</div>
																	<div class="col-12 col-sm-6">
																		<div class="form-group">
																			<label>Mobile</label>
																			<input type="text"  name="mobileNumber"  value="${adminData.getMobileNumber()}" class="form-control"  readonly>
																		</div>
																	</div>
																	<div class="col-12">
																		<h5 class="form-title"><span>Address</span></h5>
																	</div>
																	<div class="col-12">
																		<div class="form-group">
																		<label>Address</label>
																			<input type="text"  name="address" class="form-control" value="${adminData.getAddress()}">
																		</div>
																	</div>
																	<div class="col-12 col-sm-6">
																		<div class="form-group">
																			<label>City</label>
																			<input type="text" name="city" class="form-control" value="${adminData.getCity()}">
																		</div>
																	</div>
																	<div class="col-12 col-sm-6">
																		<div class="form-group">
																			<label>State</label>
																			<input type="text" name ="state" class="form-control" value="${adminData.getState()}">
																		</div>
																	</div>
																	<div class="col-12 col-sm-6">
																		<div class="form-group">
																			<label>Zip Code</label>
																			<input type="text" name="zipCode" class="form-control" value="${adminData.getZipCode()}">
																		</div>
																	</div>
																	<div class="col-12 col-sm-6">
																		<div class="form-group">
																			<label>Country</label>
																			<input type="text" name="country"  class="form-control" value="${adminData.getCountry()}">
																		</div>
																	</div>
																</div>
																<button type="submit" class="btn btn-primary btn-block">Save Changes</button>
															</form>
														</div>
													</div>
												</div>
											</div>
											<!-- /Edit Details Modal -->
											
										</div>

									
									</div>
									<!-- /Personal Details -->

								</div>
								<!-- /Personal Details Tab -->
								
								<!-- Change Password Tab -->
								<div id="password_tab" class="tab-pane fade">
								
									<div class="card">
										<div class="card-body">
											<h5 class="card-title">Change Password</h5>
											<div class="row">
												<div class="col-md-10 col-lg-6">
													<form>
														<div class="form-group">
															<label>Old Password</label>
															<input type="password" class="form-control">
														</div>
														<div class="form-group">
															<label>New Password</label>
															<input type="password" class="form-control">
														</div>
														<div class="form-group">
															<label>Confirm Password</label>
															<input type="password" class="form-control">
														</div>
														<button class="btn btn-primary" type="submit">Save Changes</button>
													</form>
												</div>
											</div>
										</div>
									</div>
								</div>
								<!-- /Change Password Tab -->
								
							</div>
						</div>
					</div>
				
				</div>			
			</div>
			<!-- /Page Wrapper -->
		
        </div>
		<!-- /Main Wrapper -->
		
		<!-- jQuery -->
        <script src="${pageContext.request.contextPath }/admin/assets/js/jquery-3.2.1.min.js"></script>
        
		
		<!-- Bootstrap Core JS -->
        <script src="assets/js/popper.min.js"></script>
        <script src="assets/js/bootstrap.min.js"></script>
		
		<!-- Slimscroll JS -->
        <script src="${pageContext.request.contextPath}/admin/assets/plugins/slimscroll/jquery.slimscroll.min.js"></script>
		
		<!-- Custom JS -->
		<script  src="assets/js/script.js"></script>
		<script>
		function openImg()
		{
			$("#img").trigger( "click" );
		}
		</script>
		
    </body>

<!-- Mirrored from dreamguys.co.in/demo/doccure/admin/profile.jsp by HTTrack Website Copier/3.x [XR&CO'2014], Sat, 30 Nov 2019 04:12:46 GMT -->
</html>