<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2025-10-28
  Time: 오후 4:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Title</title>
</head>
<body>
<h1>Member List</h1>
<c:forEach var="memberDTO" items="${memberDTOList}">
	<p>ID: ${memberDTO.mid}, name : ${memberDTO.mname}, </p>
</c:forEach>
</body>
</html>
