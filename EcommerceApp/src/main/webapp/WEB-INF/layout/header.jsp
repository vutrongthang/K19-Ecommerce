<%-- 
    Document   : header
    Created on : Apr 28, 2023, 4:03:57 PM
    Author     : vutrongthang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark sticky-top ">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Thương mại điện tử</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link " href="#">Trang chủ</a>
                </li>
                <li class="nav-item">
                    <select class="form-select py-2" onchange="location = this.value;">
                        <option value="/" selected>Tìm theo danh mục</option>
                        <c:forEach items="${categories}" var="c">
                            <c:url value="/" var="url">
                                <c:param name="categoryID" value="${c.categoryID}" />
                            </c:url>
                            <option value="${url}">${c.name}</option>
                        </c:forEach>
                    </select>
                </li>
<<<<<<< Updated upstream
            </ul>
        </div>
=======
                <li class="nav-item ">
                    <a class="nav-link text-info" href="<c:url value="/cart" />">&#128722; <span class="badge bg-danger cart-counter">${cartStats.totalQuantity}</span></a>
                </li>
                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name == null}">
                        <li class="nav-item">
                            <a class="nav-link text-info" href="<c:url value="/login" />">Đăng nhập</a>
                        </li>
                    </c:when>
                    <c:when test="${pageContext.request.userPrincipal.name != null}">
                        <li class="nav-item">
                            <a class="nav-link text-danger" href="<c:url value="/" />">Chào ${pageContext.session.getAttribute("currentUser").firstName} ${pageContext.session.getAttribute("currentUser").lastName}!!!</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-success" href="<c:url value="/logout" />">Đăng xuất</a>
                        </li>
                    </c:when>
                </c:choose>
            </ul>
        </div>

>>>>>>> Stashed changes
        <c:url value="/" var="action"/>
        <form class="d-flex">
            <input class="form-control me-2" type="text" name="kw" placeholder="Nhập tên...">
            <button class="btn btn-primary" type="submit">Tìm</button>
        </form>
    </div>
</nav>
