<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
<div align="center">
     <%
        Object failureMessage = request.getAttribute("failureMessage");
     
     %>
     <h2 style="background-color: purple; color:white "><%=failureMessage %></h2>
</body>
</html>