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
                            <h6 class="m-0 font-weight-bold text-primary">Danh sách sản phẩm</h6>
                        </div>
                        <div class="card-body">
                        <c:url var="brandAdd" value ="home-brandupdate-admin" />
							<div style="align-items: end; justify-content: end;;"><button id="brand_add" type="button"><a href="${brandAdd}">Thêm</a></button></div>
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr class="hcenter-content">
                                            <th>Tên sản phẩm</th>
                                            <th>Giá</th>
                                            <th>Số lương</th>
                                            <th>Nhãn hiệu</th>
                                            <th>Thao tác</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                        	<td>Giày Thể Thao Nike Quest 4 Road Running Shoes DA1105-007 Màu Ghi</td>
                                        	<td>1200.000 VNĐ</td>
                                        	<td>155</td>
                                        	<td>NIKE</td>
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
                                                <a href="${brandDelete}" class="btn btn-danger btn-icon-split">
                                                    <span class="icon text-white-50">
                                                        <i class="fas fa-trash"></i>
                                                    </span>
                                                    <span class="text">Xóa</span>
                                                </a>
                                             </td>
                                        </tr>
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
	</div>
</div>