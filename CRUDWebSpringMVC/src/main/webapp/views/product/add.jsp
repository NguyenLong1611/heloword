<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
		<div class="row justify-content-center">
			<div class="col-lg-6">
				<form:form action="createProduct" method="POST"
					modelAttribute="product" enctype="multipart/form-data">
					<div class="form-group">
						<label for="email">Product Name:</label>
						<form:input type="text" class="form-control" path="PRODUCTNAME" />
					</div>
					<div class="form-group">
						<label for="email">Product Price:</label>
						<form:input type="text" class="form-control" path="PRICE" />
					</div>
					<div class="form-group">
						<label for="email">Product Image:</label> <input type="file"
							class="form-control" name="fileImage" />
					</div>
					<div class="form-group">
						<label for="email">Category:</label>
						<form:select path="category.categoryId" class="form-control">
							<form:options items="${listCategory}" itemLabel="categoryName"
								itemValue="categoryId" />
						</form:select>
					</div>
					
					<div class="form-group">
						<label for="email"> Description:</label> 
						<form:textarea path="DESCRIPTION" class="form-control"/>
					</div>
					<button type="submit" class="btn btn-primary">Thêm Mới Sản
						Phẩm</button>
			</div>
		</div>


		</form:form>

	</div>
	</div>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>