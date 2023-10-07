<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>


<!-- Custom styles for this template -->

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
                            <h6 class="m-0 font-weight-bold text-primary">Đơn hàng</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr class="hcenter-content">
                                            <th>ID đơn hàng</th>
                                            <th>Ngày tạo</th>
                                            <th>Địa chỉ</th>
                                            <th>Số điện thoại</th>
                                            <th>Trạng thái</th>
                                            <th>Thao tác</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                    <c:forEach var="item" items="${model}" varStatus="loop">
                                    <tr>
                                        <td>${item.id}</td>
                                        <td>${item.createdDate}</td>
                                        <td>${item.address}</td>
                                        <td>${item.phoneNumber}</td>

                                        <c:if test="${item.status == 0}">
                                            <td>Đã huỷ</td>
                                        </c:if>
                                        <c:if test="${item.status == 1}">
                                            <td>Chưa xác nhận</td>
                                        </c:if>

                                        <c:if test="${item.status == 2}">
                                            <td>Đang giao</td>
                                        </c:if>
                                        <c:if test="${item.status == 3}">
                                            <td>Hoàn tất</td>
                                        </c:if>

                                        <c:url var="orderupdate" value="home-orderupdate-admin">
                                            <c:param name="id" value="${item.id}"/>
                                        </c:url>
                                        <td>
                                            <select class="select_status" name="${item.id}">
                                                <option>Lựa chọn</option>
                                                <option value="0">Đã huỷ</option>
                                                <option value="1">Chưa xác nhận</option>
                                                <option value="2">Xác nhận</option>
                                                <option value="3">Đang giao</option>
                                                <option value="4">Hoàn tất</option>
                                            </select>
                                        </td>
                                    </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
	</div>
</div>

<script>
    $('.select_status').change(function selectfunction(){
        var idSelect= this.name;
        var statusSelect = this.value;
        const data = {
            id: idSelect,
            status: statusSelect
        }

        $.ajax({
            url : '<c:url value="/api/order" />',
            type : 'PUT',
            contentType : 'application/json',
            data : JSON.stringify(data),
            dataType : 'json',
            success : function(result) {
                window.location.href = '<c:url value="/home-order-admin" />';
            },
            error : function(error) {
                window.location.href = '<c:url value="/home-order-admin" />';
            }
        });
    });
</script>