<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>

    <div class="margin-content-admin">
    	<c:if test="${not empty message }">
		<div class="alert alert-${alert}">
			"${message}"
		</div>
		
		<c:url var="producttype" value = "/home-producttype-admin" />
		<c:url var="productTypeupdate" value = "/home-producttypeupdate-admin" />

	</c:if>
		<div id="wrapper">

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">Danh sách danh mục</h6>
                        </div>
                        <div class="card-body">
                        <c:url var="brandAdd" value ="home-producttypeupdate-admin" />
							<div style="align-items: end; justify-content: end;"><button id="brand_add" type="button"><a href="${brandAdd}">Thêm</a></button></div>
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr class="hcenter-content">
                                            <th>Tên danh mục</th>
                                            <th>Mô tả chi tiết</th>
                                            <th>Thao tác</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="item" items="${model.listResult}" varStatus="loop" >
                                        <tr>
                                            <td>${item.typeName}</td>
                                            <td>${item.typeDetail}</td>
                                            <input type="hidden" id="idElement_${loop.index }" value="${item.typeID}" />
                                            <c:url var="productTypeUpdate" value="home-producttypeupdate-admin">
												<c:param name="id" value="${item.typeID}"/>
											</c:url>
                                        	<td class="hcenter-content"><a href="${productTypeUpdate}" class="btn btn-warning btn-icon-split">
                                                    <span class="icon text-white-50">
                                                        <i class="fas fa-fw fa-cog"></i>
                                                    </span>
                                                    <span class="text">Sửa</span>
                                                </a>
                                                
                                             <c:url var="productTypeDelete" value="/api/producttype" />

                                                <button class="btn btn-danger btn-icon-split" type="button" onclick= "warningBeforeDelete($('#idElement_${loop.index }').val())">
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
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

        </div>
        <!-- End of Content Wrapper -->

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
			  else{
				  window.location.href = '${producttype}';
			  }
			});
	}
	
	function deleteById(id){
		$.ajax({
			url: '${productTypeDelete}',
			type: 'DELETE',
			contentType: 'application/json',
            data: JSON.stringify(id),
			success: function(result){
				window.location.href = '${producttype}?message=delete_success';
			},
			
			error: function (error) {
            	window.location.href = '${producttype}?message=error_system';
            }
		})
		
	}
</script>

