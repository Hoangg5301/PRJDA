<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="margin-content-admin">
	<c:if test="${not empty message }">
		<div class="alert alert-${alert}">
			"${message}"
		</div>
	</c:if>

	<form:form id="brand_form">
		
		<div class="table-content-admin">
		<div class="container-fluid">
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                    <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Danh sách nhãn hiệu</h6>
                            
                        </div>
                        <div class="card-body">
                        	<c:url var="brandAdd" value ="home-brandupdate-admin" />
							<div style="align-items: end; justify-content: end;;"><button id="brand_add" type="button"><a href="${brandAdd}">Thêm</a></button></div>
                            <div class="table-responsive">
                            
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr class="hcenter-content">
                                            <th>Tên nhãn hiệu</th>
                                            <th>Hình ảnh</th>
                                            <th>Thao tác</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    
                                    	<c:forEach var="item" items="${model.listResult}" varStatus="loop">
                                        <tr>
                                        	<input type="hidden" id = "idElement_${loop.index}" value="${item.brandID}" />
                                        	<c:url var="deletebyid" value ="/api/brand" />
                                        	<td>${item.brandName}</td>
											<td>${item.brandImg}</td>
											
											<c:url var="brandUpdate" value="home-brandupdate-admin">
												<c:param name="id" value="${item.brandID}"/>
											</c:url>
                                        	<td class="hcenter-content"><a href="${brandUpdate}" class="btn btn-warning btn-icon-split">
                                                    <span class="icon text-white-50">
                                                        <i class="fas fa-fw fa-cog"></i>
                                                    </span>
                                                    <span class="text">Sửa</span>
                                                </a>
                                                
                                             <c:url var="brandDelete" value="/api/brand">
												<c:param name="id" value="${item.brandID}"/>
											</c:url>
											<button class="btn btn-danger btn-icon-split" type="button" onclick= "warningBeforeDelete($('#idElement_${loop.index}').val())">
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
	</form:form>
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
