<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<div class="fables-page-content">

    <div class="container overflow-hidden">
        <h2 class="text-center fables-main-text-color font-35 my-4 my-lg-5 smaller-head-text">
            CÁC HÃNG GIÀY NỔI BẬT
        </h2>
        <div class="row">
            <div class="col-12 col-sm-4 mb-4 wow fadeInUpBig brand" data-wow-duration="2s">
                <div class="image-container translate-effect-right">
                    <a href="#"><img src="<c:url value='image/logo/adidas.jpg'/>" alt="" class="img-fluid w-100"></a>
                </div>
            </div>
            <div class="col-12 col-sm-4 mb-4 wow fadeInUpBig brand" data-wow-duration="2s">
                <div class="image-container translate-effect-right">
                    <a href="#"><img src="<c:url value='image/logo/ananas.jpg'/>" alt="" class="img-fluid w-100"></a>
                </div>
            </div>
            <div class="col-12 col-sm-4 mb-4 wow fadeInUpBig brand" data-wow-duration="2s">
                <div class="image-container translate-effect-right">
                    <a href="#"><img src="<c:url value='image/logo/btits.jpg'/>" alt="" class="img-fluid w-100"></a>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <h2 class="fables-main-text-color font-35 font-weight-bold text-center mt-4 mt-lg-5">Sản phẩm <span
                class="fables-second-text-color">mới</span></h2>
        <p class="fables-forth-text-color text-center mb-4 mb-lg-5">Sản phẩm mới đến từ các thương hiệu nổi tiếng
        </p>
        <div class="row mb-0 mb-lg-5 overflow-hidden">
            <%--@elvariable id="product" type="java.util.List"--%>
            <c:forEach var="item" items="${product}">
                <div class="col-12 col-sm-6 col-lg-3 text-center mb-4 mb-lg-0 wow bounceInUp" data-wow-delay=".6s">
                    <div class="table-block table-border-light py-3 py-lg-3 fables-second-hover-border">
                        <div>
                            <img style="padding: 10px; height: 200px; width: 100%; object-fit: cover;"
                                 src="<c:url value='/image/${item.img1}' />" alt="">
                        </div>
                        <h2 class="fables-forth-text-color text-center bold-font table-title font-17 fables-third-after position-relative">
                                ${item.price}
                        </h2>
                        <p class="fables-forth-text-color my-4 px-4 line-height-large font-15"
                           style="height: 60px; overflow: hidden;">
                                ${item.productName}
                        </p>
                        <p class="fables-product-info">
                            <c:url var="detail" value="/product">
                                <c:param name="id" value="${item.productID}" />
                            </c:url>

                            <a href="${detail}" class="btn fables-second-border-color fables-second-text-color fables-btn-rouned fables-hover-btn-color font-14 p-2 px-2 px-xl-4">

                            <span class="fables-iconcart"></span>
                            <span class="fables-btn-value">ĐẶT MUA</span></a></p>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="container my-4 my-lg-5">
        <div class="row">
            <div class="col-12 col-md-8 offset-md-2">
                <div class="text-center">
                    <h2 class="fables-main-text-color font-35 font-weight-bold mt-0 mb-4 ">
                        Các sản phẩm của chúng tôi
                    </h2>
                </div>
            </div>
        </div>
        <div class="row">
            <c:forEach items="${products}" var="p">
                <div class="col-12 col-sm-6 col-lg-3 text-center mb-4 mb-lg-0 wow bounceInUp" style="margin-top: 16px;"
                     data-wow-delay=".6s">
                    <div class="table-block table-border-light py-3 py-lg-3 fables-second-hover-border">
                        <div>
                            <img style="padding: 10px; height: 200px; width: 100%; object-fit: cover;"
                                 src="<c:url value='/image/${p.img1}' />" alt="">
                        </div>
                        <h2 class="fables-forth-text-color text-center bold-font table-title font-17 fables-third-after position-relative">
                                ${p.price}
                        </h2>
                        <p class="fables-forth-text-color my-4 px-4 line-height-large font-15"
                           style="height: 60px; overflow: hidden;">${p.describeDetail}
                        </p>
                        <p class="fables-product-info">
                            <a href="#"
                               class="btn fables-second-border-color fables-second-text-color fables-btn-rouned fables-hover-btn-color font-14 p-2 px-2 px-xl-4">
                                <span class="fables-iconcart"></span>
                                <span class="fables-btn-value">ĐẶT MUA</span></a></p>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <h2 class="font-35 font-weight-bold fables-main-text-color my-3 my-lg-5 my-md-4 text-center">
                    Các bài viết nổi bật</h2>
            </div>
            <c:forEach items="${posts}" var="p">
                <div class="col-12 col-md-4 mb-4 mb-lg-5 wow fadeIn" data-wow-delay=".3s">
                    <div class="position-relative">
                        <h2 class="font-18 center-text">
                            <a href="#" class="fables-main-text-color fables-second-hover-color">${p.postName}</a>
                        </h2>

                        <p class="fables-forth-text-color font-14 mb-2">
                                ${p.postContent}
                        </p>
                        <a href=""
                           class="btn fables-second-text-color fables-main-hover-color p-0 font-15 border-0">Read More
                            <i class="fas fa-long-arrow-alt-right"></i></a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="container-fluid overflow-hidden">
        <div class="row mt-0 mt-lg-5">
            <div class="col-12 col-md-6 p-0">
                <div style="background-image: url(assets/custom/images/overlay1.jpg);">
                    <div class="fables-second-color-transparent p-6">
                        <h2 class="white-color font-weight-bold mb-4 font-35 wow fadeInLeft">Về <br>Chúng tôi</h2>
                        <p class="fables-third-text-color wow fadeInLeft">
                            Một công ty chuyên bán giày thối chân chỉ có mấy thằng đỗ nghèo khỉ mới bị chúng tôi lùa
                            gà. Gày đảm bảo đi được 2 ngày bay mẹ đế. Uy tín luôn.
                        </p>
                        <a href="#"
                           class="btn border border-white white-color rounded-0 my-4 py-2 px-5  wow fadeInLeft bg-white-hover fables-second-hover-color">Xem
                            thêm</a>
                    </div>
                </div>

            </div>
            <div class="col-12 col-md-6 px-6">
                <div class="row">
                    <div class="col-12 col-sm-6 my-4 text-center text-md-left wow fadeInRight">
                        <span class="fables-iconbussiness fables-second-text-color fa-3x"></span>
                        <h2 class="fables-main-text-color font-18 my-2">Chính sách hấp dẫn</h2>
                        <p class="fables-forth-text-color font-weight-light">
                            chính sách đổi trả nhanh chóng, giao hàng tận nơi, an toàn.
                        </p>
                    </div>
                    <div class="col-12 col-sm-6 my-4 text-center text-md-left wow fadeInRight">
                        <span class="fables-iconbussiness2 fables-second-text-color fa-3x"></span>
                        <h2 class="fables-main-text-color font-18 my-2">Giao hàng miền phí</h2>
                        <p class="fables-forth-text-color font-weight-light">
                            Áp dụng với tất cả đơn hàng có địa chỉ dưới 40KM.
                        </p>
                    </div>
                    <div class="col-12 col-sm-6 my-4 text-center text-md-left wow fadeInRight">
                        <span class="fables-iconbussiness3 fables-second-text-color fa-3x"></span>
                        <h2 class="fables-main-text-color font-18 my-2">Giá cả cạnh tranh</h2>
                        <p class="fables-forth-text-color font-weight-light">
                            Giá luôn tốt nhất.
                        </p>
                    </div>
                    <div class="col-12 col-sm-6 my-4 text-center text-md-left wow fadeInRight">
                        <span class="fables-iconbussiness4 fables-second-text-color fa-3x"></span>
                        <h2 class="fables-main-text-color font-18 my-2">Sản phẩm đẹp</h2>
                        <p class="fables-forth-text-color font-weight-light">
                            Các mẫu được tuyển chọn hàng đầu từ các hãng
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="fables-testimonial fables-after-overlay bg-rules py-4 py-lg-5">
        <div class="container">
            <div class="row">
                <div class="col-12 col-md-8">
                    <h3 class="position-relative z-index white-color mb-3 font-25 font-weight-bold">Liên hệ chúng
                        tôi</h3>
                    <p class="position-relative z-index font-weight-light fables-third-text-color">Nếu có bất kỳ
                        thắc mặc hoặc liên hệ hợp tác.</p>

                </div>

            </div>

        </div>
    </div>

</div>