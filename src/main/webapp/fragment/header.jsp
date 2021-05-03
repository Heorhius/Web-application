<%@ page import="com.kaptsiug.util.CookiesUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Header</title>
</head>
<body>
    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">BUS ST<i class="far fa-clock"></i>P</a>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <c:choose>
                        <c:when test="${CookiesUtil.getUserCookies(request) == 0}">
                            <li><a href="login.jsp"><i class="fab fa-gripfire"></i>Login</a></li>
                        </c:when>
                        <c:when test="${CookiesUtil.getUserCookies(request) != 0}">
                            <li><a href="${pageContext.request.contextPath}/logout"><i class="fas fa-concierge-bell"></i>Logout</a></li>
                        </c:when>
                    </c:choose>
                    <li><a href="profile.jsp"><i class="fas fa-scroll"></i>Profile</a></li>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>
