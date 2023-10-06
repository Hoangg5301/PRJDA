
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/common/taglib.jsp" %>


<%--<link rel="stylesheet" href="<c:url value='template/bootstrap-5.0.2-dist/css/bootstrap.css' /> "/>--%>

<section class="vh-100" style="background-color: #508bfc;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <form id="form-login">
                <div class="card shadow-2-strong" style="border-radius: 1rem;">
                    <div class="card-body p-5 text-center">

                        <h3 class="mb-5">Sign in</h3>
                        <c:if test="${not empty message }">
                            <div class="alert alert-${alert}">
                                "${message}"
                            </div>
                        </c:if>
                        <div class="form-outline mb-4">
                            <input name="userName" type="text" id="typeEmailX-2" class="form-control form-control-lg" />
                            <label class="form-label" for="typeEmailX-2">User name</label>
                        </div>

                        <div class="form-outline mb-4">
                            <input name="password" type="password" id="typePasswordX-2" class="form-control form-control-lg" />
                            <label class="form-label" for="typePasswordX-2">Password</label>
                        </div>

                        <!-- Checkbox -->
                        <div class="form-check d-flex justify-content-start mb-4">
                            <input class="form-check-input" type="checkbox" value="" id="form1Example3" />
                            <label class="form-check-label" for="form1Example3"> Remember password </label>
                        </div>

                        <button id="submit_login" class="btn btn-primary btn-lg btn-block" type="submit">Login</button>
                        <hr class="my-4">
                    </div>
                </div>
                </form>
            </div>
        </div>
    </div>
</section>

<script>

    $("#submit_login").click(function(e) {
        e.preventDefault();
        var data ={};
        var formData = $('#form-login').serializeArray();

        // truyền form data vào object data.
        $.each(formData, function(i, v){
            data[""+v.name+""] = v.value;
        });
        login(data);
    });

    function login(data){
        $.ajax({
            url: '<c:url value="/api/login" />',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
                if(result.role === "1"){
                    window.location.href = '<c:url value="/trang-chu" />';
                    localStorage.setItem('userName', result.userName);
                    localStorage.setItem('password',result.password);
                    localStorage.setItem('role',result.role);
                    localStorage.setItem('email',result.email);
                    localStorage.setItem('phoneNumber', result.phoneNumber);
                    localStorage.setItem('address', result.address);
                    localStorage.setItem('accountId', result.accountID);
                    localStorage.setItem('status', result.status);
                    console.log(result);
                }else if(result.role === "0"){
                    localStorage.setItem('userName', result.userName);
                    localStorage.setItem('password',result.password);
                    localStorage.setItem('role',result.role);
                    localStorage.setItem('email',result.email);
                    localStorage.setItem('phoneNumber', result.phoneNumber);
                    localStorage.setItem('address', result.address);
                    localStorage.setItem('accountId', result.accountID);
                    localStorage.setItem('status', result.status);
                    window.location.href = '<c:url value="/hone" />';
                }else{
                    window.location.href = '<c:url value="/login" />?message=login_error';
                }

            },
            error: function (error) {
                window.location.href = '<c:url value="/login" />?message=login_error';
            }
        });
    }
</script>

<%--<script src="<c:url value='template/bootstrap-5.0.2-dist/js/bootstrap.js' />" />--%>
