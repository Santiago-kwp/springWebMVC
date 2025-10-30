<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

	<!-- Bootstrap CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	      rel="stylesheet"
	      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	      crossorigin="anonymous">

	<title>Todo 등록</title>
</head>
<div class="container-fluid">
	<div class="row"><!-- As a link -->
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">
				<a class="navbar-brand" href="/todo/list">TODO</a>
				<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
				        data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
				        aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
					<div class="navbar-nav">
						<a class="nav-link active" aria-current="page" href="/todo/register">Todo 등록</a>
						<%--						<a class="nav-link" href="#">Features</a>--%>
						<%--						<a class="nav-link" href="#">Pricing</a>--%>
						<%--						<a class="nav-link disabled">Disabled</a>--%>
					</div>
				</div>
			</div>
		</nav>

		<div class="row content">
			<div class="col">
					<div class="card">
						<div class="card-header">
							Todo 등록하기
						</div>
						<div class="card-body">
							<form action="${pageContext.request.contextPath}/todo" method="POST">
								<div class="input-group input-group-lg mb-3">
									<span class="input-group-text" id="inputGroup-sizing-lg-1">Title</span>
									<input type="text" name="title" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg-1">
								</div>

								<div class="input-group input-group-lg mb-3">
									<span class="input-group-text" id="inputGroup-sizing-lg-2">dueDate</span>
									<input type="date" name="dueDate" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg-2">
								</div>

								<div class="input-group input-group-lg mb-3">
									<span class="input-group-text" id="inputGroup-sizing-lg-3">Writer</span>
									<input type="text" name="writer" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-lg-3">
								</div>
								<button type="submit" class="btn btn-primary btn-lg">Submit</button>
								<button type="reset" class="btn btn-secondary btn-lg">Reset</button>
							</form>


						</div>
					</div>
			</div>
		</div>

		<div class="row   fixed-bottom" style="z-index: -100">
			<footer class="py-1 my-1 ">
				<p class="text-center text-muted">Footer</p>
			</footer>
		</div>
	</div>

	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	        crossorigin="anonymous"></script>

</div>
</body>
</html>
