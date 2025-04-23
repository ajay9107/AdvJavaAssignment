<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register User</title>
<style type="text/css">
#box {
   margin :auto;
   width : 400px;
   height: auto;
}
</style>

</head>
<body>
<div id= "box">
  <h1> Login User</h1>
  <form action="login" method = "post">
  email: <input type="text" name="email"><br><br>
  password: <input type="text" name="password"><br><br>
   <input type ="submit" value= "Login">
  </form>
  </div>
</body>
</html>