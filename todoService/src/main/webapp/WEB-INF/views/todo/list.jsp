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

	<title>Todo</title>
</head>
<div class="container-fluid">
	<c:if test="${not empty msg}">
		<div class="alert alert-success">${msg}</div>
	</c:if>
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
				<c:forEach var="todo" items="${todos}">
					<a href="/todo/read?tno=${todo.tno}" style="text-decoration: none; color: inherit;">
					<div class="card">
						<div class="card-header">
							Todo
						</div>
						<div class="card-body">
							<h5 class="card-title">제목: ${todo.title}</h5>
							<p class="card-text">작성자: ${todo.writer}</p>
							<p class="card-text">
								상태: <span class="${todo.finished ? 'text-success' : 'text-warning'}">
									${todo.finished ? '완료됨' : '진행 중'}
							</span>
							</p>
						</div>
					</div>
					</a>
				</c:forEach>
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
