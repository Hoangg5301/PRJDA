<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- code jquery -->
<script>
	$("#click-dashboard").click(function(){
		$.ajax({
			type: "GET",
			url:"/home-category-admin",
			success: function(data){
				
			},
			error: function(error){},
		});
	});
</script>


    <!-- Custom fonts for this template -->
    <link href="<c:url value='template/admin/assets/vendor/fontawesome-free/css/all.min.css'/> " rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value='template/admin/assets/css/sb-admin-2.min.css'/>" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="<c:url value='template/admin/assets/vendor/datatables/dataTables.bootstrap4.min.css '/>"  rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
        integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
        crossorigin="anonymous" referrerpolicy="no-referrer">

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fa-solid fa-wind"></i>
                </div>
                <div class="sidebar-brand-text mx-3">BLUE <sup>WIND</sup></div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item">
                <a class="nav-link" href="<c:url value='/home' />">
                    <i class="fas fa-fw fa-chart-area"></i>
                    <span>Thống kê</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Quản lý
            </div>

            <!-- Nav Item - Pages Collapse Menu -->

            <li class="nav-item">
                <a class="nav-link collapsed" href="<c:url value='/home-producttype-admin'/> ">
                    <i class="fa-solid fa-palette"></i>
                    <span>Danh mục</span>
                </a>
            </li>

            <li class="nav-item">
                <a class="nav-link collapsed" href="<c:url value='/home-brand-admin'/>" >
                    <i class="fa-solid fa-wand-magic-sparkles"></i>
                    <span>Nhãn hiệu</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link collapsed" href="<c:url value='/home-product-admin'/>" >
                    <i class="fa-solid fa-boxes-stacked"></i>
                    <span>Sản phẩm</span>
                </a>
            </li>

            <li class="nav-item">
                <a class="nav-link collapsed" href="<c:url value='/home-post-admin'/>" >
                    <i class="fa-solid fa-pen"></i>
                    <span>Bài viết</span>
                </a>
            </li>



            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="<c:url value='/home-order-admin'/>" >
                    <i class="fa-solid fa-cart-shopping"></i>
                    <span>Đơn hàng</span>
                </a>
            </li>
            
             <li class="nav-item">
                <a class="nav-link collapsed" href="<c:url value='/home-promotion-admin'/>" >
                    <i class="fa-solid fa-pen"></i>
                    <span>khuyến mại</span>
                </a>
            </li>
            

            <!-- Divider -->
            <hr class="sidebar-divider">
            <li class="nav-item">
                <a class="nav-link collapsed" href="<c:url value='/home-account-admin'/>" >
                    <i class="fa-solid fa-user"></i>
                    <span>tài khoản</span>
                </a>
            </li>

        </ul>
        <!-- End of Sidebar -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->

    <!-- Bootstrap core JavaScript-->
    <script src="<c:url value='template/admin/assets/vendor/jquery/jquery.min.js'/> "></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="<c:url value='template/admin/assets/vendor/jquery-easing/jquery.easing.min.js'/> "></script>

    <!-- Custom scripts for all pages-->
    <script src="<c:url value='template/admin/assets/js/sb-admin-2.min.js' />"></script>

    <!-- Page level plugins -->
    <script src="<c:url value='template/admin/assets/vendor/datatables/jquery.dataTables.min.js '/> "></script>
    <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="<c:url value='template/admin/assets/js/demo/datatables-demo.js '/> "></script>

</body>