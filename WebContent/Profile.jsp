<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="prof.css">
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
			
			response.sendRedirect("login.jsp");
		}
	%>
	
	
	
	
	<table align="center" border="1">
		<tr>
		

		 
		 
		</tr>
	
	
	<%
		String us =request.getParameter("uname");
	String em =request.getParameter("email");
	String ps =request.getParameter("pass");
	 String gens =request.getParameter("gender"); 
	 String intr =request.getParameter("Interest"); 
     String img = request.getParameter("imgName");  
     
    // String imgFileName=(String)request.getAttribute("img");
	 // String imgId=(String)request.getAttribute("id");
    
  
	
	
	Connection con =null;
	Statement st = null;
	ResultSet rs=null;
	 PreparedStatement ps1,ps2;
	
	
	try{
		
		
		
		String uname = request.getParameter("uname");

		String pass = request.getParameter("pass");

		
		
		Class.forName("com.mysql.jdbc.Driver");
		con =(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","1234");
		
		st=con.createStatement();
		//String qry = "select * from hey where uname=? and pass=?";
		  ps1 = con.prepareStatement("select * from hey where uname = ? and pass=?");
		  
		  ps1.setString(1, uname);

		  ps1.setString(2, pass);
		  
          ps2 = con.prepareStatement("select * from hey");
          
       //   rs = ps2.executeQuery();
       
       rs = ps1.executeQuery();
		
		if(rs.next())
		{
			
			
		//	out.print("User Name" + rs.getString(1)+"Email:"+rs.getString(2)+"Password:"+rs.getString(3) );
		%>
		<script>alert("Credential Matching");</script>
		
		<p>Welcome <%=rs.getString(2) %> </p>
		
		<tr>
			<td><img src="img2/<%=rs.getString(8) %>" style="width:100px;height:100px"><br>
			<%=rs.getString(2) %>		
		</td>
		</tr>		
		
		<tr >	<td>ID: <%=rs.getString(1) %> </td> </tr>
		<tr> 	<td>EMAIL: <%=rs.getString(3) %> </td> </tr>
		<tr>	<td>PASSWORD: <%=rs.getString(4) %> </td> </tr>
		<tr>	<td>GENDER: <%=rs.getString(6) %> </td> </tr>
		<tr>	<td><%=rs.getString(7) %> </td> </tr>
		<tr>	<td><%=rs.getString(8) %> </td> </tr>
			
	
		
			
			<%  
		} else{
			
			out.println("USER NAME AND PASSWORD NOT MATCHING");
			//response.sendRedirect("login.jsp");
			
			%>
			<script>alert("Credential Not Matching");</script>
			<p>ERROR </p>
			<% 
			
			
		}
		
		
	}catch(Exception e){
		
	}
	%>
	</table>

<form action="Logout" method="post">
	<input type="submit" name="logout" value="Logout">
	</form>



</body>
</html>