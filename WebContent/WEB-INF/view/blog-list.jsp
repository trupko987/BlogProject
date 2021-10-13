<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="x-ua-compatible" content="ie=edge">

<title>MM Blog - Admin Page</title>

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
							<h1>Blogs</h1>
						</div>
						<div class="col-sm-6">
							<ol class="breadcrumb float-sm-right">
								<li class="breadcrumb-item"><a href="#">Home</a></li>
								<li class="breadcrumb-item active">Blogs</li>
							</ol>
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
								<div class="card-header">
									<h3 class="card-title">Blog List</h3>
									<div class="card-tools">
										<a href="blog-form.html" class="btn btn-success"
											Title="Add new Blog"> <i class="fas fa-plus-square"></i>
											Add new Blog
										</a>
									</div>
								</div>
								<!-- /.card-header -->
								<div class="card-body">
									<table class="table table-bordered">
										<thead>
											<tr>
												<th style="width: 10px">ID</th>
												<th class="text-center">enable/disable</th>
												<th class="text-center">Photo</th>
												<th style="width: 30%;">Title</th>
												<th class="text-center" style="width: 20%;">Category</th>
												<th class="text-center">Created By</th>
												<th class="text-center">Created At</th>
												<th class="text-center">Number of comments</th>
												<th class="text-center">Number of views</th>
												<th class="text-center">Actions</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="blog" items="${blogs}">
												<tr>
													<td>${blog.id}</td>
													<td class="text-center"><c:choose>
															<c:when test="${blog.enabled}">
																<a href="blog-enabled?id=${blog.id}"
																	class="btn btn-info"> <i
																	class="fas fa-check-circle"></i>
																</a>
															</c:when>
															<c:otherwise>
																<a href="blog-enabled?id=${blog.id}"
																	class="btn btn-danger"> <i
																	class="fas fa-minus-circle"></i>
																</a>
															</c:otherwise>
														</c:choose></td>
													<td class="text-center"><img src="${blog.image}"
														style="max-width: 80px;"></td>
													<td><a href="blog-admin-detail?id=${blog.id}"> <strong>${blog.title}</strong>
													</a></td>
													<td class="text-center">${blog.category.name}</td>
													<td class="text-center">${blog.author.name}
														${blog.author.surname}</td>
													<td class="text-center">${blog.date}</td>
													<td class="text-center">Number of comments</td>
													<td class="text-center">Number of views</td>
													<td class="text-center">
														<div class="btn-group">
															<a href="/BlogProject/blog-post?id=${blog.id}"
																class="btn btn-info" target="_blank"
																title="Preview on front page"> preview </a> <a
																href="blog-update?id=${blog.id}" class="btn btn-info"
																title="Edit"> <i class="fas fa-edit"></i>
															</a> <a href="#" class="btn btn-info" title="Important">
																<i class="fas fa-exclamation-triangle"></i>
															</a>
															<button type="button" class="btn btn-info"
																data-toggle="modal"
																data-target="#delete-modal-${blog.id}"
																title="Delete blog">
																<i class="fas fa-trash"></i>
															</button>
														</div>
													</td>
												</tr>
												<div class="modal fade" id="delete-modal-${blog.id}">
													<div class="modal-dialog">
														<div class="modal-content">
															<div class="modal-header">
																<h4 class="modal-title">Delete Blog</h4>
																<button type="button" class="close" data-dismiss="modal"
																	aria-label="Close">
																	<span aria-hidden="true">&times;</span>
																</button>
															</div>
															<div class="modal-body">
																<p>Are you sure you want to delete blog
																	"${blog.title}"?</p>
																<strong></strong>
															</div>
															<div class="modal-footer justify-content-between">
																<button type="button" class="btn btn-default"
																	data-dismiss="modal">Cancel</button>
																<a href="blog-delete?id=${blog.id}">
																	<button type="button" class="btn btn-danger">Delete</button>
																</a>
															</div>
														</div>
														<!-- /.modal-content -->
													</div>
													<!-- /.modal-dialog -->
												</div>
											</c:forEach>
										</tbody>
									</table>
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
			<div class="modal fade" id="delete-modal">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<h4 class="modal-title">Delete Blog</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">
							<p>Are you sure you want to delete blog?</p>
							<strong></strong>
						</div>
						<div class="modal-footer justify-content-between">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Cancel</button>
							<button type="button" class="btn btn-danger">Delete</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
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