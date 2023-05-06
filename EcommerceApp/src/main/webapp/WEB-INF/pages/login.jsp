<%-- 
    Document   : login
    Created on : Apr 15, 2023, 4:25:51 PM
    Author     : admin
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-danger">ĐĂNG NHẬP NGƯỜI DÙNG</h1>

<c:if test="${param.error != null}">
    <div class="alert alert-danger">
        Username hoặc password không chính xác!!!
    </div>
</c:if>

<c:url value="/login" var="action" />

<form method="post" action="${action}">
    <div class="form-group">
        <label>Username</label>
        <input type="text" name="username" class="form-control" />
    </div>
    <div class="form-group">
        <label>Password</label>
        <input type="password" name="password" class="form-control" />
    </div>
    <input type="submit" value="Đăng nhập" class="btn btn-danger" />
</form>
<br><br>