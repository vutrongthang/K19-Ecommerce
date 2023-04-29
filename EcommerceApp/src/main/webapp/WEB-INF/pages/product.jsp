<%-- 
    Document   : product
    Created on : Apr 29, 2023, 9:53:24 AM
    Author     : vutrongthang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1 class="text-info text-center">QUẢN TRỊ SẢN PHẨM</h1>
<c:if test="${errMsg != null}">
    ${errMsg}
</c:if>
<c:url value="/admin/product" var="action"/>
<form:form method="post" action="${action}" modelAttribute="product" enctype="multipart/form-data">
    <div class="form-floating mb-3 mt-3">
        <form:input type="text"  class="form-control" id="name" placeholder="Tên sản phẩm" path="productName" name="name" />
        <label for="name">Tên sản phẩm</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="number"  class="form-control" id="price" placeholder="Tên sản phẩm" path="price" name="price" />
        <label for="price">Giá sản phẩm</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="file"  class="form-control" id="file" placeholder="Tên sản phẩm" path="file" name="file" />
        <label for="file">Ảnh sản phẩm</label>
    </div>
    <div class="form-floating">
        <form:select class="form-select" id="categoryID" path="categoryID" name="categoryID">
            <c:forEach items="${categories}" var="c">
                <option value="${c.categoryID}">${c.name}</option>
            </c:forEach>
        </form:select>
        <label for="sel1" class="form-label">Danh mục sản phẩm:</label>
    </div>
    <div class="form-floating mt-3">
        <input type="submit" value="Thêm sản phẩm" class="btn btn-danger"/>
    </div>
</form:form>



