<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<c:url var="brandApiUrl" value="/api/productDetail" />
<c:url var="brandDisplayUrl" value="/home-productDetail-admin" />
<div id="dialog_brand" class="margin-content-admin marginform">

    <div class="content-main">
        <table class="table-additem">
            <tbody>
            <form:form id="form-add-brand" modelAttribute="model">
                <tr>
                    <td><label><b>Size:</b></label></td>
                    <td>
                        <form:input path="size" />
                        <input type="hidden" id="productDetailID"  name ="productDetailID" value="${model.productDetailID}"/>
                    </td>
                </tr>
                <tr>
                    <td><label><b>Số lượng:</b></label></td>
                    <td><form:input path="quantity" /></td>
                </tr>
            </form:form>
            </tbody>
        </table>

    </div>


    <c:if test="${not empty model.productDetailID}">
        <button type="button" id="brand_dialog_add">cập nhật</button>
    </c:if>
    <c:if test="${empty model.productDetailID}">
        <button type="button" id="brand_dialog_add">thêm</button>
    </c:if>

    <button type="button" id="brand_dialog_cancel">
        <a href="<c:url value ="/home-productDetail-admin" />">Huỷ bỏ</a>
    </button>


</div>

<script>
    $("#brand_dialog_add").click(function(e) {
        e.preventDefault();
        var data = {};
        var formData = $('#form-add-brand').serializeArray();
        var id = $("#productDetailID").val();

        // truyền form data vào object data.
        $.each(formData, function(i, v) {
            data["" + v.name + ""] = v.value;
        });
        if (id == "") {
            addBrand(data);
        } else {
            updateBrand(data);
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
                window.location.href = '${brandDisplayUrl}?productID=${model.productID}';
            },
            error : function(error) {
                window.location.href = '${brandDisplayUrl}?productID=${model.productID}';
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
                window.location.href = '${brandDisplayUrl}?productID=${model.productID}';
            },
            error : function(error) {
                window.location.href = '${brandDisplayUrl}?productID=${model.productID}';
            }
        });
    }
</script>

