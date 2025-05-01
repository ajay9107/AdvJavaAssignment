<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body> 
<div align="center">
       <%
          Object successMessage = request.getAttribute("successMessage");
       Object currentUser = session.getAttribute("loggedInUser");
       %>
       <h2 style="background-color: orange; color:white "><%=successMessage %> <%=currentUser %></h2>
</body>
</html>