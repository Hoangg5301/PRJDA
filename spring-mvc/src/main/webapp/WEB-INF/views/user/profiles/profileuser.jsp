
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link href="<c:url value='template/bootstrap-5.0.2-dist/css/bootstrap.css'/>" rel="stylesheet"/>

<section class="layout-info-account">
    <div class="container">
        <div class="row">
            <div class="col-xs-12">
                <h1>
                    Tài khoản của bạn <a class="logout" href="/user/signout"><span
                        class="fa fa-sign-out"></span>Thoát</a></h1>
            </div>
            <div id="customer_orders" class="col-md-8 col-xs-12">
                <div class="userbox">
                    <table class="tableOrder table table-bordered">
                        <thead>
                        <tr>
                            <th>Mã đơn hàng</th>
                            <th>Ngày đặt</th>
                            <th>Trạng thái thanh toán</th>
                            <th class="text-center">Hình thức thanh toán</th>
                            <th class="text-center">Số điểm tích được</th>
                            <th class="text-center">Tổng tiền</th>
                        </tr>
                        </thead>
                        <tbody></tbody>
                    </table>
                </div>
            </div>
            <div id="customer_sidebar" class="col-md-4 col-xs-12">
                <div class="userbox detail">
                    <p><span>Họ tên : </span></p>
                    <p class="email"><span>Email : </span> khongchinhchu02@gmail.com</p>
                    <p><span>Điện thoại : </span></p>
                    <p><span>Giới tính : </span> Nam</p>
                    <p><span>Ngày sinh : </span> 01/01/1970</p>
                    <div class="address ">
                        <p><span>Thành phố : </span></p>
                        <p><span>Quận : </span></p>
                        <p><span>Địa chỉ : </span></p>
                    </div>
                    <div class="text-right">
                        <a id="view_address" href="/profile">Cập nhật tài khoản <i class="fa fa-share"></i></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<script src="<c:url value="template/bootstrap-5.0.2-dist/js/bootstrap.js" />"></script>
