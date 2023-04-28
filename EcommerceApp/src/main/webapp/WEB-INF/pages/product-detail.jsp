<%-- 
    Document   : product-detail
    Created on : Apr 28, 2023, 11:52:36 PM
    Author     : vutrongthang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class = "row">
    <div class="col-md-5 col-xs-12">
        <img src="${products.image}" class="img-fuild"/>
    </div>
    <div class="col-md-7 col-xs-12">
        <h1>${products.productName}</h1>
        <h2>${products.price}</h2>
        <p>${products.description}</p>
    </div>
</div>