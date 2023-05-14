<%-- 
    Document   : stats
    Created on : May 14, 2023, 7:23:08 AM
    Author     : vutrongthang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-success">THỐNG KÊ BÁO CÁO</h1>

<div class="row">
    <div class="col-md-7">
        <table class="table table-hover">
            <tr>
                <th>Id</th>
                <th>Tên danh mục</th>
                <th>Số lượng</th>
            </tr>
            <c:forEach items="${cateStats}" var="c">
                <tr>
                    <td>${c[0]}</td>
                    <td>${c[1]}</td>
                    <td>${c[2]}</td>
                </tr>
            </c:forEach>
        </table>

    </div>
    <div class="col-md-5">
        <canvas id="myCateChart"></canvas>
    </div>
</div>
<hr />
<div class="row">
    <div class="col-md-7">
        <table class="table table-hover">
            <tr>
                <th>Id</th>
                <th>Tên sản phẩm</th>
                <th>Doanh thu</th>
            </tr>
            <c:forEach items="${revenues}" var="c">
                <tr>
                    <td>${c[0]}</td>
                    <td>${c[1]}</td>
                    <td>${c[2]} VNĐ</td>
                </tr>
            </c:forEach>
        </table>

    </div>
    <div class="col-md-5">
        <canvas id="myRevenueChart"></canvas>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="<c:url value="/js/stats.js" />"></script>
<script>
    let data1 = [], label1 = [];
    <c:forEach items="${cateStats}" var="c">
        data1.push(${c[2]});
        label1.push('${c[1]}');
    </c:forEach>
        
    let data2 = [], label2 = [];
    <c:forEach items="${revenues}" var="c">
        data2.push(${c[2]});
        label2.push('${c[1]}');
    </c:forEach>
        
    window.onload = function() {
        drawChart(data1, label1, "myCateChart", "Số lượng");
        drawChart(data2, label2, "myRevenueChart", "Doanh thu", "bar");
    };
</script>
