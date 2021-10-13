<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="x-ua-compatible" content="ie=edge">

<title>Blog</title>

<!-- Font Awesome Icons -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/plugins/fontawesome-free/css/all.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/admin/dist/css/adminlte.min.css">
<!-- Google Font: Source Sans Pro -->
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700"
	rel="stylesheet">
<!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
</head>
<body class="hold-transition sidebar-mini">
	<div class="wrapper">

		<jsp:include page="include-admin-header.jsp"></jsp:include>

		<jsp:include page="include-admin-sidebar-menu.jsp"></jsp:include>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1>Admin Homepage</h1>
						</div>

					</div>
				</div>
				<!-- /.container-fluid -->
			</section>
			
			<section>
            	<jsp:include page="include-admin-filter.jsp"></jsp:include>
            </section>

			<!-- Main content -->
			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="card">

								

								<!-- /.card-header -->
								<div class="card-body">

									<div class="row">

										<div class="col-lg-3 col-6">
											<!-- small box -->
											<div class="small-box bg-info">
												<div class="inner">
													<h3>${unreadMessagesCounter}</h3>

													<p>New Messages</p>
													
												</div>
												<div class="icon">
													<i class="ion ion-email"></i>
												</div>
												<a href="message-list" class="small-box-footer">See all messages <i
													class="fas fa-arrow-circle-right"></i></a>
											</div>
										</div>
										<!-- ./col -->
										<div class="col-lg-3 col-6">
											<!-- small box -->
											<div class="small-box bg-success">
												<div class="inner">
													<h3>
														53
													</h3>

													<p>New Blogs</p>
												</div>
												<div class="icon">
													<i class="ion ion-document-text"></i>
												</div>
												<a href="blog-list" class="small-box-footer">View all Blogs <i
													class="fas fa-arrow-circle-right"></i></a>
											</div>
										</div>
										<!-- ./col -->
										<div class="col-lg-3 col-6">
											<!-- small box -->
											<div class="small-box bg-warning">
												<div class="inner">
													<h3>44</h3>

													<p>New Comments</p>
												</div>
												<div class="icon">
													<i class="ion ion-chatbubble-working"></i>
												</div>
												<a href="#" class="small-box-footer">View all comments <i
													class="fas fa-arrow-circle-right"></i></a>
											</div>
										</div>
										<!-- ./col -->
										<div class="col-lg-3 col-6">
											<!-- small box -->
											<div class="small-box bg-danger">
												<div class="inner">
													<h3>65</h3>

													<p>Number of views</p>
												</div>
												<div class="icon">
													<i class="ion ion-eye"></i>
												</div>
												<a href="#" class="small-box-footer">More info <i
													class="fas fa-arrow-circle-right"></i></a>
											</div>
										</div>
										<!-- ./col -->

									</div>



								</div>
								<!-- /.card-body -->
								<div class="card-footer clearfix"></div>
							</div>
							<!-- /.card -->
						</div>
						<!-- /.col -->
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</section>
			<!-- /.content -->


			<!-- /.modal -->
		</div>
		<!-- /.content-wrapper -->



		<!-- Main Footer -->
		<footer class="main-footer">
			<!-- To the right -->
			<div class="float-right d-none d-sm-inline">Java</div>
			<!-- Default to the left -->
			<strong>Copyright &copy; 2021 <a
				href="https://www.mmaksimovic.rs">Mirko Maksimovic</a>.
			</strong> All rights reserved.
		</footer>
	</div>
	<!-- ./wrapper -->

	<!-- REQUIRED SCRIPTS -->

	<!-- jQuery -->
	<script
		src="${pageContext.request.contextPath}/admin/plugins/jquery/jquery.min.js"></script>
	<!-- Bootstrap 4 -->
	<script
		src="${pageContext.request.contextPath}/admin/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- AdminLTE App -->
	<script
		src="${pageContext.request.contextPath}/admin/dist/js/adminlte.min.js"></script>
</body>
</html>


