<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Title</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="col-lg-6">
			<form action="addstudent" method="POST">
				<div class="form-group">
					<label for="email">MSV :</label> <input type="text"
						class="form-control" placeholder="Nhap vao  msv" id="email"
						name="MSV">
				</div>
				<div class="form-group">
					<label for="pwd">Ho Ten :</label> <input type="text"
						class="form-control" placeholder="Nhap vao ho ten" id="pwd"
						name="HO_TEN">
				</div>

				<div class="form-group">
					<label for="pwd">Birday :</label> <input type="date"
						class="form-control" id="pwd" name="NGAY_SINH">
				</div>
				<div class="form-group">
					<label for="pwd">Dia chi :</label> <input type="text"
						class="form-control" placeholder="Nhap vao dia chi" id="pwd"
						name="DIA_CHI">
				</div>
				<div class="form-group">
					<label for="pwd">Ma Lop :</label> <input type="text"
						class="form-control" placeholder="Nhap vao ma lop" id="pwd"
						name="MA_LOP">
				</div>
				<div class="form-group">
					<label for="pwd">Gioi tinh :</label>
					<div class="form-check form-check-inline">

						<label class="form-check-label"> <input
							class="form-check-input" type="radio" name="gender" id=""
							value="1"> Nam
						</label> <label class="form-check-label"> <input
							class="form-check-input" type="radio" name="gender" id=""
							value="0"> Nữ
						</label>
					</div>
				</div>

				<button type="submit" class="btn btn-primary">Thêm Mới</button>
			</form>
		</div>
	</div>

</body>
</html>