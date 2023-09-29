<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/taglib.jsp" %>
    
    <c:url var ="brandApiUrl" value="/api/brand"/>
    <c:url var ="uploadUrl" value="/api/upload/brand"/>
    <c:url var ="brandDisplayUrl" value="/home-brand-admin"/>
		<div id="dialog_brand" class ="margin-content-admin" >
		
			<form:form id="form-add-brand" modelAttribute="model">

				<div>
					<label><b>Tên nhãn hiệu:</b></label>
					<form:input path="brandName" />
					<input id="brandID" name="brandID" type="hidden" value="${model.brandID}" />
				</div>
			</form:form>
			
			<form:form id="form-image-brand1">
				<div>
					<label><b>Hình ảnh 1:</b></label>
					<input type="file" name ="img1" id="img1" />
				</div>
			</form:form>
			
			<form:form id="form-image-brand2">
				<div>
					<label><b>Hình ảnh 2:</b></label>
					<input type="file" name ="img2" />
				</div>
			</form:form>
			
			<form:form id="form-image-brand3">
				<div>
					<label><b>Hình ảnh 3:</b></label>
					<input type="file" name ="img3" />
				</div>
			</form:form>
			
			<form:form id="form-image-brand4">
				<div>
					<label><b>Hình ảnh 4:</b></label>
					<input type="file" name ="img4" />
				</div>
			</form:form>
			
				<c:if test="${not empty model.brandID}">
					<button type="button" id="brand_dialog_add">cập nhật</button>
				</c:if>
				<c:if test="${empty model.brandID}">
					<button type="button" id="brand_dialog_add">thêm</button>
				</c:if>
				
				<button type="button" id="brand_dialog_cancel"><a href="<c:url value ="/home-brand-admin" />">Huỷ bỏ</a></button>
			

		</div>

		<script>
			$("#brand_dialog_add").click(function(e) {
				e.preventDefault();
				var data ={};
				var formData = $('#form-add-brand').serializeArray();
				var id= $("#brandID").val();
				
				// truyền form data vào object data.
				$.each(formData, function(i, v){
					data[""+v.name+""] = v.value;
				});
				if(id ==""){
					addBrand(data);
					addImg();
				}else{
					updateBrand(data);
				}
				console.log(formData);
			});
			
			function addBrand(data){
				$.ajax({
					url: '${brandApiUrl}',
					type: 'POST',
					contentType: 'application/json',
		            data: JSON.stringify(data),
		            dataType: 'json',
		            success: function (result) {
		            	window.location.href = '${brandDisplayUrl}?message=add_success';
		            },
		            error: function (error) {
		            	window.location.href = '${brandDisplayUrl}?message=error_system';
		            }
				});
			}
			
			function addImg(){
				var dataImg = new FormData();
				var imageProduct = $("#img1")[0].files[0];
				dataImg.append("img1", imageProduct);
				
				
				$.ajax({
					url: '${uploadUrl}',
					type: 'POST',
					data: dataImg,
					enctype: 'multipart/form-data',
					contentType: false,
		            processData: false,
		            success: function (result) {
		            	console.log(result);
		            },
		            error: function (error) {
		            	console.log(error);
		            }
				});
			}
			
			function updateBrand(data){
				$.ajax({
					url: '${brandApiUrl}',
					type: 'PUT',
					contentType: 'application/json',
		            data: JSON.stringify(data),
		            dataType: 'json',
		            success: function (result) {
		            	window.location.href = '${brandDisplayUrl}?message=update_success';
		            },
		            error: function (error) {
		            	window.location.href = '${brandDisplayUrl}?message=error_system';
		            }
				});
			}
		</script>

