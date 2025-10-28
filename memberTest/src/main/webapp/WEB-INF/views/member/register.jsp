<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2025-10-28
  Time: 오후 4:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<h1>새로운 맴버 등록</h1>
<form action="/member/register" method="POST">
	<div>아이디 : <input type="text" name="mid"></div>
	<div>비밀번호 : <input type="password" name="mpw"></div>
	<div>사용자명 : <input type="text" name="mname"></div>
	<div><button type="submit">등록!</button> </div>
</form>

</body>
</html>
