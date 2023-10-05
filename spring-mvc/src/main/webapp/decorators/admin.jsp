<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="dec"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Nucleo Icons -->
<link href="<c:url value='template/admin/assets/css/hcustom.css'/> "
	rel="stylesheet">
	
	<link href="<c:url value='template/fontawesome-free-6.4.2/css/all.min.css'/> "
	rel="stylesheet">
	
	<link href="<c:url value='template/admin/custom/tableadmin.css'/> "
	rel="stylesheet">

	<link href="<c:url value='template/AlertComfirm/sweetalert2.min.css'/> "
	rel="stylesheet">
	
	<script src="<c:url value='template/AlertComfirm/sweetalert2.min.js'/>"></script>

	<link href="<c:url value='template/admin/custom/addIitem.css'/> "
		  rel="stylesheet">
</head>
<body class="content-admin-deco">
	<div class="left-content-admin">
		<div class="menu-admin">
			<%@ include file="/common/admin/menu.jsp"%>
		</div>
	</div>
	
	<div class="right-content-admin">
		<div class="header-admin">
			<%@ include file="/common/admin/header.jsp"%>
		</div>
		<div class="body-admin">
			<dec:body />
		</div>
		<div class="footer-admin">
			<%@ include file="/common/admin/footer.jsp"%>
		</div>
	</div>


</body>
</html>