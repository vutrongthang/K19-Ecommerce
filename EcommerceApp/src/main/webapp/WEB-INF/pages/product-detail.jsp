<%-- 
    Document   : product-detail
    Created on : Apr 28, 2023, 11:52:36 PM
    Author     : vutrongthang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="container my-5">
  <div class="row">
    <div class="col-md-5">
      <img src="${products.image}" class="img-fluid"/>
    </div>
    <div class="col-md-7">
      <h1 class="mb-3">${products.productName}</h1>
      <h2 class="mb-3">${products.price} VNĐ</h2>
      <p class="mb-3">${products.description}</p>
      <button class="btn btn-primary btn-lg">
        Thêm vào giỏ hàng
      </button>
    </div>
  </div>
</div>
