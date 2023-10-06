<%@ include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="javax.servlet.RequestDispatcher" %>
<%@ page import="java.io.IOException" %>

<link href="<c:url value='template/user/custom/css/customuser.css'/>" rel="stylesheet" type="text/css"/>
<div class="search-section">
    <a class="close-search" href="#"></a>
    <div class="d-flex justify-content-center align-items-center h-100">
        <form method="post" action="#" class="w-50">
            <div class="row">
                <div class="col-10">
                    <input type="search" value="" class="form-control palce bg-transparent border-0 search-input"
                           placeholder="Search Here ..."/>
                </div>
                <div class="col-2 mt-3">
                    <button type="submit" class="btn bg-transparent text-white"><i class="fas fa-search"></i>
                    </button>
                </div>
            </div>
        </form>
    </div>

</div>

<!-- Loading Screen -->
<div id="ju-loading-screen">
    <div class="sk-double-bounce">
        <div class="sk-child sk-double-bounce1"></div>
        <div class="sk-child sk-double-bounce2"></div>
    </div>
</div>


<!-- Start Top Header -->
<div class="fables-forth-background-color fables-top-header-signin">
    <div class="container">
        <div class="row" id="top-row">
            <div class="col-12 col-sm-6 col-lg-6">
                <p class="fables-third-text-color font-13"><span class="fables-iconphone"></span> Phone :
                    (888) 6000 6000 - (888) 6000 6000</p>
            </div>
            <div class="col-12 col-sm-6 col-lg-6 text-right" style="display: flex; justify-content: end;">
                <p class="fables-third-text-color font-13"><span class="fables-iconemail"></span> Email:
                    Hoangnguyen5301@gmail.com</p>
            </div>

        </div>
    </div>
</div>


<!-- /End Top Header -->

<!-- Start Fables Navigation -->
<div class="fables-navigation fables-main-background-color py-3 py-lg-0">
    <div class="container">
        <div class="row">
            <div class="col-12 col-md-10 col-lg-9 pr-md-0">
                <nav class="navbar navbar-expand-md btco-hover-menu py-lg-2">

                    <a class="navbar-brand pl-0" href="<c:url value='/trang-chu'/>"><h2 style="color: #d7e3f5">
                        BlueWind</h2></a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#fablesNavDropdown" aria-controls="fablesNavDropdown" aria-expanded="false"
                            aria-label="Toggle navigation">
                        <span class="fables-iconmenu-icon text-white font-16"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="fablesNavDropdown">

                        <ul class="navbar-nav mx-auto fables-nav">
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value='/trang-chu'/>" id="sub-nav1">
                                    Trang chủ
                                </a>
                            </li>

                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="sub-nav2" data-toggle="dropdown"
                                   aria-haspopup="true" aria-expanded="false">
                                    Danh mục
                                </a>
                                <ul class="dropdown-menu" aria-labelledby="sub-nav2">

                                    <li><a class="dropdown-item dropdown-toggle" href="#">Nam</a>
                                        <ul class="dropdown-menu">
                                            <li><a class="dropdown-item" href="#">Type 1</a>
                                            </li>
                                            <li><a class="dropdown-item" href="#">Type 2</a>
                                            </li>
                                            <li><a class="dropdown-item" href="#">Type 3</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a class="dropdown-item dropdown-toggle" href="#">Nữ</a>
                                        <ul class="dropdown-menu">
                                            <li><a class="dropdown-item" href="#">Type 1</a>
                                            </li>
                                            <li><a class="dropdown-item" href="#">Type 2</a>
                                            </li>
                                            <li><a class="dropdown-item" href="#">Type 3</a>
                                            </li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link" href="#" id="sub-nav3" data-toggle="dropdown"
                                   aria-haspopup="true" aria-expanded="false">
                                    Tất cả sản phẩm
                                </a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link" href="#" id="sub-nav5" data-toggle="dropdown"
                                   aria-haspopup="true" aria-expanded="false">
                                    Bài viết
                                </a>
                            </li>
                            <li class="nav-item dropdown">
                                <a class="nav-link" href="#" id="sub-nav4" data-toggle="dropdown"
                                   aria-haspopup="true" aria-expanded="false">
                                    Giới thiệu
                                </a>
                            </li>

                        </ul>

                    </div>
                </nav>
            </div>
            <div class="col-12 col-md-2 col-lg-3 pr-md-0 icons-header-mobile icon-margin">
                <div class="fables-header-icons">
                    <form action="/spring_mvc_war_exploded/cart" method="post">
                        <input type="hidden" id="accountId" name="accountId" />
                        <button style="background-color:transparent; border: none;  outline: none;cursor: pointer; " type="submit"
                           class="fables-third-text-color  right px-3 px-md-2 px-lg-4 fables-second-hover-color top-header-link max-line-height position-relative"
                           aria-haspopup="true"
                           aria-expanded="false">
                            <span class="fables-iconcart-icon font-16"></span>
                            <span class="fables-cart-number fables-second-background-color text-center">3</span>
                        </button>
                    </form>
                    <a href="#"
                       class="open-search fables-third-text-color right  top-header-link px-3 px-md-2 px-lg-4 fables-second-hover-color border-0 max-line-height">
                        <span class="fables-iconsearch-icon"></span>
                    </a>
                    <a href="signin.html"
                       class="fables-third-text-color fables-second-hover-color font-13 top-header-link px-3 px-md-2 px-lg-4 max-line-height"><span
                            class="fables-iconuser"></span></a>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    const accountId = localStorage.getItem('accountId');
    $("#accountId").val(accountId);
    // document.getElementById("accountId"). = accountId;
</script>