<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link href="<c:url= 'admin/content/vendor/fontawesome-free/css/all.min.css'/>
" rel="stylesheet" type="text/css">
<link href="<c:url=
	'https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i '/>
" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url= 'admin/content/css/sb-admin-2.min.css'/>
" rel="stylesheet">

<!-- Custom styles for this page -->
<link href="<c:url= 'admin/content/vendor/datatables/dataTables.bootstrap4.min.css'/>
" rel="stylesheet">


<script>
		function openDialogBrand() {
			var dialogbrand = document.getElementById("dialog_brand");
			if (dialogbrand.open == false) {
				dialogbrand.open = true;
			}
		}
		
		function closeDialogBrand() {
			var dialogbrand = document.getElementById("dialog_brand");
			if (dialogbrand.open == true) {
				dialogbrand.open = false;
			}
		}
	
/*	$("#brand_add").click(function(){
		$.open_dialogbrand();
	})
*/
</script>
<div class="margin-content-admin">
	<h4>Nhãn hiệu</h4>
	<form id="brand_form">
		<div class="table-content-admin">
			<div class="container-fluid">

				<!-- DataTales Example -->
				<div class="card shadow mb-4">
					<div class="card-header py-3">
						<h6 class="m-0 font-weight-bold text-primary">DataTables
							Example</h6>
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table table-bordered" id="dataTable" width="100%"
								cellspacing="0">
								<thead>
									<tr>
										<th>Name</th>
										<th>Position</th>
										<th>Lựa chọn</th>
									</tr>
								</thead>

								<tbody>
									<tr>
										<td>Tiger Nixon</td>
										<td>System Architect</td>
										<td><button id="brand_add" type="button" Onclick="openDialogBrand()">Thêm</button></td>
									</tr>
									<tr>
										<td>Garrett Winters</td>
										<td>Accountant</td>
									</tr>

								</tbody>
							</table>
						</div>
					</div>
				</div>

			</div>
		</div>

		<dialog id="dialog_brand">
		<table class="table table-bordered" id="dataTable" width="100%"
			cellspacing="0">
			<thead>
				<tr>
					<th>Tên nhãn hiệu</th>
					<th>ảnh</th>
				</tr>
			</thead>

			<tbody>
				<tr>
					<td><input name="brandName" type="text"/></td>
					<td><input name="brandImg" type="text"/></td>
				</tr>

				<tr>
					<button type="button" id="brand_dialog_add">Thêm</button>
					<button type="button" id="brand_dialog_cancel" Onclick="closeDialogBrand()" >Huỷ bỏ</button>
				</tr>
			</tbody>
		</table>
		</dialog>
		

	</form>
</div>

