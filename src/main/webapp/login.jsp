<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Log In</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="css/all.min.css">
</head>
<body>
    <%@ include file="fragment/header.jsp" %>
    <c:if test="${failedLogin == true}">
        <div class="container errorLogin"><h2 id="errorElem">Incorrect login or password</h2></div>
    </c:if>
    <div class="wrapper fadeInDown">
        <div id="formContent">
            <!-- Login Form -->
            <form action="${pageContext.request.contextPath}/login" method="post">
                <input type="text" id="login" class="fadeIn second" name="login" placeholder="login">
                <input type="password" id="password" class="fadeIn third" name="password" placeholder="password">
                <input type="submit" class="fadeIn fourth" value="Log In">
            </form>
            <div id="formFooter">
                <a class="underlineHover" href="#">Forgot Password?</a>
            </div>

        </div>
    </div>
    <%@ include file="fragment/footer.jsp" %>
    <script src="https://kit.fontawesome.com/fa7e5cecef.js" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>$("#errorElem").show('slow'); setTimeout(function() { $("#errorElem").hide('slow'); }, 2000);</script>
</body>
</html>
