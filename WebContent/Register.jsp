<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="reg.css">
<script src="validate2.js"></script>
<title>Register</title>

   


</head>
<body>
<div align="center">
<form name="form" action="RegisterServlet" method="post" onsubmit="return validates()">
	<table class="content-table">
			<tr align="center"><th colspan="2">Registration form</th></tr>
		<tbody>
			<tr><td> User Name:</td>
			<td><input type="text" name="uname" Placeholder="Enter User Name"  ></td> </tr>
			<tr><td> Email :</td>
			<td><input type="text" name="email" Placeholder="Enter Email" ></td> </tr>
			<tr><td> Password </td>
			<td><input type="password" name="pass" Placeholder="Enter Password"></td> </tr>
			<tr><td>Confirm Password:</td>
			<td><input type="password" name="pass2" Placeholder="Confirm your password"></td> </tr>
			
			<tr><td>Enter your Gender:</td>
			<td><input type="radio" name="gen" id="gens" value="Male">Male &nbsp; &nbsp;
				<input type="radio" name="gen" id="gens" value="Female">Female </td></tr>
			<tr>
				<td><input type="submit" name="submit" value="Register" ></td> 
				<td><input type="reset"  value="RESET"></td> 
			</tr>
				<tr><td colspan="2"><a href="login.jsp">Already a User Login Here</a></td>	</tr>
				
		</tbody>	
	</table>
</form>
</div>

</body>
</html>