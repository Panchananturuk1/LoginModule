<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/reg.css">

<script src="validate2.js"></script>
<title>Register</title>

   


</head>
<body>

	<div class="header" style="">
		<a href="#default" class="logo">Student Registration</a>
		  <div class="header-right">
			<a class="active" href="login.jsp">User</a>
		    <a href="Register.jsp">Register </a>
		    <a href="admin.jsp">Admin</a> 
		   </div>
	    </div>


 <div class="Loginbox"align="center">
<form name="form" action="RegisterServlet" method="post" enctype="multipart/form-data" onsubmit="return validates()">
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
				
			<tr><td>Field of Interest:</td>
				<td><select name="Interest">
						<option value="-1">Select</option>
						<option value="Software Developer">Software Developer</option>
						<option value="Frontend Developer">Frontend Developer</option>
						<option value="Backend Developer">Backend Developer</option>
						<option value="Data Science">Data Science</option>
						<option value="AI/ML">AI/ML</option>
						<option value="Block Chain">Block Chain</option>
				</select></td>
			 </tr>
			 <tr>
			 <td>Upload your Photo:</td>
			 <td><input type="file" name="image" /></td>
			 </tr>
			 
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