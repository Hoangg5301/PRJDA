<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<c:url var="brandApiUrl" value="/api/product" />
<c:url var="uploadUrl" value="/api/upload/product" />
<c:url var="brandDisplayUrl" value="/home-product-admin" />
<div id="dialog_brand" class="margin-content-admin marginform">



		<div class="content-main">
				<table class="table-additem">
					<tbody>
					<form:form id="form-add-brand" modelAttribute="model">
						<tr>
							<td><label><b>Tên sản phẩm:</b></label></td>
							<td>
								<form:input path="productName" />
								<input type="hidden" id="productID"  name ="productID" value="${model.productID}"/>
							</td>
						</tr>
						<tr>
							<td><label><b>Giá:</b></label></td>
							<td><form:input path="price" /></td>
						</tr>
						<tr>
							<td><label><b>Màu sắc:</b></label></td>
							<td>
								<label> <input type="radio" name="color" value="Yellow">Vàng</label>

								<label> <input type="radio" name="color" value="white">Trắng</label>

								<label> <input type="radio" name="color" value="Black">Đen</label>

								<label> <input type="radio" name="color" value="other">Màu khác</label>
							</td>
						</tr>
						<tr>
							<td><label><b>Số lượng:</b></label></td>
							<td><form:input path="quantity" /></td>
						</tr>
						<tr>
							<td><label><b>Chất liệu:</b></label></td>
							<td><form:input path="meterial" /></td>
						</tr>
						<tr>
							<td><label><b>Trọng lượng:</b></label></td>
							<td><form:input path="weight" /></td>
						</tr>
						<tr>
							<td><label><b>Mô tả:</b></label></td>
							<td><form:textarea path="describeDetail" /></td>
						</tr>
						<tr>
							<td><label><b>Giới tính</b></label></td>
							<td>
								<select name="gender" id="gender">
									<option>--Chọn giới tính--</option>
									<option value="nam">nam</option>
									<option value="nữ">nữ</option>
									<option value="khác">khác</option>
								</select>
							</td>
						</tr>
						<tr>
							<td><label><b>Loại sản phẩm:</b></label></td>
							<td>
								<select name="typeID" id="select-type">
									<option>--Chọn loại sản phẩm--</option>
									<c:forEach var="listType" items="${listProductType}">
										<option value="${listType.typeID}">${listType.typeName}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td><label><b>Nhãn hiệu:</b></label></td>
							<td>
								<select id="select-brand" name="brandID">
									<option id="select-brand">--Chọn loại nhãn hiệu--</option>
									<c:forEach var="listBrand" items="${listBrand}">
										<option value="${listBrand.brandID}">${listBrand.brandName}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						</form:form>

					<form:form id="form-image-prodduct">
						<tr>
							<td><label><b>Hình ảnh 1:</b></label></td>
							<td><input type="file" name="img1" id="img1" /></td>
						</tr>
						<tr>
							<td><label><b>Hình ảnh 2:</b></label></td>
							<td><input type="file"name="img2" id="img2" /></td>
						</tr>
						<tr>
							<td><label><b>Hình ảnh 3:</b></label></td>
							<td><input type="file" name="img3" id="img3" /></td>
						</tr>
						<tr>
							<td><label><b>Hình ảnh 4:</b></label></td>
							<td><input type="file" name="img4" id="img4" /></td>
						</tr>
					</form:form>
					</tbody>
				</table>

		</div>


	<c:if test="${not empty model.productID}">
		<button type="button" id="brand_dialog_add">cập nhật</button>
	</c:if>
	<c:if test="${empty model.productID}">
					<button type="button" id="brand_dialog_add">thêm</button>
	</c:if>

	<button type="button" id="brand_dialog_cancel">
		<a href="<c:url value ="/home-product-admin" />">Huỷ bỏ</a>
	</button>


</div>

<script>
	$("#brand_dialog_add").click(function(e) {
		e.preventDefault();
		var data = {};
		var formData = $('#form-add-brand').serializeArray();
		var id = $("#productID").val();

		// truyền form data vào object data.
		$.each(formData, function(i, v) {
			data["" + v.name + ""] = v.value;
		});
		if (id == "") {
			addBrand(data);
			addImg();
		} else {
			updateBrand(data);
			addImg();
		}
		console.log(formData);
	});

	function addBrand(data) {
		$.ajax({
					url : '${brandApiUrl}',
					type : 'POST',
					contentType : 'application/json',
					data : JSON.stringify(data),
					dataType : 'json',
					success : function(result) {
						window.location.href = '${brandDisplayUrl}?message=add_success';
					},
					error : function(error) {
						window.location.href = '${brandDisplayUrl}?message=error_system';
					}
				});
	}

	function addImg() {
		var dataImg = new FormData();
		var imageProduct1 = $("#img1")[0].files[0];
		dataImg.append("img", imageProduct1);
		var imageProduct2 = $("#img2")[0].files[0];
		dataImg.append("img", imageProduct2);
		var imageProduct3 = $("#img3")[0].files[0];
		dataImg.append("img", imageProduct3);
		var imageProduct4 = $("#img4")[0].files[0];
		dataImg.append("img", imageProduct4);
		var productID = $("#productID").val();
		dataImg.append("id", productID);

		$.ajax({
			url : '${uploadUrl}',
			type : 'POST',
			data : dataImg,
			enctype : 'multipart/form-data',
			contentType : false,
			processData : false,
			success : function(result) {
				window.location.href = '${brandDisplayUrl}?message=add_success';
			},
			error : function(error) {
				window.location.href = '${brandDisplayUrl}?message=error_system';
			}
		});
	}

	function updateBrand(data) {
		$.ajax({
					url : '${brandApiUrl}',
					type : 'PUT',
					contentType : 'application/json',
					data : JSON.stringify(data),
					dataType : 'json',
					success : function(result) {
						window.location.href = '${brandDisplayUrl}?message=update_success';
					},
					error : function(error) {
						window.location.href = '${brandDisplayUrl}?message=error_system';
					}
				});
	}
</script>

