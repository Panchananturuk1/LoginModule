<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="reg.css">
<title>Admin Login</title>
</head>
<body>
<form action="adminLogin" method="post">
	<table class="content-table">
			<tr><th colspan="2">Login</th></tr>
			<tr><td>Enter User name: </td> <td><input type="text" name="uname" ></td></tr>
			<tr><td>Enter Password: </td> <td><input type="password" name="pass" ></td></tr>
			<tr><td colspan="2"><input type="submit" name="submit" value="login"></td> 	</tr>
			<tr><td colspan="2"><a href="Register.jsp">New User Register Here</a></td></tr>
	</table>
</form>

</body>
</html>