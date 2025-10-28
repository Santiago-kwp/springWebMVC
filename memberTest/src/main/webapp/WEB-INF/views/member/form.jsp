<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1>Member Register</h1>

<%--@elvariable id="member" type=""--%>
<form:form method="post" modelAttribute="member" action="${pageContext.request.contextPath}/members">
  <div>
    <label>아이디</label>
    <form:input path="mid"/>
    <form:errors path="mid" cssStyle="color:red"/>
  </div>
  <div>
    <label>비밀번호</label>
    <form:password path="mpw"/>
    <form:errors path="mpw" cssStyle="color:red"/>
  </div>
  <div>
    <label>이름</label>
    <form:input path="mname"/>
    <form:errors path="mname" cssStyle="color:red"/>
  </div>
  <div>
    <label>가입일자</label>
    <form:input path="joinDate" type="date"/>
  </div>
  <div>
    <button type="submit">저장</button>
  </div>
</form:form>