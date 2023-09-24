<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>


<div class="margin-content-admin">
	<h4>Nhãn hiệu</h4>
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
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead>
									<tr>
										<th>Tên</th>
										<th>img</th>
										<th>Lựa chọn</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach var="item" items="${model.listResult}" >
									<tr>
										<td>${item.brandName}</td>
										<td>${item.brandImg}</td>
										<td>
											<c:url var="brandUpdate" value="home-brandupdate-admin">
												<c:param name="id" value="${item.brandID}"/>
											</c:url>
											<button id="brand_add" type="button"><a href="${brandUpdate}">sửa</a></button>
											
											<c:url var="brandDelete" value="/api/brand">
												<c:param name="id" value="${item.brandID}"/>
											</c:url>
											<button id="brand_add" type="button" ><a href="${brandDelete}">xoá</a></button>
										</td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
							<c:url var="brandAdd" value ="home-brandupdate-admin" />
							<td><button id="brand_add" type="button"><a href="${brandAdd}">thêm</a></button></td>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form:form>
</div>

