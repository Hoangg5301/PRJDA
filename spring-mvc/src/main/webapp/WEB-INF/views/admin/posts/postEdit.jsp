<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/taglib.jsp" %>
    
    <c:url var ="brandApiUrl" value="/api/post"/>

    <c:url var ="brandDisplayUrl" value="/home-post-admin"/>
		<div id="dialog_brand" class ="margin-content-admin" >
		
			<form:form id="form-add-brand" modelAttribute="model">

				<div>
					<label><b>Tiêu đề bài viết:</b></label>
						<form:input path="postName" />
					<input id="postID" name="postID" type="hidden" value="${model.postID}" />
				</div>
				<div>
					<label><b>Tiêu đề bài viết:</b></label>
					<form:textarea path="postContent" />
				</div>
			</form:form>
				<c:if test="${not empty model.postID}">
					<button type="button" id="brand_dialog_add">cập nhật</button>
				</c:if>
				<c:if test="${empty model.postID}">
					<button type="button" id="brand_dialog_add">thêm</button>
				</c:if>
				
				<button type="button" id="brand_dialog_cancel"><a href="<c:url value ="/home-brand-admin" />">Huỷ bỏ</a></button>
			
		</div>

		<script>
			$("#brand_dialog_add").click(function(e) {
				e.preventDefault();
				var data ={};
				var formData = $('#form-add-brand').serializeArray();
				var id= $("#postID").val();
				
				// truyền form data vào object data.
				$.each(formData, function(i, v){
					data[""+v.name+""] = v.value;
				});
				if(id ==""){
					addBrand(data);
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

