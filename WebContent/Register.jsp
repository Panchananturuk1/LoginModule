<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="RegisterServlet" method="post">
	<table border="1" align="center">
			<tr align="center"><td colspan="2"><b>Registration form</b></td></tr>
			<tr><td> User Name:</td> 	<td><input type="text" name="uname" required></td></tr>
			<tr><td> Email :</td> 		<td><input type="text" name="email" required></td></tr>
			<tr><td> Password </td> 	<td><input type="password" name="pass" required></td></tr>
			<tr><td>Confirm Password:</td> <td><input type="password" name="pass2" required></td></tr>
			<tr>
				<td><input type="submit" name="submit" value="Register"></td> 
				<td><input type="reset"  value="RESET"></td> 
			</tr>
				<tr><td colspan="2"><a href="login.jsp">Already a User Login Here</a></td>	</tr>
				
			
	</table>
</form>

</body>
</html>