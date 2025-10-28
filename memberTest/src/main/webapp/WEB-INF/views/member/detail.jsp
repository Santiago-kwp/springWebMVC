<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Member Detail</h1>

<c:if test="${not empty error}">
    <div style="color:red">${error}</div>
</c:if>

<c:if test="${not empty member}">
    <ul>
        <li>아이디: ${member.mid}</li>
        <li>이름: ${member.mname}</li>
        <li>가입일자: ${member.joinDate}</li>
    </ul>
</c:if>

<p><a href="${pageContext.request.contextPath}/members">목록</a></p>