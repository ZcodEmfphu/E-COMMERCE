<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html dir="ltr" lang="en">

<head>
<meta charset="utf-8">
<title>Manager User</title>
<link rel="icon" type="image/png" sizes="16x16"
	href="./Image/favicon.png">
<!-- Custom CSS -->
<link href="./admin/css/style.min.css" rel="stylesheet">
<link href="./admin/css/bootstrap.min.css" rel="stylesheet">
<link href="./admin/css/jquery.dataTables.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="../themify-icons/themify-icons.css">
<link href="./css/main.css" rel="stylesheet">
</head>

<body>
	<jsp:include page="adminHeader.jsp"></jsp:include>

	<fmt:setLocale value="${sessionScope.langName}" />
	<fmt:setBundle basename="i18n.lang" var="lang" />

	<div class="preloader">
		<div class="lds-ripple">
			<div class="lds-pos"></div>
			<div class="lds-pos"></div>
		</div>
	</div>

	<div id="main-wrapper" data-layout="vertical" data-navbarbg="skin5"
		data-sidebartype="full" data-sidebar-position="absolute"
		data-header-position="absolute" data-boxed-layout="full">
		<div class="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-sm-12">
						<div class="white-box">
							<c:if test="${access != null }">
								<div class="alert alert-success">Thực hiện thành công</div>
							</c:if>
							<h3 class="box-title text-uppercase text-center mb-3">Quản
								lí người dùng</h3>

							<div class="justify_bettwen">
								<a href="<%=request.getContextPath()%>/TrashUser"
									class="btn btn-danger text-white mt-2 mb-2"
									style="text-align: end; margin-right: 20px;">Thùng rác</a>
							</div>

							<div class="table-responsive">
								<table class="table text-nowrap" id="myTable">
									<thead>
										<tr>
											<th class="border-top-0">Mã</th>
											<th class="border-top-0">Avatar</th>
											<th class="border-top-0">Họ và tên</th>
											<th class="border-top-0">Số điện thoại</th>
											<th class="border-top-0">Tài khoản</th>
											<th class="border-top-0">Vai trò</th>
											<th class="border-top-0">Chức năng</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="eUser" items="${listUser}">
											<tr>
												<td>${eUser.id}</td>
												<td><img src="Image/AnhThu.png" alt="Avatar" style="width: 50px; height: 50px;"></td>
												<td>${eUser.fullName }</td>
												<td>${eUser.numberPhone }</td>
												<td>${eUser.userName }</td>
												<td>${eUser.rolId == 1 ? "Admin":"User" }</td>
												<td><a
													href="<%=request.getContextPath()%>/manager_user?action=edit&eUserId=${eUser.id}"
													class="btn btn-primary" title="Sửa"> <i
														class="ti-pencil-alt"></i></a> <a
													href="<%=request.getContextPath()%>/manager_user?action=detail&eUserId=${eUser.id }"
													class="btn btn-info text-white" title="Xem"> <i
														class="ti-eye"></i></a>
														
													<button onclick="changeStatus(this,${eUser.id})"
														class="btn btn btn-danger text-white" title="Khoá">
														<i class="ti-lock"></i>
													</button></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div>
		<div id="toast_message"></div>
	</div>
	<jsp:include page="adminFooter.html"></jsp:include>

	<script src="./admin/js/jquery.min.js"></script>
	<script src="./admin/js/bootstrap.bundle.min.js"></script>
	<script src="./admin/js/app-style-switcher.js"></script>
	<script src="./admin/js/waves.js"></script>
	<script src="./admin/js/sidebarmenu.js"></script>
	<script src="./admin/js/custom.js"></script>
	<script src="./admin/js/jquery.dataTables.min.js"></script>

	<script src="./js/styles.js"></script>

</body>

</html>
