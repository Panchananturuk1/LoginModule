<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<%
	
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //  http 1.1
	response.setHeader("Pragma","no-cache"); // HTTP 1.0
	response.setHeader("Expires", "0"); // Proxy
	session.getAttribute("Password");
	session.getAttribute("Email");
		if(session.getAttribute("username")==null){
			
			response.sendRedirect("admin.jsp");
		}
	%>
	
	<script>alert("Credential Matching");</script>
	hey ${username} Welcome /............ <br>
	
	
	
	<div>
	<table border="1">
		<tbody>
			<tr>
				<th>#SL No: </th>
				<th>User Name</th>
				<th>Email  </th>
				<th>Password </th>
			
			</tr>
			<tr>
				<td></td>
				<td> ${username}</td>
				<td>${Email}</td>
				<td>${Password}</td>
			</tr>
		</tbody>
	
	</table>
</div>




</body>
</html>