<%-- 
    Document   : index
    Created on : Apr 27, 2023, 1:29:51 AM
    Author     : vutrongthang
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <div class="row">
        <c:forEach items="${products}" var="p">
            <c:url value="/products/${p.productID}" var ="detail"/>
            <div class="col-md-4">
                <div class="card mb-4">
                    <img src="${p.image}" class="card-img-top" alt="${p.productName}">
                    <div class="card-body">
                        <h5 class="card-title">${p.productName}</h5>
                        <p class="card-text">${p.description}</p>
                        <p class="card-text"><small class="text-muted">${p.quantity} in stock</small></p>
                        <p class="card-text"><strong><span id="price">${p.price}</span> VNĐ</strong></p>
                        <div class="d-flex justify-content-between">
                            <a  href="javascript:;" onclick="addItemToCart('${endpoint}', ${p.id}, '${p.name}', ${p.price})" class="btn btn-danger">
                               Thêm sản phẩm
                            </a>
                            <a href="${detail}" type="button" class="btn btn-danger">
                               Xem chi tiết
                            </a>                                                      

                        </div>

                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
<script src="<c:url value="/js/cart.js" />"></script>




