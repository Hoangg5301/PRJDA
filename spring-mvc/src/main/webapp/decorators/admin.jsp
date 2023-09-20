<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <!-- Nucleo Icons -->
    <link href="<c:url value='template/admin/assets/css/nucleo-icons.css'/>" rel="stylesheet" type="text/css"/>
    <link href="<c:url value='template/admin/assets/css/nucleo-svg.css'/>" rel="stylesheet" type="text/css"/>
    
    <!-- Font Awesome Icons -->
    <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
    <!-- Material Icons -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Round" rel="stylesheet">
    <!-- CSS Files -->
    <link id="pagestyle" href="<c:url value='template/admin/assets/css/material-dashboard.css?v=3.1.0'/>" rel="stylesheet" type="text/css"/>
    <!-- css custom -->
    <link href="<c:url value='template/admin/assets/customAdmin.css'/>" rel="stylesheet" type="text/css"/>
</head>
<body>

	<%@ include file="/common/admin/menu.jsp" %>
  <main class="main-content border-radius-lg ">
    <%@ include file="/common/admin/header.jsp" %>
    <dec:body/>
    <%@ include file="/common/admin/footer.jsp" %>
  </main>

</body>
</html>