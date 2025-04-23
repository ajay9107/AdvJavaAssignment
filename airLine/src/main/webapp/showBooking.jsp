<%@page import="com.airline.entity.Booking"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Showing Booking</title>
</head>

<body>
<h2>Booking Details</h2>
<h3><%List<Booking> bookings=(List<Booking>)request.getAttribute("booking");
for(Booking b:bookings)
{
%>
Booking Id:<%=b.getId() %>|User Id:<%=b.getUserId() %>|Flight Id:<%=b.getFlightId()%>|Date:<%=b.getBookingDate() %>
<br>


<%} %>
</h3>
</body>
</html>