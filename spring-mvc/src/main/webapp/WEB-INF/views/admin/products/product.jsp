<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>


<!-- Custom styles for this template -->

<c:url var="deletebyid" value ='/api/product' />
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
                            <h6 class="m-0 font-weight-bold text-primary">Danh sách sản phẩm</h6>
                        </div>
                        <div class="card-body">
                        <c:url var="brandAdd" value ="home-productupdate-admin" />
							<div style="align-items: end; justify-content: end;;"><button id="brand_add" type="button"><a href="${brandAdd}">Thêm</a></button></div>
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr class="hcenter-content">
                                            <th>Tên sản phẩm</th>
                                            <th>Ảnh</th>
                                            <th>Giá</th>
                                            <th>Số lương</th>
                                            <th>Nhãn hiệu</th>
                                            <th>Thao tác</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="item" items="${model.listResult}" varStatus="loop">

                                        <a>

                                        </a>
                                        <tr id="productDetailClick">
                                        	<input type="hidden" value = "${item.productID}" id="idElement_${loop.index}" name="idElement" />
                                            <input type="hidden" value = "${item.productName}" id="nameElement_${loop.index}" name="nameElement" />
                                        	<td>${item.productName}</td>
                                        	<td><img style="weight: 100px; height: 100px;" src="<c:url value ='${item.img1}' />" /></td>
                                        	<td>${item.price} VNĐ</td>
                                        	<td>${item.quantity}</td>
                                        	<td>${item.brandName}</td>
                                        	<c:url var="brandUpdate" value="home-productupdate-admin">
												<c:param name="id" value="${item.productID}"/>
											</c:url>
                                        	<td class="hcenter-content"><a href="${brandUpdate}" class="btn btn-warning btn-icon-split">
                                                    <span class="icon text-white-50">
                                                        <i class="fas fa-fw fa-cog"></i>
                                                    </span>
                                                    <span class="text">Sửa</span>
                                                </a>
                                                
                                             <c:url var="brandDelete" value="/api/product">
												<c:param name="id" value="${item.productID}"/>
											</c:url>
                                                <button onclick="warningBeforeDelete($('#idElement_${loop.index}').val())" type="button" class="btn btn-danger btn-icon-split">
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
                        </div>
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