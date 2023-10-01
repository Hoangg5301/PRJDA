<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<c:url var="brandApiUrl" value="/api/product" />
<c:url var="uploadUrl" value="/api/upload/product" />
<c:url var="brandDisplayUrl" value="/home-product-admin" />
<div id="dialog_brand" class="margin-content-admin">

	<form:form id="form-add-brand" modelAttribute="model">

		<div>
			<label><b>Tên sản phẩm:</b></label>
			<form:input path="productName" />
			<input type="hidden" id="productID"  name ="productID" value="${model.productID}"/>
		</div>
		<label><b>Giá:</b></label>
		<form:input path="price" />
		<div></div>
		<label><b>Size:</b></label>
		<form:input path="size" />
		<div></div>

		<label> <input type="radio" name="color" value="Yellow">
			Vàng
		</label>
		<br>
		<label> <input type="radio" name="color" value="white">
			Trắng
		</label>
		<br>
		<label> <input type="radio" name="color" value="Black">
			Đen
		</label>
		
				<label> <input type="radio" name="color" value="other">
			Màu khác
		</label>

		<div></div>
		<label><b>Số lượng:</b></label>
		<form:input path="quantity" />
		<div></div>
		<label><b>Chất liệu:</b></label>
		<form:input path="meterial" />
		<div></div>
		<label><b>Trọng lượng:</b></label>
		<form:input path="weight" />
		<div></div>
		<label><b>Mô tả:</b></label>
		<form:input path="describeDetail" />
		<div></div>
		<label><b>Giới tính</b></label>
		<form:input path="gender" />
		<div></div>
		<label><b>Loại sản phẩm:</b></label>
		<select name="typeID" id="select-type">
			<option>--Chọn loại sản phẩm--</option>
			<c:forEach var="listType" items="${listProductType}">
				<option value="${listType.typeID}">${listType.typeName}</option>
			</c:forEach>
		</select>

		<div></div>
		<label><b>Nhãn hiệu:</b></label>
		<select id="select-brand" name="brandID">
			<option id="select-brand">--Chọn loại nhãn hiệu--</option>
			<c:forEach var="listBrand" items="${listBrand}">
				<option value="${listBrand.brandID}">${listBrand.brandName}</option>
			</c:forEach>
		</select>
		<div></div>
	</form:form>

	<form:form id="form-image-prodduct">
		<div>
			<label><b>Hình ảnh 1:</b></label><input type="file" name="img1" id="img1" /> 
				<hr>
			<label><b>Hình ảnh 2:</b></label> <input type="file"name="img2" id="img2" />
				<hr>
			<label><b>Hình ảnh 3:</b></label> <input type="file" name="img3" id="img3" /> 
				<hr>
			<label><b>Hình ảnh 4:</b></label> <input type="file" name="img4" id="img4" />
		</div>
	</form:form>

	<c:if test="${not empty model.productID}">
		<button type="button" id="brand_dialog_add">cập nhật</button>
	</c:if>
	<c:if test="${empty model.productID}">ss
					<button type="button" id="brand_dialog_add">thêm</button>
	</c:if>

	<button type="button" id="brand_dialog_cancel">
		<a href="<c:url value ="/home-brand-admin" />">Huỷ bỏ</a>
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
				console.log(result);
			},
			error : function(error) {
				console.log(error);
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

