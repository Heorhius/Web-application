<%@ page import="com.kaptsiug.model.Bus" %>
<%@ page import="com.kaptsiug.service.BusService" %>
<%@ page import="com.kaptsiug.db.BusProvider" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String departure = request.getParameter("departure");
        String arrival = request.getParameter("arrival");

        if (departure != "" && arrival != "" && !departure.equals(arrival)) {
            Bus bus = new Bus();
            bus.setDepartureStation(departure);
            bus.setArrivalStation(arrival);

            BusProvider busProvider = BusProvider.getProvider();
            busProvider.addBus(bus);
            response.sendRedirect("profile.jsp");
        }
    %>

</body>
</html>
