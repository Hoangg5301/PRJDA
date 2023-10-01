<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="dec" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

    <link href="<c:url value='template/fontawesome-free-6.4.2/css/all.min.css'/> "/>
    <title>Trang chủ</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="<c:url value='template/admin/assets/css/nucleo-icons.css'/>" rel="stylesheet" type="text/css"/>
    <!-- animate.css-->
    <link href="<c:url value='template/user/assets/vendor/animate.css-master/animate.min.css '/>" rel="stylesheet"/>
    <!-- Load Screen -->
    <link href="<c:url value='template/user/assets/vendor/loadscreen/css/spinkit.css' />" rel="stylesheet">
    <!-- GOOGLE FONT -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i"
          rel="stylesheet">
    <!-- Font Awesome 5 -->
    <link href="<c:url value='template/user/assets/assets/vendor/fontawesome/css/fontawesome-all.min.css'/>"
          rel="stylesheet">
    <!-- Fables Icons -->
    <link href="<c:url value='template/user/assets/custom/css/fables-icons.css '/>" rel="stylesheet"/>
    <!-- Bootstrap CSS -->
    <link href="<c:url value='template/user/assets/vendor/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet"/>
    <link href="<c:url value='template/user/assets/vendor/bootstrap/css/bootstrap-4-navbar.css'/>" rel="stylesheet"/>
    <!-- portfolio filter gallery -->
    <link href="<c:url value='template/user/assets/vendor/portfolio-filter-gallery/portfolio-filter-gallery.css'/>"
          rel="stylesheet"/>
    <!-- Video Background -->
    <link href="<c:url value='template/user/assets/vendor/video-background/video-background.css'/>" rel="stylesheet"/>
    <!-- FANCY BOX -->
    <link href="<c:url value='template/user/assets/vendor/fancybox-master/jquery.fancybox.min.css'/>" rel="stylesheet"/>
    <!-- RANGE SLIDER -->
    <link href="<c:url value='template/user/assets/vendor/range-slider/range-slider.css'/>" rel="stylesheet"/>
    <!-- OWL CAROUSEL  -->
    <link href="<c:url value='template/user/assets/vendor/owlcarousel/owl.carousel.min.css'/>" rel="stylesheet"/>
    <link href="<c:url value='template/user/assets/vendor/owlcarousel/owl.theme.default.min.css'/>" rel="stylesheet"/>
    <!-- FABLES CUSTOM CSS FILE -->
    <link href="<c:url value='template/user/assets/custom/css/custom.css'/>" rel="stylesheet"/>
    <!-- FABLES CUSTOM CSS RESPONSIVE FILE -->
    <link href="<c:url value='template/user/assets/custom/css/custom-responsive.css'/>" rel="stylesheet"/>
    <style>
        .center-text {
            text-align: center;
            padding-bottom: 20px;
        }
    </style>

</head>
<body>
<%@ include file="/common/user/header.jsp" %>
<dec:body/>
<%@ include file="/common/user/footer.jsp" %>
<script src="<c:url value='template/user/assets/vendor/jquery/jquery-3.3.1.min.js'/>"></script>
<script src="<c:url value='template/user/assets/vendor/timeline/jquery.timelify.js'/>"></script>
<script src="<c:url value='template/user/assets/vendor/jquery-circle-progress/circle-progress.min.js'/>"></script>
<script src="<c:url value='template/user/assets/vendor/loadscreen/js/ju-loading-screen.js'/>"></script>
<script src="<c:url value='template/user/assets/vendor/popper/popper.min.js'/>"></script>
<script src="<c:url value='template/user/assets/vendor/bootstrap/js/bootstrap.min.js'/>"></script>
<script src="<c:url value='template/user/assets/vendor/bootstrap/js/bootstrap-4-navbar.js'/>"></script>
<script src="<c:url value='template/user/assets/vendor/WOW-master/dist/wow.min.js'/>"></script>
<script src="<c:url value='template/user/assets/vendor/owlcarousel/owl.carousel.min.js'/>"></script>
<script src="<c:url value='template/user/assets/vendor/loadscreen/js/ju-loading-screen.js'/>"></script>
<script src="<c:url value='template/user/assets/vendor/fancybox-master/jquery.fancybox.min.js'/>"></script>
<script src="<c:url value='template/user/assets/custom/js/custom.js'/>"></script>


</body>
</html>