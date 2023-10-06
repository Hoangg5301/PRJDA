<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>


<!-- Custom styles for this template -->


<!-- Custom styles for this page -->
<c:url var= "deletebyid" value="/api/productDetail" />

<div class="margin-content-admin">
    <c:if test="${not empty message }">
    <div class="alert alert-${alert}">
        "${message}"
    </div>
    </c:if>

    <div class="table-content-admin">
        <div class="container-fluid">
            <!-- DataTales Example -->
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Chi tiết sản phẩm "${model.productName}"</h6>
                </div>
                <div class="card-body">
                    <form:form>
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr class="hcenter-content">
                                    <th>ID chi tiết</th>
                                    <th>Size</th>
                                    <th>Số lượng</th>
                                    <th>Thao tác</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="item" items="${model.listResult}" >
                                    <tr>
                                        <td>${item.productDetailID}</td>
                                        <td>${item.size}</td>
                                        <td>${item.quantity}</td>
                                        <c:url var="productDetailUpdate" value="home-productDetailUpdate-admin">
                                            <c:param name="productDetailID" value="${item.productDetailID}"/>
                                        </c:url>
                                        <td class="hcenter-content"><a href="${productDetailUpdate}" class="btn btn-warning btn-icon-split">
                                                    <span class="icon text-white-50">
                                                        <i class="fas fa-fw fa-cog"></i>
                                                    </span>
                                            <span class="text">Sửa</span>
                                        </a>

                                            <button type="button" class="btn btn-danger btn-icon-split" onclick="warningBeforeDelete(${item.productDetailID})">
                                                    <span class="icon text-white-50">
                                                        <i class="fas fa-trash"></i>
                                                    </span>
                                                <span class="text">Xóa</span>
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>
                        <c:url var="postAdd" value ="home-postupdate-admin" />
                        <div style="align-items: end; justify-content: end;"><button id="brand_add" type="button"><a href="${postAdd}">Thêm</a></button></div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>

    <script>

        function warningBeforeDelete(id){
            swal({
                title: "Xác nhận",
                text: "Bạn có muốn thực hiện yêu cầu này không",
                type: "warning",
                showCancelButton: true,
                confirmButtonClass: "btn-success",
                cancelButtonClass: "btn-danger",
                confirmButtonText: "xác nhận",
                cancelButtonText: "huỷ bỏ",
                closeOnConfirm: false,
                closeOnCancel: false
            }).then(function(isConfirm) {
                if (isConfirm) {
                    deleteById(id);
                }
            });
        }

        function deleteById(id){
            $.ajax({
                url: '${deletebyid}',
                type: 'DELETE',
                contentType: 'application/json',
                data: JSON.stringify(id),
                success: function(result){
                    window.location.href = '${brandDisplayUrl}?message=delete_success';
                },

                error: function (error) {
                    window.location.href = '${brandDisplayUrl}?message=error_system';
                }
            })
        }
    </script>