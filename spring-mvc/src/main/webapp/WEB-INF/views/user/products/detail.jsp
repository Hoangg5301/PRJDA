<%@ include file="/common/taglib.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="Fables">
<meta name="author" content="Enterprise Development">
<link rel="shortcut icon" href="assets/custom/images/shortcut.png">

<title>CHI TIẾT SẢN PHẨM</title>

<!-- animate.css-->
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i"
      rel="stylesheet">
<link href="<c:url value='template/user/assets/vendor/animate.css-master/animate.min.css'/>" rel="stylesheet">
<link href="<c:url value='template/user/assets/vendor/loadscreen/css/spinkit.css'/>" rel="stylesheet">
<link href="<c:url value='template/user/assets/vendor/fontawesome/css/fontawesome-all.min.css'/>" rel="stylesheet">
<link href="<c:url value='template/user/assets/custom/css/fables-icons.css'/>" rel="stylesheet">
<link href="<c:url value='template/user/assets/vendor/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">
<link href="<c:url value='template/user/assets/vendor/bootstrap/css/bootstrap-4-navbar.css'/>" rel="stylesheet">
<link href="<c:url value='template/user/assets/vendor/video-background/video-background.css'/>" rel="stylesheet">
<link href="<c:url value='template/user/assets/vendor/fancybox-master/jquery.fancybox.min.css'/>" rel="stylesheet">
<link href="<c:url value='template/user/assets/vendor/range-slider/range-slider.css'/>" rel="stylesheet">
<link href="<c:url value='template/user/assets/vendor/owlcarousel/owl.carousel.min.css'/>" rel="stylesheet">
<link href="<c:url value='template/user/assets/vendor/owlcarousel/owl.theme.default.min.css'/>" rel="stylesheet">
<link href="<c:url value='template/user/assets/custom/css/custom.css'/>" rel="stylesheet">
<link href="<c:url value='template/user/assets/custom/css/custom-responsive.css'/>" rel="stylesheet">

