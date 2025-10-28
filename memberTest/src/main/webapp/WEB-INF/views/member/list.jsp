<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Member List</h1>

<c:if test="${not empty msg}">
	<div style="color:green">${msg}</div>
</c:if>

<table border="1" cellpadding="6">
	<tr>
		<th>userId</th><th>userName</th><th>joinDate</th>
	</tr>
	<c:forEach var="m" items="${members}">
		<tr>
			<td><a href="${pageContext.request.contextPath}/members/${m.mid}">${m.mid}</a></td>
			<td>${m.mname}</td>
			<td>${m.joinDate}</td>
		</tr>
	</c:forEach>
</table>

<p><a href="${pageContext.request.contextPath}/members/new">+ 신규 등록</a></p>