<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/reg.css">
<script src="log.js">



</script>
<title>User Login</title>
</head>
<body>
	 	<div class="header" style="">
		<a href="#default" class="logo">User Login</a>
		  <div class="header-right">
			<a class="active" href="login.jsp">User</a>
		    <a href="Register.jsp">Register </a>
		    <a href="admin.jsp">Admin</a> 
		   </div>
	    </div>  
	    
    
   <div class="Loginbox"align="center">
	<form name="form" action="UserProfile" method="post"  onsubmit="return validates()">
	<table class="content-table">
			<tr><th colspan="2">User Login</th></tr>
			<tr><td>Enter User name: </td> <td><input type="text" name="uname" ></td></tr>
			<tr><td>Enter Password: </td> <td><input type="password" name="pass" ></td></tr>
			<tr><td colspan="2"><input type="submit" name="submit" value="Login"></td> 	</tr>
			<tr><td><a href="Register.jsp">New User Register Here</a></td>
			<td><a href="admin.jsp">Admin Login</a></td></tr>
	</table>
	</form>
</div>

</body>
</html>