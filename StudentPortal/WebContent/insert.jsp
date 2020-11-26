<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
<script language="Javascript" src="jquery.js"></script>
<script type="text/JavaScript" src='state.js'></script>

</head>
<style>
.tab {
    display: inline-block;
    margin-left: 500px;
}
intput[type=radio] {
  padding-top: 500%;
  padding-bottom: 500%;
}
input[type=submit] {
  background-color: gray;
  border: none;
  color: white;
  text-decoration: none;
  margin-left: 100px;
  
  cursor: pointer;
  box-sizing: border-box;
  padding: 12px 20px;
  width: 100%;
}
select,input[type=text],[type=password],[type=number],[type=email],[type=tel] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;  
}


</style>

<body>
<p style="font-size:40px" align="center" >Add Student</p>
<form action ="Insert" method="post">
<table align="center">
<tr><td> RollNo</td> <td><input type="text" name="no" placeholder=" Enter Roll No" required></td></tr>
<tr><td> Name</td> <td><input type="text" name="name" placeholder=" Enter name" required></td></tr>
<tr><td>Stream</td><td><select name="stream">
<option value="Select Stream">Select Stream</option>
  <option value="Computer Science">Computer Science</option>
  <option value="Information Technology">Information Technology</option>
  <option value="Electrical">Electrical</option>
  <option value="Electroncs and Communication">Electroncs and Communication</option>
  <option value="Civil">Civil</option>
</select></td></tr>
<tr><td> Username</td> <td><input type="text" name="uname" placeholder=" Enter username" required></td></tr>
<tr><td> Password</td> <td><input type="password" name="password" placeholder=" Set Password" required></td></tr>
<tr><td> Gender</td> <td><input type="radio" name="gender" value="male"> Male
  <input type="radio" name="gender" value="female"> Female
  <input type="radio" name="gender" value="other"> Other</td></tr>
<tr><td> Email</td> <td><input type="email" name="email" placeholder=" Enter Email" required></td></tr>
<tr><td> Contact</td> <td><input type="tel" name="contact" placeholder=" Enter Number Only" pattern="[0-9]{7}([0-9]{3})?" required><small>Format: 10 or 7 digit no. without ext.</small></td></tr>
<tr><td> State</td><td><select id="listBox" onchange='selct_district(this.value)' name="state" required></select></td></tr>
<tr><td> City</td><td><select id='secondlist' name="city" required></select></td></tr>
<tr> <td><input type="submit" value="Add Student"></td></tr>
</table>
</form>

<a href="admin.jsp" class="tab" >Go Back to admin home</a>
</body>
</html>