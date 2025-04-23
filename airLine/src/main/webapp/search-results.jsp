<%@page import="com.airline.entity.Flight"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Result</title>
<style type="text/css">
#box {
   margin :auto;
   width : 400px;
   height: auto;
}
</style>

</head>
<body>
       <div id="box">
       <h1>Available Flights</h1>
       <%
         List<Flight> flights = (List<Flight>) request.getAttribute("flights");
         for(Flight  f : flights){
        	 %>
        	 <p>
        	     Flight Number:<%=f.getFlightNumber() %> | <%=f.getSource() %> to <%=f.getDestination() %> <br>
        	     Schedule Date:<%=f.getFlightDate()%> | price: <%=f.getPrice() %><br>
        	     <form action="bookFlight" method="post">
        	     <button>Book</button>
        	     <input type="hidden" name="flightId" value=<%=f.getId() %>>
        	     </form>
        	     <hr/>
        	 </p>
        	 
        	 <%
         }
       %>
       </div>
</body>
</html>