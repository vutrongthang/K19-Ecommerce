<%-- 
    Document   : index
    Created on : May 13, 2023, 8:38:53 PM
    Author     : vutrongthang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<c:url value="/api/cart" var="endpoint" />

<section class="container">
    <div class="row">
        <c:forEach items="${products}" var="p">
            <c:url value="/products/${p.id}" var="detail" />
            <div class="col-md-4 col-sm-6 col-xs-12 mb-4">
                <div class="card h-100">
                    <img class="card-img-top" src="${p.image}" alt="${p.name}">
                    <div class="card-body">
                        <h5 class="card-title">${p.name}</h5>
                        <p class="card-text">${p.price} VNĐ</p>
                    </div>
                    <div class="card-footer">
                        <a href="${detail}" class="btn btn-primary">Xem chi tiết</a>
                        <button class="btn btn-danger" onclick="addItemToCart('${endpoint}', ${p.id}, '${p.name}', ${p.price})">Đặt hàng</button>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>

<script src="<c:url value="/js/cart.js" />"></script>