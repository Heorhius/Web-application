<%@ page import="com.kaptsiug.db.UserProvider" %>
<%@ page import="java.util.List" %>
<%@ page import="com.kaptsiug.db.BusProvider" %>
<%@ page import="com.kaptsiug.model.Bus" %>
<%@ page import="com.kaptsiug.util.CookiesUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Profile</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/all.min.css">
</head>
<body>
<%@ include file="fragment/header.jsp" %>
<%
    if (CookiesUtil.getUserCookies(request) == 0) {
        response.sendRedirect("login.jsp");
    }
    BusProvider provider = BusProvider.getProvider();
    List<Bus> buses = provider.getAllBusses();
%>
<div class="container">
    <h1 class="centered">Bus schedule</h1>
    <br/>
    <div class="table-responsive">
        <table class="table table-striped">
            <thead class="thead-dark">
            <tr>
                <th scope="col">№</th>
                <th scope="col">Departure Station</th>
                <th scope="col">Arrival Station</th>

            </tr>
            </thead>
            <tbody>
            <%
                if (buses != null) {
                    for (Bus bus : buses) {
            %>
            <tr>
                <td><%=bus.getId()%>
                </td>
                <td><%=bus.getDepartureStation()%>
                </td>
                <td><%=bus.getArrivalStation()%>
                </td>
            </tr>
            <%
                    }
                }
            %>
            </tbody>
        </table>
    </div>
</div>
<br/>
<div class="bus-form">
    <div class="container">
        <div class="col-lg-4">
            <div class="formCont">
                <h2>Adding new bus</h2>
                <form action="busAddingProcess.jsp" method="post">
                    <div class="form-group">
                        <input type="text" id="departure" name="departure" placeholder="Departure station">
                    </div>
                    <div class="form-group">
                        <input type="text" id="arrival" name="arrival" placeholder="Arrival station">
                    </div>
                    <button type="submit" id="bus-submit">Add</button>
                </form>
            </div>
        </div>
    </div>
</div>
<%@ include file="fragment/footer.jsp" %>
<script src="https://kit.fontawesome.com/fa7e5cecef.js" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>