<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<link href="<c:url value='template/user/assets/cartcustom/css/bootstrap.min.css'/>" rel="stylesheet"/>
<link href="<c:url value='template/user/assets/cartcustom/css/all.min.css'/>" rel="stylesheet"/>
<link href="<c:url value='template/fontawesome-free-6.4.2/css/all.css'/>" rel="stylesheet"/>

<style>
    .amount {
        font-weight: bold;
        color: green; /* Màu số tiền */
    }
</style>
<script>
    // const amountElement = document.querySelector('.amount');
    // const amount = parseFloat(amountElement.innerText);
    // amountElement.innerText = amount.toLocaleString('en-US', { style: 'currency', currency: 'USD' });

    //Bắt event F5
    window.addEventListener('beforeunload', function (event) {

        // const confirmationMessage = 'Bạn có chắc muốn làm mới trang này?';
        // event.returnValue = confirmationMessage; // Cho phép hiển thị thông báo xác nhận (đối với một số trình duyệt)
        refresh();

    });

    //Sử dụng Ajax gửi request
    const accountId = localStorage.getItem('accountId');
    const myHeaders = new Headers();

    // Gửi giá trị lên server (controller) bằng Ajax request
    function refresh() {
        $.ajax({
            type: 'GET',
            url: '/cart',
            header: myHeaders,
            success: function (response) {
                console.log('Server response:', response);
            }
        });
    }

</script>

<section class="pt-5 pb-5">
    <div class="container">
        <div class="row w-100">
            <div class="col-lg-12 col-md-12 col-12">
                <h3 class="display-5 mb-2 text-center">Giỏ hàng</h3>
                <p class="mb-5 text-center">
                    <i class="text-info font-weight-bold">3</i> items in your cart</p>
                <table id="shoppingCart" class="table table-condensed table-responsive">
                    <thead>
                    <tr>
                        <th style="width:60%">Sản phẩm</th>
                        <th style="width:12%">giá</th>
                        <th style="width:10%">Số lượng</th>
                        <th style="width:16%"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${cartProductDetails}" var="cart" varStatus="loop">
                        <input type="hidden" id="idElement_${loop.index}" value="${cart.cartId}"/>
                        <tr id="${cart.cartId}">
                            <td data-th="Product">
                                <div class="row">
                                    <div class="col-md-3 text-left">
                                        <img src="<c:url value='/image/${cart.image}' />" alt=""
                                             class="img-fluid d-none d-md-block rounded mb-2 shadow ">
                                    </div>
                                    <div class="col-md-9 text-left mt-sm-2">
                                        <h4>${cart.name}</h4>
                                        <p class="font-weight-light">Phân loại: ${cart.size}</p>
                                    </div>
                                </div>
                            </td>
                            <td data-th="Price" id="product-price" class="amount">${cart.price}</td>
                            <td data-th="Quantity">
                                <input type="number" class="form-control form-control-lg text-center"
                                       value="${cart.quantity}">
                            </td>
                            <td class="actions" data-th="">
                                <div class="text-right">
                                    <button class="btn btn-white border-secondary bg-white btn-md mb-2"
                                            onclick="deleteById($('#idElement_${loop.index}').val())">
                                        <c:url var="cartDelete" value="/cart"/>
                                        <i class="fas fa-trash"></i>
                                    </button>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="float-right text-right">

                    <h1></h1>
                </div>
            </div>
        </div>
        <div class="row mt-4 d-flex align-items-center">
            <div class="col-sm-6 order-md-2 text-right">
                <form action="/spring_mvc_war_exploded/viewcheckout" method="post">
                    <input type="hidden" class="accountId_submit" id="accountId" name="accountId" />
                    <button class="btn btn-primary mb-4 btn-lg pl-5 pr-5"
                       type="submit">Checkout</button>
                </form>
            </div>
            <div class="col-sm-6 mb-3 mb-m-1 order-md-1 text-md-left">
                <a href="<c:url value='/trang-chu' />">
                    <i class="fas fa-arrow-left mr-2"></i> Tiếp tục mua hàng</a>
            </div>
        </div>
    </div>

    <script src="<c:url value='template/user/assets/cartcustom/js/bootstrap.min.js'/>"></script>
    <script src="<c:url value='template/user/assets/cartcustom/js/jquery-3.3.1.slim.min.js'/>"></script>
    <script src="<c:url value='template/user/assets/cartcustom/js/popper.min.js'/>"></script>

    <script>

        const accountIdCheckout = localStorage.getItem('accountId');
        $(".accountId_submit").val(accountIdCheckout);
        function deleteById(id) {
            $.ajax({
                url: '${cartDelete}',
                type: 'DELETE',
                contentType: 'application/json',
                data: JSON.stringify(id),
                success: function () {
                    window.location.href = '${cartDelete}';
                },
                error: function () {
                    window.location.href = '${cartDelete}';
                }
            })

        }
    </script>
</section>