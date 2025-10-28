<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2025-10-28
  Time: 오후 2:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<form action="/todo/register" method="POST">
	<div>Title : <input type="text" name="title"></div>
	<div>DueDate : <input type="date" name="dueDate" value="2025-10-27"></div>
	<div>Writer : <input type="text" name="writer"></div>
	<div>Finished : <input type="checkbox" name="finished"></div>
	<div><button  type="submit">Todo Register</button></div>
</form>
</body>
</html>
