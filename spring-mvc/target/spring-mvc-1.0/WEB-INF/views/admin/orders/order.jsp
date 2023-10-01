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
                                        <tr>
                                        	<td>1</td>
                                        	<td>23/09/2023</td>
                                        	<td>134 đương Cầu Diễn, Bắc Từ Liêm Hà Nội</td>
                                        	<td>0154689346</td>
                                        	<td>Đã xác nhận</td>
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
                                        <tr>
                                        	<td>1</td>
                                        	<td>23/09/2023</td>
                                        	<td>134 đương Cầu Diễn, Bắc Từ Liêm Hà Nội</td>
                                        	<td>0154689346</td>
                                        	<td>Đã xác nhận</td>
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
                                        <tr>
                                        	<td>1</td>
                                        	<td>23/09/2023</td>
                                        	<td>134 đương Cầu Diễn, Bắc Từ Liêm Hà Nội</td>
                                        	<td>0154689346</td>
                                        	<td>Đã xác nhận</td>
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
                                        <tr>
                                        	<td>1</td>
                                        	<td>23/09/2023</td>
                                        	<td>134 đương Cầu Diễn, Bắc Từ Liêm Hà Nội</td>
                                        	<td>0154689346</td>
                                        	<td>Đã xác nhận</td>
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
                                        <tr>
                                        	<td>1</td>
                                        	<td>23/09/2023</td>
                                        	<td>134 đương Cầu Diễn, Bắc Từ Liêm Hà Nội</td>
                                        	<td>0154689346</td>
                                        	<td>Đã xác nhận</td>
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
                                        <tr>
                                        	<td>1</td>
                                        	<td>23/09/2023</td>
                                        	<td>134 đương Cầu Diễn, Bắc Từ Liêm Hà Nội</td>
                                        	<td>0154689346</td>
                                        	<td>Đã xác nhận</td>
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
                                        <tr>
                                        	<td>1</td>
                                        	<td>23/09/2023</td>
                                        	<td>134 đương Cầu Diễn, Bắc Từ Liêm Hà Nội</td>
                                        	<td>0154689346</td>
                                        	<td>Đã xác nhận</td>
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