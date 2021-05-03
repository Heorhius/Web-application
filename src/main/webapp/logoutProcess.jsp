<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@ page import="com.kaptsiug.util.CookiesUtil" %>
<%
    CookiesUtil.deleteCookies(response);
    response.sendRedirect("index.jsp");
%>
</body>
</html>