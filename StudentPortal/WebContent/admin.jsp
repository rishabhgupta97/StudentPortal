<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
</head>
<style>
h1 {text-align: center;}
.tab {
    display: inline-block;
    margin-left: 100px;
}
</style>

<body>
<h1>Admin View Only</h1>
Logged in as:admin
<a href="logout" class="tab">Logout</a>
<hr><br>
<table align="center">
<tr><td><a href="insert.jsp">Add new student</a></td></tr>
<tr><td><br><a href="View">View All Students</a></td></tr>
<tr><td><br><a href="Search.jsp">Search Student</a></td></tr>
</table>
</body>
</html>