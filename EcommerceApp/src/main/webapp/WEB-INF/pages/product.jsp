<%-- 
    Document   : product
    Created on : Apr 29, 2023, 9:53:24 AM
    Author     : vutrongthang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 class="text-info text-center">QUẢN TRỊ SẢN PHẨM</h1>
<form:form method="post" modelAttribute="product">
    <div class="form-floating mb-3 mt-3">
        <form:input  class="form-control" id="email" placeholder="Enter email" path="productName" name="email" />
        <label for="email">Email</label>
    </div>
</form:form>



