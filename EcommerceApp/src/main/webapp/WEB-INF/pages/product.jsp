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
    <form:errors path="productName" element="div" cssClass="alert alert-danger"/>

    <div class="form-floating mb-3 mt-3">
        <form:input type="number"  class="form-control" id="price" placeholder="Tên sản phẩm" path="price" name="price" />
        <label for="price">Giá sản phẩm</label>
    </div>
    <form:errors path="price" element="div" cssClass="alert alert-danger"/>

    <div class="form-floating mb-3 mt-3">
        <form:input type="file"  class="form-control" id="file" placeholder="Tên sản phẩm" path="file" name="file" />
        <label for="file">Ảnh sản phẩm</label>
        <c:if test="${product.image != null}">
            <div class="form-floating mb-3 mt-3">
                <img src="${product.image}" width="120" /> 
            </div>
        </c:if>
    </div>
    <form:errors path="file" element="div" cssClass="alert alert-danger"/>
    <div class="form-floating">
        <form:select class="form-select" path="categoryID" id="categoryID" name="categoryID">
            <c:forEach items="${categories}" var="c">
                <c:choose>
                    <c:when test="${product.categoryID.categoryID == c.categoryID}">
                        <option value="${c.categoryID}" selected>${c.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${c.categoryID}">${c.name}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </form:select>
        <label for="sel1" class="form-label">Danh mục sản phẩm</label>
    </div>

    <div class="form-floating mt-3">
        <input type="submit" value="Thêm sản phẩm" class="btn btn-danger"/>
    </div>
</form:form>

<table class="table">
    <tr>
        <th></th>
        <th>Id</th>
        <th>Tên sản phẩm</th>
        <th>Giá</th>
        <th></th>
    </tr>
    <c:forEach items="${products}" var="p">
        <tr id="product${p.productID}">
            <td><img src="${p.image}" width="200" /></td>
            <td>${p.productID}</td>
            <td>${p.productName}</td>
            <td>${p.price}</td>
            <td>
                <div id="spinner${p.productID}" style="display:none" class="spinner-border text-info"></div>
                <c:url value="/api/product/${p.productID}" var="endpoint"/>
                <input type="button" onclick="deleteProduct('${endpoint}', ${p.productID})" value="Delete" class="btn btn-danger"/>
                <a href="<c:url value="/admin/product/${p.productID}" />" class="btn btn-info">Cập nhật</a>
            </td>
        </tr>
    </c:forEach>
</table>
<script src="<c:url value="/js/product.js"/>"></script>



