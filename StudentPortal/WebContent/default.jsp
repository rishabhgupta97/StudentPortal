<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<style>
input[type=submit] {
  background-color: gray;
  border: none;
  color: white;
  text-decoration: none;
  margin: 4px 2px;
  cursor: pointer;
  margin-left: 500%;
  box-sizing: border-box;
  padding: 12px 20px;
  width: 150%;
}
input[type=text],[type=password] {
  width: 150%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  margin-left: 230%;
}


div {text-align: center;}
a{
align-self: center;
}
</style>
<body>
<p style="font-size:40px" align="center" >STUDENT PORTAL</p><br><br><br>
<h1 align="center" >Account Login</h1>

<div>
<form action ="Login" method="post">
<table>
<tr> <td><input type="text" name="uname" placeholder="Enter your username" required></td></tr>
<tr> <td><input type="password" name="password" placeholder="Enter your password" required></td></tr>
<tr><td></td> <td><input type="submit" value="login"></td></tr>

</table>
</form>
<a href="forgot.html">Forgot Password?></a> 
</div>
</body>
</html>