<div class="fables-page-content">
    <div class="container">
        <div class="row my-4 my-md-5">
            <div class="col-12 col-lg-6">
                <div class="fables-single-slider store-single-slider">
                    <div id="sync1" class="owl-carousel owl-theme">
                        <div class="item">
                            <img src="<c:url value='/image/${product.img1}' />" alt="" class="w-100">
                        </div>
                        <div class="item">
                            <img src="<c:url value='/image/${product.img2}' />" alt="" class="w-100">
                        </div>
                        <div class="item">
                            <img src="<c:url value='/image/${product.img3}' />" alt="" class="w-100">
                        </div>
                        <div class="item">
                            <img src="<c:url value='/image/${product.img4}' />" alt="" class="w-100">
                        </div>
                    </div>
                    <div id="sync2" class="owl-carousel owl-theme">
                        <div class="item">
                            <img src="assets/custom/images/sp1.png" alt="" class="w-100">
                        </div>
                        <div class="item">
                            <img src="assets/custom/images/sp2.png" alt="" class="w-100">
                        </div>
                        <div class="item">
                            <img src="assets/custom/images/sp1.png" alt="" class="w-100">
                        </div>
                        <div class="item">
                            <img src="assets/custom/images/sp2.png" alt="" class="w-100">
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-12 col-lg-6 col-12 col-lg-6 mt-3 mt-lg-0">
                <h2 class="fables-main-text-color font-20 semi-font">${product.productName}</h2>
                <div class="row mb-5">
                    <div class="col-5 col-md-3">
                        <span class="fables-fifth-text-color"> Kích cỡ : </span>
                    </div>
                    <div class="col-7 col-sm-6">
                        <select class="form-select" aria-label="Default select example" id="sizeSelected">
                            <c:forEach var="productDetail" items="${productDetailDTOS}">
                                <option id="" value="${productDetail.productDetailID}">${productDetail.size}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="row mb-5">
                    <div class="col-12 col-sm-7 text-center text-md-left">
                        <span class="fables-fifth-text-color"><span class="fables-iconprice"></span> Price :</span>
                        <span class="fables-second-text-color font-20 font-weight-bold">${product.price} VNĐ</span>
                    </div>
                    <div class="col-9 col-md-4 col-lg-5 mt-3 mt-sm-0 mr-auto ml-auto mr-md-0 ml-md-auto">
                        <div class="fables-calc fables-light-background-color fables-btn-rouned">
                            <span class="calc-btn minus fables-forth-text-color float-left calc-width mt-2">-</span>
                            <span class="calc-width">
                                    <input type="text" id="input-val"
                                           class="form-control d-inline-block border text-center form-circle-input rounded-circle">
                                </span>
                            <span class="calc-btn plus fables-forth-text-color float-right calc-width mt-2">+</span>
                        </div>
                    </div>
                </div>
                <div class="row mb-5">
                    <div class="col-5 col-md-3">
                        <span class="fables-fifth-text-color"> Sản phẩm có săn : </span>
                    </div>
                    <div class="col-7 col-sm-6">
                        <p id="result"></p>
                    </div>
                </div>
                <div class="row mb-5">
                    <div class="col-6">
                        <c:url var="saveCart" value="/product?id=${product.productID}"/>
                        <button id="addTocart" type="button">

                            <span>THÊM VÀO GIỎ HÀNG</span>
                        </button>
                    </div>
                    <div class="col-6 text-right">
                        <a href=""
                           class="btn fables-product-btn text-white fables-forth-background-color rounded-circle fables-second-hover-background-color p-0"><span
                                class="fables-iconcompare"></span></a>
                        <button
                                class="btn text-white fables-product-btn fables-forth-background-color rounded-circle fables-second-hover-background-color p-0"><span
                                class="fables-iconheart"></span></button>
                    </div>
                </div>

                <div class="row">
                    <div class="col-6 col-sm-4 col-lg-5 col-xl-4 text-left">
                        <a href="#"
                           class="btn fables-forth-background-color fables-btn-rouned fables-second-hover-background-color white-color px-2 px-md-4 py-2 font-18">
                            <span class="fables-iconshare"></span>
                            <span class="fables-btn-value">Chia sẻ</span></a>
                    </div>
                    <div class="col-6 col-sm-8 col-lg-7 col-xl-8 text-center mt-0 mt-sm-0 pl-0">
                        <ul class="nav fables-single-social mt-2 justify-content-end justify-content-lg-start">
                            <li><a href="#" target="_blank"
                                   class="fables-forth-text-color fables-single-link fables-second-hover-color"><i
                                    class="fab fa-facebook-f fa-fw"></i></a></li>
                            <li><a href="#" target="_blank"
                                   class="fables-forth-text-color fables-single-link fables-second-hover-color"><i
                                    class="fab fa-twitter fa-fw"></i></a></li>
                            <li><a href="#" target="_blank"
                                   class="fables-forth-text-color fables-single-link fables-second-hover-color"><i
                                    class="fab fa-instagram fa-fw"></i></a></li>
                            <li><a href="#" target="_blank"
                                   class="fables-forth-text-color fables-single-link fables-second-hover-color"><i
                                    class="fab fa-linkedin fa-fw"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-12">
                <nav class="fables-single-nav">
                    <div class="nav nav-tabs" id="nav-tab" role="tablist">
                        <a class="fables-single-item nav-link fables-forth-text-color fables-second-active fables-second-hover-color fables-forth-after px-3 px-md-5 font-15 semi-font border-0 active rounded-0 py-3"
                           id="nav-desc-tab" data-toggle="tab" href="#nav-desc" role="tab" aria-controls="nav-desc"
                           aria-selected="true">MÔ TẢ</a>
                    </div>
                </nav>
                <div class="tab-content" id="nav-tabContent">
                    <div class="tab-pane fade show active" id="nav-desc" role="tabpanel"
                         aria-labelledby="nav-desc-tab">
                        <p class="fables-single-info mt-4 font-15 fables-fifth-text-color">
                            ${product.describeDetail}
                        </p>
                    </div>
                </div>
            </div>
        </div>
        <div class="row mb-0 mb-md-5">
            <div class="col-12">
                <h2
                        class="fables-forth-text-color fables-light-background-color my-3 my-md-5 py-3 text-center font-20 semi-font">
                    Sản phẩm liên quan</h2>
            </div>
            <c:forEach var="p" items="${productByBrand}">
                <div class="col-12 col-sm-6 col-lg-3 text-center mb-4 mb-lg-0 wow bounceInUp" style="margin-top: 16px;"
                     data-wow-delay=".6s">
                    <div class="table-block table-border-light py-3 py-lg-3 fables-second-hover-border">
                        <div>
                            <img style="padding: 10px; height: 200px; width: 100%; object-fit: cover;"
                                 src="<c:url value='/image/${p.img1}' />" alt="">

                        </div>
                        <h2
                                class="fables-forth-text-color text-center bold-font table-title font-17 fables-third-after position-relative">
                                ${p.price}</h2>
                        <p class="fables-forth-text-color my-4 px-4 line-height-large font-15"
                           style="height: 60px; overflow: hidden;">
                                ${p.productName}
                        </p>
                        <p class="fables-product-info"><a href="#"
                                                          class="btn fables-second-border-color fables-second-text-color fables-btn-rouned fables-hover-btn-color font-14 p-2 px-2 px-xl-4">
                            <span class="fables-iconcart"></span>
                            <span class="fables-btn-value">ĐẶT MUA</span></a></p>
                    </div>
                </div>
            </c:forEach>
        </div>
<c:url var='cartCreate'  value="/create-cart" />
    </div>
</div>

<script src="<c:url value='template/user/assets/vendor/jquery/jquery-3.3.1.min.js'/>"></script>

<script>


    function saveCart(cartDetail) {
        $.ajax({
            url: '${cartCreate}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(cartDetail),
            dataType: 'json',
            success: function () {
                window.location.href = '${saveCart}';
            },
            error: function () {
                window.location.href = '${saveCart}';
            }
        });
    }

    $("#addTocart").click(function (event){
        var productDetailId = $("#sizeSelected").val();
        var accountId = localStorage.getItem('accountId');
        var quantity = $('#input-val').val();

        const cartDetail =  {
            cartID:"",
            accountID: accountId,
            productID : productDetailId,
            quantity: quantity
        }

        saveCart(cartDetail)
    });
</script>