
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>

<%--<link rel="stylesheet" href="<c:url value='template/bootstrap-5.0.2-dist/css/bootstrap.css' /> "/>--%>
<section style="margin: 20px 0px 20px 0px" class="vh-100 bg-image"
         style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">
    <div class="mask d-flex align-items-center gradient-custom-3">
        <div class="container h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                    <div class="card" style="border-radius: 15px;">
                        <c:if test="${not empty message }">
                            <div class="alert alert-${alert}">
                                "${message}"
                            </div>
                        </c:if>
                        <div class="card-body p-5">
                            <h2 class="text-uppercase text-center mb-5">Tạo một tài khoản</h2>

                            <form id="form_register" method="POST">

                                <div class="form-outline mb-4">
                                    <label class="form-label" for="form3Example1cg">Tên đăng nhập</label>
                                    <input name="userName" type="text" id="form3Example1cg" class="form-control form-control-lg" />
                                </div>

                                <div class="form-outline mb-4">
                                    <label class="form-label" for="form3Example3cg">Email</label>
                                    <input name="email" type="email" id="form3Example3cg" class="form-control form-control-lg" />
                                </div>
                                <div class="form-outline mb-4">
                                    <label class="form-label" for="form3Example3cg">Số điện thoại</label>
                                    <input name="phoneNumber" type="text" id="form3Example3cg" class="form-control form-control-lg" />
                                </div>
                                <div class="form-outline mb-4">
                                    <label class="form-label" for="form3Example3cg">Địa chỉ</label>
                                    <input name="address" type="text" id="form3Example3cg" class="form-control form-control-lg" />
                                </div>
                                <%--input status và role mạc định--%>
                                <input type="hidden" name="status" id="form3Example3cg" class="form-control form-control-lg" value="1"/>
                                <input type="hidden" name="role" id="form3Example3cg" class="form-control form-control-lg" value="1"/>
                                <%--input status và role mạc định--%>
                                <div class="form-outline mb-4">
                                    <label class="form-label" for="form3Example4cg">Mật khẩu</label>
                                    <input name="password" type="password" id="form3Example4cg" class="form-control form-control-lg" />
                                </div>
                                <div class="d-flex justify-content-center">
                                    <button id="submit_register" type="button" class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Đăng ký</button>
                                </div>

                                <p class="text-center text-muted mt-5 mb-0">Bạn đã có tài khoản? <a href="<c:url value="/login" />" class="fw-bold text-body"><u>Login here</u></a></p>

                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<script>
    $("#submit_register").click(function(e) {
        e.preventDefault();
        var data ={};
        var formData = $('#form_register').serializeArray();

        // truyền form data vào object data.
        $.each(formData, function(i, v){
            data[""+v.name+""] = v.value;
        });
        register(data);
    });

    function register(data){
        $.ajax({
            url: '<c:url value="/api/account" />',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                window.location.href = '<c:url value="/register" />?message=register_success';
            },
            error: function (error) {
                window.location.href = '<c:url value="/register" />?message=register_error';
            }
        });
    }

</script>

<%--<script src="<c:url value='template/bootstrap-5.0.2-dist/js/bootstrap.js' />" />--%>

