<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<div class="conatainer">
		<div class="col-lg-8">
			<a class="btn btn-success" href="addstudent">Thêm mới</a>
			<table class="table">
				<thead>
					<tr>
						<th>MSV</th>
						<th>HO_TEN</th>
						<th>GIOI_TINH</th>
						<th>NGAY_SINH</th>
						<th>DIA_CHI</th>
						<th>MA_LOP</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list }" var="sv">
						<tr>
							<td scope="row">${sv.MSV }</td>
							<td>${sv.HO_TEN }</td>
							<td>${sv.GIOI_TINH ?"Nam" :" Nữ" }</td>
							<td>${sv.NGAY_SINH }</td>
							<td>${sv.DIA_CHI }</td>
							<td>${sv.MA_LOP }</td>
							<td><a href="updatestudent?MSV=${sv.MSV }"
								class="btn btn-primary">Update</a></td>
							<td><a href="deletestudent?MSV=${sv.MSV }"
								class="btn btn-danger" onclick="return confirm('Xóa')">Xóa</a></td>

						</tr>
					</c:forEach>


				</tbody>
			</table>
		</div>

	</div>


</body>
</html>