<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html dir="ltr" lang="en">

<head>
    <meta charset="utf-8">

    <title>Detail User</title>

    <link rel="icon" type="image/png" sizes="16x16"
          href="./Image/favicon.png">
    <!-- Custom CSS -->
    <link href="./css/style.min.css" rel="stylesheet">
    <link href="./css/bootstrap.min.css"
          rel="stylesheet">
    <link href="./css/jquery.dataTables.min.css"
          rel="stylesheet">

    <link rel="stylesheet" type="text/css"
          href="../themify-icons/themify-icons.css">

</head>

<body>
<jsp:include page="adminHeader.jsp"></jsp:include>
<!-- ============================================================== -->
<fmt:setLocale value="${sessionScope.langName}" />
<fmt:setBundle basename="i18n.lang" var="lang" />	<!-- ============================================================== -->
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
        <c:url value="/" var="contextPath"/>
        <!-- Container fluid  -->
        <!-- ============================================================== -->
        <div class="container-fluid">
            <!-- ============================================================== -->
            <!-- Start Page Content -->
            <!-- ============================================================== -->
            <!-- Row -->
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-body">
                            <form class="form-horizontal form-material">
                                <div class="form-group mb-4">
                                    <div class="col-sm-12" align="right">
                                        <a class="btn btn-primary" href ="${contextPath}/manager_log">Trở về</a>
                                    </div>
                                </div>
                                <h3 class="box-title text-uppercase text-center mb-3">
                                    Chi tiết Log #${log.id }
                                </h3>

                                <div class="form-group mb-4">
                                    <label class="col-md-12 p-0"><b>ID</b></label>
                                    <div class="col-md-12 border-bottom p-0">
                                        <input type="text" placeholder="Johnathan Doe"
                                               class="form-control p-0 border-0" value ="${log.id }" name ="fullName" readonly> </div>
                                </div>
                                <div class="form-group mb-4">
                                    <label for="example-email" class="col-md-12 p-0"><b>Tài khoản</b></label>
                                    <div class="col-md-12 border-bottom p-0">
                                        <input
                                                class="form-control p-0 border-0" name="eUserName" value ="${log.userName}" readonly>
                                    </div>
                                </div>

                                <div class="form-group mb-4">
                                    <label class="col-md-12 p-0"><b>Cấp độ</b></label>
                                    <div class="col-md-12 border-bottom p-0">
                                        <c:if test="${log.level == 0 }"><span class="badge badge-info">Info</span></c:if>
                                        <c:if test="${log.level == 1 }"><span class="badge badge-primary">ALERT</span></c:if>
                                        <c:if test="${log.level == 2 }"><span class="badge badge-warning">Warning</span></c:if>
                                        <c:if test="${log.level == 3}"><span class="badge badge-danger">Danger</span></c:if>
                                    </div>
                                </div>
                                <div class="form-group mb-4">
                                    <label class="col-md-12 p-0"><b>Nơi xảy ra</b></label>
                                    <div class="col-md-12 border-bottom p-0">
                                        <input type="email" value="${log.src}" class="form-control p-0 border-0" readonly>
                                    </div>
                                </div>
                                <div class="form-group mb-4">
                                    <label class="col-md-12 p-0"><b>Thông tin</b></label>
                                    <div class="col-md-12 border-bottom p-0">
                                        <textarea rows="5" class="form-control p-0 border-0" readonly>${log.content}</textarea>
                                    </div>
                                </div>

                                <div class="form-group mb-4">
                                    <label class="col-md-12 p-0"><b>Thời gian</b></label>
                                    <div class="col-md-12 border-bottom p-0">
                                        <input  class="form-control p-0 border-0" readonly value = "${log.converDate()}" >
                                    </div>
                                </div>


                            </form>
                        </div>
                    </div>
                </div>
                <!-- Column -->
            </div>
            <!-- Row -->
        </div>
    </div>

</div>
<jsp:include page="adminFooter.html"></jsp:include>

<script src="./admin/js/jquery.min.js"></script>
<!-- Bootstrap tether Core JavaScript -->
<script src="./admin/js/bootstrap.bundle.min.js"></script>
<script src="./admin/js/app-style-switcher.js"></script>
<!--Wave Effects -->
<script src="./admin/js/waves.js"></script>
<!--Menu sidebar -->
<script src="./admin/js/sidebarmenu.js"></script>
<!--Custom JavaScript -->
<script src="./admin/js/custom.js"></script>
<script src="./admin/js/jquery.dataTables.min.js"></script>
</body>

</html>